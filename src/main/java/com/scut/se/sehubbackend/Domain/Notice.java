package com.scut.se.sehubbackend.Domain;

<<<<<<< HEAD
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

public class Notice {

    @Id
    @GeneratedValue
    Long id;

    @NotNull
    UserAuthentication sponsor;

=======
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
>>>>>>> origin/domain
    @NotNull
    UserAuthentication acceptor;

    @NotNull
<<<<<<< HEAD
    String authority;



=======
    Long principalId;

    @Lob
    String remarks;
>>>>>>> origin/domain
}
