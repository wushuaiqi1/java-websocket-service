package com.ws.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.ws.annotation.StudentHeaderInfo;
import com.ws.entity.StudentInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/read")
@Slf4j
public class ReadHeaderController {

    @GetMapping("header")
    @StudentHeaderInfo
    public void getHeader(HttpServletRequest request) {
        StudentInfo studentInfo = (StudentInfo) request.getAttribute("studentInfo");
        log.info("{}", JSON.toJSONString(studentInfo, SerializerFeature.WriteMapNullValue));
    }
}
