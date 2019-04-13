package com.scut.se.sehubbackend.Domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
@Data
public class SELog {//部门日志表，记录所有部门的日志信息

    @Id
    int id;//日志id

    int departed;//部门id

    String time;//日志记录的时间

    int rank;//日志等级

    String type;//没想好

    String msg;//日志信息，XXX学号提交了礼仪队申请
}
