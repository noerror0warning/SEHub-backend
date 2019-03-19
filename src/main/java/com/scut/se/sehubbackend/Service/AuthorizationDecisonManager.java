package com.scut.se.sehubbackend.Service;

import com.scut.se.sehubbackend.Domain.User;
import org.springframework.security.core.GrantedAuthority;

public interface AuthorizationDecisonManager {

    public Boolean decide(User user, GrantedAuthority dynamicAuthority);

}
