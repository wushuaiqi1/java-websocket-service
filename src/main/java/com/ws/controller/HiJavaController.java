package com.ws.controller;

import com.ws.annotation.LogExecutionTime;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Objects;

@Controller
@ResponseBody
@RequestMapping("hi")
@LogExecutionTime(name = "HiJava")
public class HiJavaController {

    @Resource
    private RedisTemplate<Object, Object> redisTemplate;

    @GetMapping("java")
    public String java() {
        return "你好";
    }

    @GetMapping("redis")
    public String redis(@RequestParam String value) {
        redisTemplate.opsForValue().set("redis", value);
        String res = (String) redisTemplate.opsForValue().get("redis");
        return Objects.isNull(res) ? "插入失败" : res;
    }

    @GetMapping()
    public String hi() throws InterruptedException {
        Thread.sleep(2000);
        return "true";
    }
}
