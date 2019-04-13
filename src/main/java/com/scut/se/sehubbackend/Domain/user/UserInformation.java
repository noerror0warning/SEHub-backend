package com.scut.se.sehubbackend.Domain.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserInformation implements Serializable {

    private static final long serialVersionUID=2L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "`name`")
    @NotNull
    String name;

    @NotNull
    @OneToOne
    UserAuthentication userAuthentication;

}
