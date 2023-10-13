package com.dario.wtm.hero.service;

import com.dario.wtm.hero.model.HeroEntity;

import java.util.List;
import java.util.Optional;

public interface HeroService {

     List<HeroEntity> getAllHeroes();

     List<HeroEntity> findHeroByAlias(String sex);
     Optional<HeroEntity> getHeroById(Long id);

     Optional<HeroEntity> createHero(HeroEntity heroEntity);

     Optional<HeroEntity> updateHero(String alias, String city);

     void deleteHero(String alias);
}
