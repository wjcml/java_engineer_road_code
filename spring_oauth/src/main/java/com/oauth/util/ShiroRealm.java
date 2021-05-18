package com.oauth.util;

import cn.hutool.core.util.StrUtil;
import com.oauth.entity.User;
import com.oauth.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
public class ShiroRealm extends AuthorizingRealm {
    @Autowired
    private IUserService userService;

    /**JWT签名密钥*/
    public static final String SECRET = "secret";

    /**必须重写此方法，不然Shiro会报错*/
    public boolean supports(AuthenticationToken token) {
        return token instanceof JWTToken;
    }

    /**
     * 该方法一般可以用来设置角色权限
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    /**
     * Authentication 是用来验证用户身份
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String token = (String) authenticationToken.getCredentials();
        // 解密获得username，用于和数据库进行对比
        String username = JwtUtil.getUsername(token);
        if (StrUtil.isBlank(username)) {
            throw new AuthenticationException("无效token");
        }

        User user = userService.findUserByName(username);

        if (user == null) {
            throw new AuthenticationException("用户不存在");
        }

        JwtUtil.verify(token);

        return new SimpleAuthenticationInfo(token, token, "shiro_realm");
    }
}
