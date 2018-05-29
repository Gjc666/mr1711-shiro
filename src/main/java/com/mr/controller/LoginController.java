package com.mr.controller;

import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by ${Gjc} on 2018/5/25.
 */
@Controller
public class LoginController {

    @RequestMapping("/login")
    public String login(HttpServletRequest req , ModelMap map){
        //如果登陆失败从request中获取认证异常信息，shiroLoginFailure就是shiro异常类的全限定名
       String attribute = (String) req.getAttribute("shiroLoginFailure");
        //根据shiro返回的异常类路径判断，抛出指定异常信息
        if (UnknownAccountException.class.getName().equals(attribute)){
            map.put("errorMsg", "账号不存在");
        } else if (IncorrectCredentialsException.class.getName().equals(
                attribute)) {
            map.put("errorMsg", "用户名/密码错误");
        } else {
            map.put("errorMsg", "其他异常信息");
        }
    //如果登录失败之后。会查找 当前配置的return
    //如果登录成功之后，会跳转之前访问的路径

        return "forward:/index.jsp";
    }
}
