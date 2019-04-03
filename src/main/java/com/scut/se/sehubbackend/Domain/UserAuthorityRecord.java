package com.scut.se.sehubbackend.Domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class UserAuthorityRecord {

    @Id
    @GeneratedValue
    Long id;

    @ManyToOne
    @Setter
    @Getter
    @NotNull
    UserAuthentication owner;

    @NotNull
    @Getter
    @Setter
    @NotNull
    String authority;

}
