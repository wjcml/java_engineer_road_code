package com.oauth.util;

import cn.hutool.core.date.DateUtil;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.common.ServiceException;
import com.oauth.entity.User;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * jwt工具类
 */
@Slf4j
public class JwtUtil {

    public static final String USER_ID = "user_id";
    public static final String USERNAME = "username";
    public static final String PHONE = "phone";

    // 过期时间5分钟
    private static final long EXPIRE_TIME = 5 * 60 * 1000;

    /**
     * 生成签名,5min后过期
     * @return token
     */
    public static String createToken(User user) {
        Date date = new Date(System.currentTimeMillis() + EXPIRE_TIME);
        Algorithm algorithm = Algorithm.HMAC256(user.getPassword());

        // 附带user_id, username, phone信息
        return JWT.create()
                .withClaim(USER_ID, user.getId())
                .withClaim(USERNAME, user.getUsername())
                .withClaim(PHONE, user.getPhone())
                .withExpiresAt(date)
                .sign(algorithm);
    }

    /**
     * 校验
     */
    public static boolean verify(String token) {
        DecodedJWT decodedJWT = JWT.decode(token);
        if (decodedJWT == null){
            throw new ServiceException("请求未授权");
        }

        if (decodedJWT.getExpiresAt().before(DateUtil.date())){
            throw new ServiceException("token已失效");
        }

        return true;
    }

    /**
     * 获取user_id
     */
    public static String getUserId(String token) {
        DecodedJWT jwt = JWT.decode(token);
        return jwt.getClaim(USER_ID).asString();
    }

    /**
     * 获取username
     */
    public static String getUsername(String token) {
        DecodedJWT jwt = JWT.decode(token);
        return jwt.getClaim(USERNAME).asString();
    }
}
