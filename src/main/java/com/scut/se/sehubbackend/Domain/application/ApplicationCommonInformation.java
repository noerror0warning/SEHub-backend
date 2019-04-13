package com.scut.se.sehubbackend.Domain.application;

import com.scut.se.sehubbackend.Domain.user.UserAuthentication;
import com.scut.se.sehubbackend.Enumeration.ApprovalStatus;
import com.scut.se.sehubbackend.Enumeration.Department;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@Data
public class ApplicationCommonInformation implements Serializable {

    private static final Long serialVersionUID=3L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Enumerated(value = EnumType.STRING)
    @NotNull
    ApprovalStatus status;

    @NotNull
    Date submission;

    @Column(name = "`check`")
    Date check;

    @NotNull
    Date lastModified;

    @NotNull
    @OneToOne
    UserAuthentication lastToModify;

    @OneToOne
    @NotNull
    UserAuthentication sponsor;

    @Enumerated(value = EnumType.STRING)
    @NotNull
    Department acceptDepartment;

    @OneToMany
    @NotNull
    Set<UserAuthentication> acceptors;

}
