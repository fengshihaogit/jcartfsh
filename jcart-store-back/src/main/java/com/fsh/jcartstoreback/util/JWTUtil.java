package com.fsh.jcartstoreback.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fsh.jcartstoreback.dto.out.CustomerLoginOutDTO;
import com.fsh.jcartstoreback.po.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author Mr.Blake
 * @create 2020-03-01 17:35
 */
@Component
public class JWTUtil {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Value("${jwt.valid.duration}")
    private Long jwtValidDuration;

    @Value("${jwt.issuer}")
    private String issuer;

    private Algorithm algorithm;

    public JWTUtil(@Value("${jwt.HS256.secret}") String jwtHS256Secret) {
        logger.info("init jwt util");
        algorithm = Algorithm.HMAC256(jwtHS256Secret);
    }

    public CustomerLoginOutDTO issueToken(Customer customer) {
        Date now = new Date();
        long nowTimestamp = now.getTime();
        long expireTimestamp = nowTimestamp + jwtValidDuration;
        Date expireTime = new Date(expireTimestamp);
        Integer customerId = customer.getCustomerId();
        String username = customer.getUsername();

        String token = JWT.create()
                .withIssuer(issuer)
                .withIssuedAt(now)
                .withSubject(username)
                .withClaim("customerId", customerId)
                .withExpiresAt(expireTime)
                .sign(algorithm);

        logger.info("jwt token: {}", token);
        logger.info("jwt expire date: {}", expireTimestamp);
        CustomerLoginOutDTO customerLoginOutDTO = new CustomerLoginOutDTO();
        customerLoginOutDTO.setToken(token);
        customerLoginOutDTO.setExpireTimestamp(expireTimestamp);

        return customerLoginOutDTO;
    }

//    public AdministratorLoginVO verifyToken(String token) {
//        JWTVerifier verifier = JWT.require(algorithm)
//                .withIssuer(issuer)
//                .build();
//        DecodedJWT jwt;
//        jwt = verifier.verify(token);
//
//        AdministratorLoginVO administratorLoginVO = new AdministratorLoginVO();
//        administratorLoginVO.setAdministratorId(jwt.getClaim("administratorId").asInt());
//        administratorLoginVO.setUsername(jwt.getSubject());
//        return administratorLoginVO;
//    }
}