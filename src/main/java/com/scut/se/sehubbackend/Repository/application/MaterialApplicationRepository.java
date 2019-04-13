package com.scut.se.sehubbackend.Repository.application;

import com.scut.se.sehubbackend.Domain.application.MaterialApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaterialApplicationRepository extends JpaRepository<MaterialApplication,Long> {
}
