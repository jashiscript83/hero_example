package com.dario.wtm.hero.service;

import com.dario.wtm.hero.model.HeroEntity;
import com.dario.wtm.hero.repository.HeroRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.assertThat;
@SpringBootTest
class HeroServiceTest {
    @MockBean
    private HeroRepository heroRepository ;

    @Autowired
    private  HeroService heroService ;

    @Test
    void getAllHeroes() {
        // Given
        final List<HeroEntity> heroEntityList = getHeroStubList();


        // When
        when(heroRepository.findAll()).thenReturn(heroEntityList);
        final List<HeroEntity> response =  this.heroService.getAllHeroes();

        // Then
        assertThat(response).isEqualTo(heroEntityList);

    }



    @Test
    void findHeroByAlias() {
        // Given
        final List<HeroEntity> heroEntityList = getHeroStubList();


        // When
        when(heroRepository.findAll()).thenReturn(heroEntityList);
        final List<HeroEntity> response =  this.heroService.findHeroByAlias("su");

        // Then
        assertThat(response).isEqualTo(heroEntityList);

    }
    @Test
    void findHeroByAlias_NotFound() {
        // Given
        final List<HeroEntity> heroEntityList = getHeroStubList();


        // When
        when(heroRepository.findAll()).thenReturn(heroEntityList);
        final List<HeroEntity> response =  this.heroService.findHeroByAlias("cv");

        // Then
        assertThat(response).isEqualTo( new ArrayList<>());

    }


    @Test
    void getHeroById() {
        // Given
        final Optional<HeroEntity> heroEntity = Optional.ofNullable(getHeroStubList().get(0));


        // When
        when(heroRepository.findById(1L)).thenReturn(heroEntity);
        final Optional<HeroEntity> response =  this.heroService.getHeroById(1L);

        // Then
        assertThat(response).isEqualTo( heroEntity);


    }
    @Test
    void getHeroById_NotFound() {
        // Given
        final Optional<HeroEntity> heroEntity = Optional.ofNullable(getHeroStubList().get(0));


        // When
        when(heroRepository.findById(1L)).thenReturn(heroEntity);
        final Optional<HeroEntity> response =  this.heroService.getHeroById(2L);

        // Then
        assertThat(response).isNotPresent();


    }


    private List<HeroEntity> getHeroStubList(){

        List<HeroEntity> heroEntityList = new ArrayList<>();
        HeroEntity heroEntity = new HeroEntity();
        heroEntity.setId(1L);
        heroEntity.setCity("somewhere");
        heroEntity.setAlias("super");
        heroEntity.setLastName("lastname");
        heroEntity.setFirstName("name");

        heroEntityList.add(heroEntity);

        return heroEntityList;
    }



}