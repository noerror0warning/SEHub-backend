package com.scut.se.sehubbackend.Domain.application;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Entity
public class EtiquetteApplication implements Serializable {

    private static final Long serialVersionUID=6L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @OneToOne
    @NotNull
    ApplicationCommonInformation commonInformation;

    @NotNull
    String name;

    @NotNull
    String site;

    @NotNull
    Date time;

    @NotNull
    int etiquetteAmount;

    @NotNull
    String task;

    String remarks;
}
