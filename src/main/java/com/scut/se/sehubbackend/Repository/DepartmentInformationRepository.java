package com.scut.se.sehubbackend.Repository;

import com.scut.se.sehubbackend.Domain.DepartmentInformation;
import com.scut.se.sehubbackend.Enumeration.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentInformationRepository extends JpaRepository<DepartmentInformation, Department> {
}
