package com.scut.se.sehubbackend.Repository;

import com.scut.se.sehubbackend.Domain.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Long> {

}
