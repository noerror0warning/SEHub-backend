package com.scut.se.sehubbackend.Domain;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

public class Notice {

    @Id
    @GeneratedValue
    Long id;

    @NotNull
    UserAuthentication sponsor;

    @NotNull
    UserAuthentication acceptor;

    @NotNull
    String authority;



}
