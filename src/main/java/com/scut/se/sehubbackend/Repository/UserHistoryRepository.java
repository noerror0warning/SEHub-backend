package com.scut.se.sehubbackend.Repository;

import com.scut.se.sehubbackend.Domain.UserHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserHistoryRepository extends JpaRepository<UserHistory,Long> {
}
