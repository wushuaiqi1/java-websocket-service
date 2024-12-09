package com.ws.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.ws.annotation.CustomHttpHeader;
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

    @GetMapping("header/v1")
    @StudentHeaderInfo
    public void getHeaderV1(@RequestAttribute(required = false) String hello,HttpServletRequest request) {
        StudentInfo studentInfo = (StudentInfo) request.getAttribute("studentInfo");
        log.info("{}", JSON.toJSONString(studentInfo, SerializerFeature.WriteMapNullValue));
    }


    @GetMapping("header/v2")
    public void getHeaderV2(@CustomHttpHeader StudentInfo studentInfo){
        log.info("getHeaderV2 StudentInfo:{}", JSON.toJSONString(studentInfo, SerializerFeature.WriteMapNullValue));
    }
}
