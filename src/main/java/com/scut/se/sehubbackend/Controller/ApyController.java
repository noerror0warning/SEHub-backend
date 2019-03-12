package com.scut.se.sehubbackend.Controller;

import com.scut.se.sehubbackend.Domain.PropagandaApy;
import com.scut.se.sehubbackend.Service.ApyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("${request.uri.application.prefix}")
public class ApyController {

    @Autowired
    ApyService apyService;

    @PostMapping("${request.uri.application.propaganda}")
    int postPropagandaApy(@RequestBody PropagandaApy propagandaApy){//创建海报申请
        return apyService.createPropagandaApy(propagandaApy);
    }

}
