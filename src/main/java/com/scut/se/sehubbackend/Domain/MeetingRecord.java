package com.scut.se.sehubbackend.Domain;

import com.scut.se.sehubbackend.Enumeration.ApprovalStatus;
import com.scut.se.sehubbackend.Enumeration.Department;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
public class MeetingRecord implements Serializable {

    private static final long serialVersionUID=2L;

    @Id
    String meetingId;

    Date date;

    Department department;

    User absent[];

    String content;

    String assignment;

    ApprovalStatus approvalStatus;
}
