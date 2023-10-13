package com.dario.wtm.hero.service;

import com.dario.wtm.hero.error.HeroException;
import com.dario.wtm.hero.error.HeroExceptionType;
import com.dario.wtm.hero.model.HeroEntity;
import com.dario.wtm.hero.repository.HeroRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
@Slf4j
public class HeroServiceImpl implements  HeroService{
    @Autowired
    HeroRepository heroRepository;

     @Override
    public List<HeroEntity> getAllHeroes() {
         List<HeroEntity> heroEntityList = heroRepository.findAll();
         try{
             return heroRepository.findAll();

         }catch (HeroException e){
             log.error("Hero list cannot be find because database has not records");

             throw new HeroException(HeroExceptionType.RESOURCE_MISSING, "Hero list cannot be find");
         }


    }

    @Override
    public List<HeroEntity> findHeroByAlias(String seeker) {


        try{
            return  heroRepository.findAll().stream().filter(c -> c.getAlias().toLowerCase().contains(seeker)).toList();

        }catch (HeroException e){
            log.error("Hero list by sex cannot be find because there are not records with param {}", seeker);

            throw new HeroException(HeroExceptionType.RESOURCE_MISSING, "Hero list cannot be find");
        }

    }

    @Override
    public Optional<HeroEntity> getHeroById(Long id) {

        try{
            return heroRepository.findById(id);

        }catch (HeroException e){
            log.warn("Hero with id {}  cannot be find", id, e);

            return Optional.empty();

        }

    }

    @Transactional
    @Override
    public Optional<HeroEntity> createHero(HeroEntity heroEntity) {

         String alias = heroEntity.getAlias();
         if(heroRepository.findByName(alias) != null){
             log.error("Hero {} cannot be updated because it already exists", alias);
             throw new HeroException(HeroExceptionType.RESOURCE_MALFORMED, "Hero cannot be deleted updated  because it already exists");

         }else{
             return Optional.of(heroRepository.save(heroEntity));
         }


    }
    @Transactional
    @Override
    public Optional<HeroEntity> updateHero(String alias, String city) {

         HeroEntity heroEntity = heroRepository.findByName(alias);

        if(heroEntity != null) {
            heroEntity.setCity(city);
            return Optional.of(heroRepository.save(heroEntity));
        }else{

            log.error("Hero {} cannot be updated because it doesn't exist", alias);
            throw new HeroException(HeroExceptionType.RESOURCE_MALFORMED, "Hero cannot be deleted updated it doesn't exist");
        }
    }

    @Transactional
    @Override
    public void deleteHero(String alias) {

     HeroEntity heroEntity = heroRepository.findByName(alias);
     if(heroEntity != null) {
         heroRepository.delete(heroEntity);
     }else{

         log.error("Hero {} cannot be deleted because it doesn't exist", alias);
         throw new HeroException(HeroExceptionType.RESOURCE_MALFORMED, "Hero cannot be deleted because it doesn't exist");
     }
         }

}
