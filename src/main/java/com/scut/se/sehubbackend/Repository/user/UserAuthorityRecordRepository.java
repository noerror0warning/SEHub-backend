package com.scut.se.sehubbackend.Repository.user;

import com.scut.se.sehubbackend.Domain.user.UserAuthorityRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserAuthorityRecordRepository extends JpaRepository<UserAuthorityRecord,Long> {
}
