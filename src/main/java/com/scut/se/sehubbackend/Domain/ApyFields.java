package com.scut.se.sehubbackend.Domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
@Data
public class ApyFields {//所有申请表所需的字段

    @Id
    int id;//唯一的id

    String state;//状态，submit，check，finish

    String postStuId;//申请人学号者

    String postTime;//申请提交时间

    int recvDepart;//接收方部门id

    String reviseStuId;//最新修改者学号

    String reviseTime;//最新修改时间

    String checkStuId;//审核者学号

    String checkTime;//审核通过时间


}
