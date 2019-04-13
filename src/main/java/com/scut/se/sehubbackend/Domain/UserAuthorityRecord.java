package com.scut.se.sehubbackend.Domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
public class UserAuthorityRecord implements Serializable {

    private static final Long serialVersionUID=4L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
