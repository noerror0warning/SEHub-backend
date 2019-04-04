package com.scut.se.sehubbackend.Domain;

import com.scut.se.sehubbackend.Enumeration.Department;
import org.hibernate.annotations.NaturalId;

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

    @Lob
    String introduction;

    @Lob
    Blob avatar;

}
