package com.scut.se.sehubbackend.Repository;

import com.scut.se.sehubbackend.Domain.ApplicationCommonInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicationCommonInfoRepository extends JpaRepository<ApplicationCommonInformation,Long> {
}
