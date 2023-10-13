package com.dario.wtm.hero.controller;

import com.dario.wtm.hero.dto.HeroRequestDTO;
import com.dario.wtm.hero.dto.mapper.HeroMapper;
import com.dario.wtm.hero.error.HeroException;
import com.dario.wtm.hero.error.HeroExceptionType;
import com.dario.wtm.hero.model.HeroEntity;
import com.dario.wtm.hero.service.HeroService;
import lombok.AllArgsConstructor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping("heroes")
@Slf4j
public class HeroController {
    private final HeroService  heroService;

    @GetMapping( produces = "application/json")
    public ResponseEntity<List<HeroEntity>> getHeroes() {
        try {
            List<HeroEntity> heroEntities =  this.heroService.getAllHeroes();

            return  ResponseEntity.ok().body(heroEntities);

        }catch (HeroException e){
            throw new HeroException(HeroExceptionType.RESOURCE_MISSING, "Database is not available");
        }
    }

    @GetMapping( value = "/{seeker}", produces = "application/json")
    public ResponseEntity<List<HeroEntity>> getHeroesBySex(@PathVariable String seeker) {

        try {
            List<HeroEntity> heroEntities =  this.heroService.findHeroByAlias(seeker);
            return  ResponseEntity.ok().body(heroEntities);

        }catch (HeroException e){
            log.error("Resource not found with param: {}", seeker);
            throw new HeroException(HeroExceptionType.RESOURCE_MALFORMED, "Resource not found");
        }

    }
    @GetMapping( value = "/hero/{id}", produces = "application/json")
    public ResponseEntity<Optional<HeroEntity>> getHeroById(@PathVariable Long id) {

        try {
            Optional<HeroEntity> heroEntities =  this.heroService.getHeroById(id);
            return  ResponseEntity.ok().body(heroEntities);

        }catch (HeroException e){
            log.error("Resource not found with id: {}", id);
            throw new HeroException(HeroExceptionType.RESOURCE_MALFORMED, "Resource not found");
        }
    }
    @PostMapping("/hero/create")
    public ResponseEntity<HeroRequestDTO> createHero(@RequestBody HeroRequestDTO heroRequestDTO) {

        try {
            this.heroService.createHero(HeroMapper.toModel(heroRequestDTO));
            return  ResponseEntity.ok().body(heroRequestDTO);

        }catch (HeroException e){
            log.error("Hero could not be created with request: {}", heroRequestDTO);
            throw new HeroException(HeroExceptionType.RESOURCE_MALFORMED, "Entity not created");
        }

    }
    @PutMapping("/hero/update")
    public ResponseEntity<HeroRequestDTO> updateHero(@RequestBody HeroRequestDTO heroRequestDTO) {

        try {
            this.heroService.updateHero(HeroMapper.toModel(heroRequestDTO).getAlias(), HeroMapper.toModel(heroRequestDTO).getCity());
            return  ResponseEntity.ok().body(heroRequestDTO);

        }catch (HeroException e){
            log.error("Resource not updated with request: {}", heroRequestDTO);
            throw new HeroException(HeroExceptionType.RESOURCE_MALFORMED, "Resource malformed");
        }


    }
    @DeleteMapping("/hero/delete/{alias}")
    public ResponseEntity<Object> deleteHero(@PathVariable  String alias) {
        try {
            this.heroService.deleteHero(alias);
            return  new ResponseEntity<>(HttpStatus.ACCEPTED);

        }catch (HeroException e){
            log.error("Resource not deleted with alias: {}", alias);
            throw new HeroException(HeroExceptionType.RESOURCE_MALFORMED, "Resource malformed");
        }

    }
}
