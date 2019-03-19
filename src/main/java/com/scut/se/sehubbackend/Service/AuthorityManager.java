package com.scut.se.sehubbackend.Service;

import com.scut.se.sehubbackend.Domain.User;
import org.springframework.security.core.GrantedAuthority;

/*
* 权限管理者
* 应当实现的功能应当包括增加、移除劝降等等，同时还提供通过字符串生成权限的功能
*
*
* */
public interface AuthorityManager {

    Boolean addAuthority(User user, GrantedAuthority authority);

    Boolean removeAuthority(User user, GrantedAuthority authority);

    GrantedAuthority generateAuthority(String authority);
}
