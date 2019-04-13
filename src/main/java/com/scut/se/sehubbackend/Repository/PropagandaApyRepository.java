package com.scut.se.sehubbackend.Repository;

import com.scut.se.sehubbackend.Domain.PropagandaApy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PropagandaApyRepository extends JpaRepository<PropagandaApy,Long> {

}
