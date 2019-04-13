package com.scut.se.sehubbackend.Domain;

import com.scut.se.sehubbackend.Enumeration.Department;
import com.scut.se.sehubbackend.Enumeration.Position;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Data
public class UserHistory implements Serializable {

    @Id
    @GeneratedValue
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
