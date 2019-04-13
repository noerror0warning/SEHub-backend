package com.scut.se.sehubbackend.Domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
@Data
public class Receiver {//该表用于记录申请表的默认接收者，用于通知接收者和审核是否有权限修改申请表状态

    @Id
    String type;//申请表类型

    @Id
    String receiver;//接收者的学号
}
