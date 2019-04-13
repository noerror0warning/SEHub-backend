package com.scut.se.sehubbackend.Repository;

import com.scut.se.sehubbackend.Domain.MeetingRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MeetingRecordRepository extends JpaRepository<MeetingRecord,String> {
}
