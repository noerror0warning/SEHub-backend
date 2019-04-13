package com.scut.se.sehubbackend.Domain.application;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Entity
public class HostsApplication implements Serializable {

    private static final Long serialVersionUID=10L;

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
    Date eventTime;

    @NotNull
    Date rehearsalTime;

    @NotNull
    int hostsAmount;

    String remarks;

}
