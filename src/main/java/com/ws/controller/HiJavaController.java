package com.ws.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
@RequestMapping("hi")
public class HiJavaController {

    @GetMapping("java")
    public static String java(){
        return "你好";
    }
}
