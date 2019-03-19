package com.scut.se.sehubbackend.Service;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

@Service
public class HashAuthorityMapper implements AuthorityMapper {
    @Override
    public GrantedAuthority map(String authority) {
        return null;
    }
}
