package com.scut.se.sehubbackend.Repository.application;

import com.scut.se.sehubbackend.Domain.application.HostsApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HostsApplicationRepository extends JpaRepository<HostsApplication,Long> {
}
