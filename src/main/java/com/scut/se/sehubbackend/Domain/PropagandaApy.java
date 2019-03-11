package com.scut.se.sehubbackend.Domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.ArrayList;

@Entity
@Data
public class PropagandaApy {

    @Id
    Long actId;//活动id

    String postStuID;//申请人学号

    String postTime;//申请发起时间

    String actTime;//活动时间

    String actName;//活动名称

    String actAddress;//活动地点

    String actOutline;//活动简介

    String ddl;//deadline

    String contract;//联系方式

    String content;//文字内容

    String comment;//备注

    ArrayList<String> goodsInfoList;//物资信息
}
