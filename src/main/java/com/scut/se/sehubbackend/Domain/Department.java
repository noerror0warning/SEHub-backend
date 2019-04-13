package com.scut.se.sehubbackend.Domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
@Data
public class Department {//部门表

    @Id
    int departId;//部门编号

    String departName;//部门名称

    int number;//部门人数

    String intro;//部门简介

    String avatar;//部门头像路径

}
