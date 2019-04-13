package com.scut.se.sehubbackend.Domain;

import com.scut.se.sehubbackend.Enumeration.Department;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
public class UserExtra implements Serializable {//用于记录人员部门职位历年信息

    private static final long serialVersionUID=1L;

    @Id
    String studentNO;//学号

    int year;//年份

    Department department;//部门

    List<GrantedAuthority> grantedAuthorities;//职位


}
