package com.scut.se.sehubbackend.Domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PropagandaApplicationRepository extends JpaRepository<PropagandaApplication,Long> {
}
