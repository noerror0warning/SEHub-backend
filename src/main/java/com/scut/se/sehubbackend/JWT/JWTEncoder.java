package com.scut.se.sehubbackend.JWT;

import com.scut.se.sehubbackend.Domain.User;
import org.jose4j.jwk.RsaJsonWebKey;
import org.jose4j.jwk.RsaJwkGenerator;
import org.jose4j.jws.JsonWebSignature;
import org.jose4j.jwt.JwtClaims;
import org.jose4j.lang.JoseException;
import org.springframework.stereotype.Service;

@Service
public class JWTEncoder {

    String encode(User user) throws JoseException {
        RsaJsonWebKey rsaJsonWebKey= RsaJwkGenerator.generateJwk(Integer.parseInt("${jwt.rsa-bit}"));
        rsaJsonWebKey.setKeyId("${jwt.key-id}");

        JwtClaims jwtClaims=new JwtClaims();//创建一个jwt
        jwtClaims.setIssuer("${org.name}");//发布组织
        jwtClaims.setExpirationTimeMinutesInTheFuture(5);//过期时间
        jwtClaims.setIssuedAtToNow();//发布时间

        JsonWebSignature jsonWebSignature=new JsonWebSignature();
        jsonWebSignature.setPayload(jwtClaims.toJson());//设置Payload
//        jsonWebSignature.setK


        String jwt="";
        return jwt;
    }

}
