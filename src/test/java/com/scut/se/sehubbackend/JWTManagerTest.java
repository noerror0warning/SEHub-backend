package com.scut.se.sehubbackend;


import com.scut.se.sehubbackend.Domain.User;
import com.scut.se.sehubbackend.JWT.JWTManager;
import org.jose4j.jwt.MalformedClaimException;
import org.jose4j.jwt.consumer.InvalidJwtException;
import org.jose4j.lang.JoseException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SeHubBackendApplication.class)
public class JWTManagerTest {

    @Autowired
    JWTManager jwtManager;

    @Mock
    User user;

    @Before
    public void before(){
        when(user.getStudentNO()).thenReturn("201730683314");
    }

    @Test
    public void testEncodeAndDecode() throws JoseException, MalformedClaimException, InvalidJwtException {
        String jwt=jwtManager.encode(user);//对user编码
        User edUser=jwtManager.decode(jwt);//再解码
        Assert.assertEquals(user.getStudentNO(),edUser.getStudentNO());//两者的studentNO应该一样
    }
}
