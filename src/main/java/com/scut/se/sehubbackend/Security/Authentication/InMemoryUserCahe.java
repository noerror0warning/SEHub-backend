package com.scut.se.sehubbackend.Security.Authentication;

import com.scut.se.sehubbackend.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserCache;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class InMemoryUserCahe implements UserCache {

    List<UserDetails> userDetailsList;

    @Override
    public UserDetails getUserFromCache(String username) {
        for (UserDetails userDetails:userDetailsList) {//在信息列表中查找
            if (username==userDetails.getUsername())//学号匹配时返回用户信息
                return  userDetails;
        }
        return null;//查找失败时返回null
    }

    @Autowired
    public void InMemoryUserCache(UserRepository userRepository){
        userDetailsList=new ArrayList<UserDetails>();//初始化
        List<com.scut.se.sehubbackend.Domain.User> users=userRepository.findAll();//数据库中读取信息
        for (com.scut.se.sehubbackend.Domain.User user: users) {//将数据库中权限读入缓存中
            userDetailsList.add(new User(
                    user.getStudentNO(),
                    user.getPassword(),
                    user.getGrantedAuthorities()));
        }
    }

    @Override
    public void putUserInCache(UserDetails user) {

    }

    @Override
    public void removeUserFromCache(String username) {

    }

}
