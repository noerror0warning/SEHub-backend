package com.scut.se.sehubbackend.Domain;

import com.scut.se.sehubbackend.Enumeration.Department;
import org.hibernate.annotations.NaturalId;

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

    @Lob
    String introduction;

    Blob avatar;
}
