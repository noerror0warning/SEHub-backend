package com.scut.se.sehubbackend.Repository;

import com.scut.se.sehubbackend.Domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,String> {
}
