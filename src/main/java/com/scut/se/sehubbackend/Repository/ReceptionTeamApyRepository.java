package com.scut.se.sehubbackend.Repository;

import com.scut.se.sehubbackend.Domain.ReceptionTeamApy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReceptionTeamApyRepository extends JpaRepository<ReceptionTeamApy,Long> {

}
