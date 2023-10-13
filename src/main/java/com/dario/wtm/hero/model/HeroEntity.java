package com.dario.wtm.hero.model;

import lombok.*;

import javax.persistence.*;
import static javax.persistence.GenerationType.IDENTITY;
@Data
@Entity(name = "Heroes")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HeroEntity {

        @Id
        @GeneratedValue(strategy = IDENTITY)
        @Column(name = "Id")
        private Long id;

        @Column(name = "LastName")
        private String lastName;

        @Column(name = "FirstName")
        private String firstName;

        @Column(name = "Alias")
        private String alias;

        @Column(name = "City")
        private String city;


}
