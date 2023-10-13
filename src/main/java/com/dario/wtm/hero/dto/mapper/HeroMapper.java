package com.dario.wtm.hero.dto.mapper;

import com.dario.wtm.hero.dto.HeroRequestDTO;
import com.dario.wtm.hero.model.HeroEntity;

public class HeroMapper {

    public static HeroEntity toModel(HeroRequestDTO source){

        HeroEntity heroEntity = new HeroEntity();
        heroEntity.setAlias(source.getAlias());
        heroEntity.setCity(source.getCity());
        heroEntity.setFirstName(source.getFirstName());
        heroEntity.setLastName(source.getLastName());

        return heroEntity;
    }

}
