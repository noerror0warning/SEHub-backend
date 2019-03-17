package com.scut.se.sehubbackend.Filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserCache;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class InMemoryUserDetailService implements UserDetailsService {

    @Autowired
    UserCache userCache;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userCache.getUserFromCache(username);
    }
}
