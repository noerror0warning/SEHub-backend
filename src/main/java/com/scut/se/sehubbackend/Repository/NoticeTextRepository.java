package com.scut.se.sehubbackend.Repository;


import com.scut.se.sehubbackend.Domain.NoticeText;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoticeTextRepository extends JpaRepository<NoticeText,Long> {

}
