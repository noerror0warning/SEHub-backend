package com.scut.se.sehubbackend.Service;

import com.scut.se.sehubbackend.Domain.User;
import org.springframework.security.core.GrantedAuthority;

public interface AuthorityManager {

    Boolean addAuthority(User user, GrantedAuthority authority);

    Boolean removeAutority(User user, GrantedAuthority authority);
}
