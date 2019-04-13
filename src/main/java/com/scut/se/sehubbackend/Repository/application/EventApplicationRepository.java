package com.scut.se.sehubbackend.Repository.application;

import com.scut.se.sehubbackend.Domain.application.EventApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventApplicationRepository extends JpaRepository<EventApplication,Long> {
}
