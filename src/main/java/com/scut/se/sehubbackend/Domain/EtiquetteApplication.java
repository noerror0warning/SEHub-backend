package com.scut.se.sehubbackend.Domain;

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
    ApplicationCommonInfo commonInfo;

    @NotNull
    String eventName;

    @NotNull
    String eventSite;

    @NotNull
    Date eventTime;

    @NotNull
    Integer etiquetteAmount;

    @Lob
    String remarks;
}
