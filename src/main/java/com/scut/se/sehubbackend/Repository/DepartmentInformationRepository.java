package com.scut.se.sehubbackend.Repository;

import com.scut.se.sehubbackend.Domain.DepartmentInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentInformationRepository extends JpaRepository<DepartmentInformation, Long> {
}
