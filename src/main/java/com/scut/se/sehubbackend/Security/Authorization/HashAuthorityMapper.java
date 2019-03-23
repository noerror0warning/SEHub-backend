package com.scut.se.sehubbackend.Security.Authorization;

import com.scut.se.sehubbackend.Enumeration.Department;
import com.scut.se.sehubbackend.Enumeration.Position;
import com.scut.se.sehubbackend.Security.Authorization.interfaces.AuthorityMapper;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * 一个简单的权限映射策略
 * 用于规范输入字符串
 */
@Service
public class HashAuthorityMapper implements AuthorityMapper {

    Map<String,GrantedAuthority> authorityMapper =new HashMap<>();
    private static final String STANDING_COMMITTEE_PREFIX=Position.StandingCommittee+"_";
    private static final String MINISTER_PREFIX = Position.Minister.toString()+"_";
    private static final String STUFF_PREFIX=Position.Staff.toString()+"_";
    private static final String MUTABLE_PREFIX="Dynamic_";


    public HashAuthorityMapper(){
        //将预定义的权限放入字典中
        authorityMapper.put(Position.StandingCommittee.toString(),new SimpleGrantedAuthority(STANDING_COMMITTEE_PREFIX));//常委权限
        for (Department department: Department.values()){
            //部长权限
            authorityMapper.put(MINISTER_PREFIX +department.toString(),new SimpleGrantedAuthority(MINISTER_PREFIX +department.toString()));
            //部员权限
            authorityMapper.put(STUFF_PREFIX +department.toString(),new SimpleGrantedAuthority(STUFF_PREFIX +department.toString()));
            //部门动态权限
            authorityMapper.put(MUTABLE_PREFIX+department.toString(),new SimpleGrantedAuthority(MUTABLE_PREFIX+department.toString()));
        }
    }

    @Override
    public GrantedAuthority map(String authority) {
        return authorityMapper.get(authority);
    }

}
