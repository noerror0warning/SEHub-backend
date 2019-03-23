package com.scut.se.sehubbackend.Security.Authorization.interfaces;

import com.scut.se.sehubbackend.Security.Authorization.PositionAndDepartmentBasedAuthorizationDecisionManger;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * 提供权限变更是否有权进行的决策服务
 * 决定{@code operator}对{@code user}的权限是否有权变更
 * 提供了一个基于职位和部门的默认实现{@link PositionAndDepartmentBasedAuthorizationDecisionManger}
 */
public interface AuthorizationDecisionManager {

    public Boolean decide(UserDetails operator,UserDetails user, GrantedAuthority dynamicAuthority);


}
