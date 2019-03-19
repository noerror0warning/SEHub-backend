package com.scut.se.sehubbackend.Service;

import org.springframework.security.core.GrantedAuthority;

public interface AuthorityMapper {

    GrantedAuthority map(String authority);
}
