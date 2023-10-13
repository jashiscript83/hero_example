package com.dario.wtm.hero.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class HeroRequestDTO {
    private String lastName;
    private String firstName;
    private String alias;
    private String city;


}
