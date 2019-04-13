package com.scut.se.sehubbackend.Repository;

import com.scut.se.sehubbackend.Domain.Materials;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaterialsRepository extends JpaRepository<Materials,Long> {

}
