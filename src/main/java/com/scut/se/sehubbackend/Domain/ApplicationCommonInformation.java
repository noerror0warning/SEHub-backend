package com.scut.se.sehubbackend.Domain;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
@Data
public class ApplicationCommonInformation {

    @Id
    @GeneratedValue
    Long id;

    @OneToOne
    @NotNull
    UserAuthentication sponsor;

    @ManyToMany
    @NotNull
    Set<UserAuthentication> acceptors;

}
