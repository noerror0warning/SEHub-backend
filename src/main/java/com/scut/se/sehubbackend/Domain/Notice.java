package com.scut.se.sehubbackend.Domain;

import com.scut.se.sehubbackend.Domain.user.UserAuthentication;
import com.scut.se.sehubbackend.Enumeration.NoticeType;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
public class Notice implements Serializable {

    private static final Long serialVersionUID=8L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @NotNull
    @Enumerated(EnumType.STRING)
    NoticeType type;

    @OneToOne
    UserAuthentication sponsor;

    @OneToOne
    @NotNull
    UserAuthentication acceptor;

    @NotNull
    Long principalId;

    @Lob
    String remarks;
}
