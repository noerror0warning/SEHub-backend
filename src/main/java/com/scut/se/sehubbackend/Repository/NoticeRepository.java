package com.scut.se.sehubbackend.Repository;

import com.scut.se.sehubbackend.Domain.Notice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface NoticeRepository extends JpaRepository<Notice,Long> {
}
