package com.scut.se.sehubbackend.Security.Authorization.interfaces;

import com.scut.se.sehubbackend.Security.Authorization.DictionaryAuthorityMapper;
import org.springframework.security.core.GrantedAuthority;

/**
 * 字符串构建权限服务
 * 应当实现一个由输入字符串返回相应权限的功能
 * 提供了一个基本实现{@link DictionaryAuthorityMapper}
 */
public interface AuthorityMapper {

    GrantedAuthority map(String authority);
}
