package com.dario.wtm.hero.repository;

import com.dario.wtm.hero.model.HeroEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface HeroRepository extends JpaRepository<HeroEntity, Long> {
    @Query(value = "SELECT * FROM Heroes WHERE Alias=?",nativeQuery = true)
    HeroEntity findByName(String alias);

}

