package com.shop.web;

import com.shop.exception.MyException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/demo")
public class DemoController {

int a=1;
    @RequestMapping(value = "test1")
    public String demo1() throws MyException {
        try {
            int[] nums = {10, 29, 30};
            System.out.println(nums[100]);
        } catch (Exception e) {
            throw new MyException("出现问题了，可能是你的下标越界啦！！！");
        }

        return "test";
    }
}
