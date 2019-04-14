package com.scut.se.sehubbackend.Domain.user;

import lombok.*;

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

    @EqualsAndHashCode.Exclude
    @OneToOne(optional = false)
    UserAuthentication userAuthentication;

}
