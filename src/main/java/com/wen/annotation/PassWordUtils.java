package com.wen.annotation;

import java.util.List;

/**
 * Created by 21up on 2020/9/20
 */
public class PassWordUtils {
    @UseCase(id = 47,description = "密码必须包含一个数字")
    public boolean validatePassWord(String password){
        return password.matches("\\w*\\d\\ww*");
    }
    @UseCase(id = 48)
    public String encryptPassword(String password){
        return new StringBuilder(password).reverse().toString();
    }
    @UseCase(id = 49,description = "新密码不能与旧密码相同")
    public boolean checkForNewPassword(
            List<String> prePasswords,String password){
        return !prePasswords.contains(password);
    }
}
