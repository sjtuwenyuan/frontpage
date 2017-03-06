package com.wenyuan.seckill.service.impl;

import com.wenyuan.seckill.entity.TokenModel;
import com.wenyuan.seckill.entity.User;
import com.wenyuan.seckill.service.TokenManager;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.UUID;

/**
 * Created by Wen on 17/3/5.
 */
@Service
public class TokenManagerImpl implements TokenManager {

    private HashMap<Long, String> tokenDB = new HashMap<Long, String>();
    private HashMap<String, User> userDB = new HashMap<String, User>();

    {
        User user = new User();
        user.setId(1234567890L);
        user.setNickname("baobao");
        user.setPassword("wenyuan");
        user.setUsername("wenyuan");
        userDB.put("wenyuan", user);
    }

    public TokenModel createToken(long userId) {
        //使用uuid作为源token
        String token = UUID.randomUUID().toString().replace("-", "");
        TokenModel model = new TokenModel(userId, token);
        tokenDB.put(userId, token);
        return model;
    }

    public boolean checkToken(TokenModel model) {
        if (model == null) {
            return false;
        }
        String token = tokenDB.get(model.getUserId());
        if (token == null || !token.equals(model.getToken())) {
            return false;
        }
        return true;
    }

    public TokenModel getToken(String authentication) {
        if (authentication == null || authentication.length() == 0) {
            return null;
        }
        String[] param = authentication.split("_");
        if (param.length != 2) {
            return null;
        }
        //使用userId和源token简单拼接成的token，可以增加加密措施
        long userId = Long.parseLong(param[0]);
        String token = param[1];
        return new TokenModel(userId, token);
    }

    public void deleteToken(long userId) {

    }

    public User findByUsername(String username){
        return userDB.get(username);
    }
}
