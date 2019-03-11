package com.scut.se.sehubbackend.Domain;

import com.scut.se.sehubbackend.Enumeration.Department;
import com.scut.se.sehubbackend.Enumeration.Position;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Data
@Entity
public class User implements Serializable {

    private static final long serialVersionUID=1L;

    @Id
    String studentNO;//学号

    String name;//姓名

    Department department;//部门

    Position position;//职位

    String password;//密码

}
