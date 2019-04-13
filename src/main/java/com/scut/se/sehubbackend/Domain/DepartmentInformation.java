package com.scut.se.sehubbackend.Domain;

import com.scut.se.sehubbackend.Enumeration.Department;
import org.hibernate.annotations.NaturalId;

<<<<<<< HEAD
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.validation.constraints.NotNull;
import java.sql.Blob;

public class DepartmentInformation {

    @Id
    @GeneratedValue
    Long id;

    @NotNull
    @NaturalId
    Department department;

    @NotNull
    int memberAmount;
=======
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.sql.Blob;

@Entity
public class DepartmentInformation implements Serializable {

    private static final Long serialVersionUID=7L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @NaturalId
    @Enumerated(value = EnumType.STRING)
    @NotNull
    Department departmentName;

    @NotNull
    Integer peopleIn;
>>>>>>> origin/domain

    @Lob
    String introduction;

<<<<<<< HEAD
    Blob avatar;
=======
    @Lob
    Blob avatar;

>>>>>>> origin/domain
}
