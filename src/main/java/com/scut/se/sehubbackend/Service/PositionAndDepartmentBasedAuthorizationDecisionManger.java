package com.scut.se.sehubbackend.Service;

import com.scut.se.sehubbackend.Domain.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

@Service
public class PositionAndDepartmentBasedAuthorizationDecisionManger implements AuthorizationDecisionManager {
    @Override
    public Boolean decide(User user, GrantedAuthority dynamicAuthority) {
        return null;
    }
}
