package com.scut.se.sehubbackend.Domain.application;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
public class PublicityApplication implements Serializable {

    private static final Long serialVersionUID=13L;

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
    Date time;

    @NotNull
    Date deadline;

    @NotNull
    String introduction;

    @ElementCollection
    List<String> materialList;

    String content;

    String remarks;
}
