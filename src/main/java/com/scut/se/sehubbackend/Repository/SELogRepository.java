package com.scut.se.sehubbackend.Repository;

import com.scut.se.sehubbackend.Domain.SELog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SELogRepository extends JpaRepository<SELog,Long> {

}
