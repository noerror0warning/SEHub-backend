package com.scut.se.sehubbackend.Domain.application;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
public class MaterialApplication implements Serializable {

    private static final Long serialVersionUID=14L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @NotNull
    @OneToOne
    ApplicationCommonInformation commonInformation;

    @NotNull
    String name;

    @NotNull
    String site;

    @NotNull
    Date lend;

    @NotNull
    Date _return;

    @NotNull
    @ElementCollection
    List<String> materialList;

    String remarks;

}
