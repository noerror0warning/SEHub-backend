package com.scut.se.sehubbackend.Domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
@Data
public class Notice {//通知数据表

    @Id
    int id;//通知id

    String type;//通知类型

    String initiator;//通知的发起者

    String receiver;//通知的接收者

    int key;//通知信息的id，一般放申请表的id

    int info;//通知附加信息的id，放notice_text的id


}
