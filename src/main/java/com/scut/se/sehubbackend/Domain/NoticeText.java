package com.scut.se.sehubbackend.Domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
@Data
public class NoticeText {//通知附加信息的表，一般用于申请表审核回应消息

    @Id
    int id;//id

    String info;//存放大段文字，一般用于，当申请接收者审核不过某申请时，可以附加一些审核不通过的信息。


}
