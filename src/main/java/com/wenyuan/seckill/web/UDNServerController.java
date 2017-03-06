package com.wenyuan.seckill.web;

import com.wenyuan.seckill.dto.ResultModel;
import com.wenyuan.seckill.dto.ResultStatus;
import com.wenyuan.seckill.entity.TokenModel;
import com.wenyuan.seckill.entity.User;
import com.wenyuan.seckill.service.TokenManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Created by Wen on 17/3/5.
 */
@Controller
public class UDNServerController extends BaseExceptionHandleAction {

    @Autowired
    private TokenManager tokenManager;

    final private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss");

    @RequestMapping(value = "/tokens",
            method = RequestMethod.POST)
    public ResponseEntity<ResultModel> login(@RequestParam String username, @RequestParam String password) throws ParseException {
        Assert.notNull(username, "username can not be empty");
        Assert.notNull(password, "password can not be empty");
        User user = tokenManager.findByUsername(username);
        if (user == null ||  //未注册
                !user.getPassword().equals(password)) {  //密码错误
            //提示用户名或密码错误
            return new ResponseEntity<ResultModel>(ResultModel.error(ResultStatus.USERNAME_OR_PASSWORD_ERROR), HttpStatus.NOT_FOUND);
        }
        //生成一个token，保存用户登录状态
        TokenModel model = tokenManager.createToken(user.getId());
        return new ResponseEntity<ResultModel>(ResultModel.ok(model), HttpStatus.OK);
    }
}