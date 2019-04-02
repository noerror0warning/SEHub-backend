package com.scut.se.sehubbackend.Domain;

import lombok.Builder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Builder
public class PropagandaApplication implements Serializable {

    private static final Long serialVersionUID=3L;

    @Id
    @GeneratedValue
    Long eventId;

    @ManyToOne
    UserDetail sponsor;

    @ManyToMany
    Set<UserDetail> acceptors;

}
