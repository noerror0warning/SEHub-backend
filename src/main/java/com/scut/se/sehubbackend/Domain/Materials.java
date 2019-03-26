package com.scut.se.sehubbackend.Domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
@Data
public class Materials {//物资编号

    @Id
    String matId;//通知id

    String name;//物资名称

    int number;//物资数量

    String unit;//计量单位

    String other;//其他的描述

}
