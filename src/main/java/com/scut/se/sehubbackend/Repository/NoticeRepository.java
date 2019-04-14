package com.scut.se.sehubbackend.Repository;

import com.scut.se.sehubbackend.Domain.Notice;
import com.scut.se.sehubbackend.Domain.user.UserAuthentication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface NoticeRepository extends JpaRepository<Notice,Long> {

    List<Notice> findAllByAcceptor(UserAuthentication acceptor);
}
