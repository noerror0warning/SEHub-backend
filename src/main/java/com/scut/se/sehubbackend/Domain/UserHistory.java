package com.scut.se.sehubbackend.Domain;

import com.scut.se.sehubbackend.Enumeration.Department;
import com.scut.se.sehubbackend.Enumeration.Position;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
public class UserHistory implements Serializable {

    @Id
    @GeneratedValue
    Long id;

    @Enumerated(EnumType.STRING)
    Department department;

    @Enumerated(EnumType.STRING)
    Position position;

    @ManyToOne
    UserAuthentication userAuthentication;
}
