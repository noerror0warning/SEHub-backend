package com.scut.se.sehubbackend.Repository;

import com.scut.se.sehubbackend.Domain.ApyFields;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApyFieldsRepository extends JpaRepository<ApyFields,Long> {

}
