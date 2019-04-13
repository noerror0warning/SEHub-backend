package com.scut.se.sehubbackend.Repository;

import com.scut.se.sehubbackend.Domain.Receiver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReceiverRepository extends JpaRepository<Receiver,Long> {

}
