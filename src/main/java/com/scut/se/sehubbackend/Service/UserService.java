package com.scut.se.sehubbackend.Service;

import com.scut.se.sehubbackend.Domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserService extends JpaRepository<User,String> {
}
