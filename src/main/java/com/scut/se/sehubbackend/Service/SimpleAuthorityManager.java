package com.scut.se.sehubbackend.Service;

import com.scut.se.sehubbackend.Domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

@Service
public class SimpleAuthorityManager implements AuthorityManager {

    @Autowired AuthorityMapper mapper;

    @Override
    public Boolean addAuthority(User user, GrantedAuthority authority) {
        return null;
    }

    @Override
    public Boolean removeAuthority(User user, GrantedAuthority authority) {
        return null;
    }

    @Override
    public GrantedAuthority generateAuthority(String authority) {
        return null;
    }
}
