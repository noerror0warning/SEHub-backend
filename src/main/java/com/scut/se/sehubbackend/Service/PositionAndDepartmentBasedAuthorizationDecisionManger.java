package com.scut.se.sehubbackend.Service;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;


/**
 * 一个基于部门和职位进行决策的实现，可参考{@link AuthorizationDecisionManager}
 * 决策的依据是：
 * 1.{@code operator}与{@code user}应位于相同部门
 * 2.{@code operator}的职位应高于{@code user}
 */
@Service
public class PositionAndDepartmentBasedAuthorizationDecisionManger implements AuthorizationDecisionManager {


    @Override
    public Boolean decide(UserDetails operator, UserDetails user, GrantedAuthority dynamicAuthority) {
        if(isNotImmutable(dynamicAuthority)){
        }
        return false;
    }

    Boolean isNotImmutable(GrantedAuthority dynamicAuthority){
        return true;
    }
}
