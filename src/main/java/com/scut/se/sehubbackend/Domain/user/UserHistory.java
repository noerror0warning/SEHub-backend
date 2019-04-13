package com.scut.se.sehubbackend.Domain.user;

import com.scut.se.sehubbackend.Enumeration.Department;
import com.scut.se.sehubbackend.Enumeration.Position;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Data
@Builder
public class UserHistory implements Serializable {

    private static final Long serialVersionUID=5L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @NotNull
    Long year;

    @Enumerated(EnumType.STRING)
    Department department;

    @NotNull
    @Enumerated(EnumType.STRING)
    Position position;

    @ManyToOne
    @NotNull
    UserAuthentication userAuthentication;
}
