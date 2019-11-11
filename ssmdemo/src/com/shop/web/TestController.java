package com.shop.web;

import com.shop.domain.User;
import com.shop.exception.MyException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping(value = "/test")  //一级
public class TestController {

int a=0;
    /**
     * 相当于使用当年的servlet的传统方式获取客户端传过来的请求数据
     *
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/test")
    public String getName(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("getName执行了......");
        String name = request.getParameter("name");
        if (name != null) {
            System.out.println("name:" + name);
        }
        return null;
    }

    @RequestMapping(value = "/test2")
    public String getName2(String name) {
        System.out.println("getName执行了......");
        if (name != null) {
            System.out.println("name:" + name);
        }
        return null;
    }

    @RequestMapping(value = "/login/dolog")
    public String doLog(String userName, String password) {
        System.out.println("doLog......");
        if (userName != null) {
            System.out.println("name:" + userName + ",password:" + password);
        }
        return null;
    }

    /**
     * 映射成对象类型
     *
     * @param user
     * @return
     */
    @RequestMapping(value = "/user/register")
    public String doregister(User user) {
        System.out.println("doregister......");
        if (user != null) {
            System.out.println("name:" + user.getUsername() + ",sex:" + user.getSex() + ",address:" + user.getAddress());
        }
        return null;
    }

    @RequestMapping(value = "/user/register2")
    public String doregister2(HttpServletResponse response) {
        System.out.println("doregister2......");
        try {
            response.getWriter().write("广东广州");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "/queryitem.action")  //二级
    public String query() {
        return null;
    }

    @RequestMapping(value = "/extest")  //二级
    public String exceptiontest() throws MyException {
        try {
            int i = 10 / 0;
        } catch (Exception e) {
            System.out.println("aaaaa");
            throw new MyException("出问题了，可能是除数为零了....");
        }
        return "test";
    }
}
