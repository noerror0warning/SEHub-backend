package com.scut.se.sehubbackend.Domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
@Data
public class ReceptionTeamApy {//礼仪队申请表

    @Id
    int id;//申请表id

    int apyFieldsId;//ApyFields id

    String phoneNum;//负责人电话

    String apyName;//活动名称

    String apyTimer;//活动时间

    String apyPlace;//活动地点

    int receNumber;//礼仪队队员人数

    String itemsName;//需要项目名称

    String info;//备注

}
