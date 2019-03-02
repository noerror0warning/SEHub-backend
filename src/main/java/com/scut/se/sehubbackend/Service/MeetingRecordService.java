package com.scut.se.sehubbackend.Service;

import com.scut.se.sehubbackend.Domain.MeetingRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MeetingRecordService extends JpaRepository<MeetingRecord,String> {
}
