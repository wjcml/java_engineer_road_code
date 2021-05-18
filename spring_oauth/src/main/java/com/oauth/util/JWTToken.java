package com.oauth.util;

import org.apache.shiro.authc.AuthenticationToken;

public class JWTToken implements AuthenticationToken {
    // 密钥
    private String token;

    public JWTToken(String token) {
        this.token = token;
    }


    public Object getPrincipal() {
        return token;
    }


    public Object getCredentials() {
        return token;
    }
}
