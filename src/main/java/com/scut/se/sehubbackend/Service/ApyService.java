package com.scut.se.sehubbackend.Service;

import com.scut.se.sehubbackend.Domain.PropagandaApy;
import com.scut.se.sehubbackend.Repository.PropagandaApyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApyService {
    @Autowired
    PropagandaApyRepository propagandaApyRepository;

    public int createPropagandaApy(PropagandaApy propagandaApy){
        return 0;
    }

}
