package com.scut.se.sehubbackend.Repository;

import com.scut.se.sehubbackend.Domain.UserAuthorityRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserAuthorityRecordRepository extends JpaRepository<UserAuthorityRecord,Long> {
}
