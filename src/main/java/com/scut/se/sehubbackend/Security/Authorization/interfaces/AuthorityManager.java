package com.scut.se.sehubbackend.Security.Authorization.interfaces;

import com.scut.se.sehubbackend.Security.Authorization.SimpleAuthorityManager;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * 权限管理服务
 * 应当实现的功能应当包括增加、移除劝降等等，同时还提供通过字符串生成权限的功能
 * 具体的实现类可以参考{@link SimpleAuthorityManager}
* */
public interface AuthorityManager {

    Boolean addAuthority(UserDetails user, GrantedAuthority authority);

    Boolean removeAuthority(UserDetails user, GrantedAuthority authority);

    GrantedAuthority generateAuthority(String authority);
}
