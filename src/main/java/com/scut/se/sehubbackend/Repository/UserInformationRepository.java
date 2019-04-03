package com.scut.se.sehubbackend.Repository;

import com.scut.se.sehubbackend.Domain.UserInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserInformationRepository extends JpaRepository<UserInformation,String> {
}
