package com.ws.aop;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.ws.annotation.StudentHeaderInfo;
import com.ws.entity.StudentInfo;
import com.ws.utils.NumberUtils;
import io.swagger.models.auth.In;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

@Aspect
@Slf4j
@Component
public class ReadHeaderInfoAspect {

    @Before("@annotation(com.ws.annotation.StudentHeaderInfo)")
    public void ReadHeaderInfo() {
        // 读取当前请求
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();

        // 解析参数
        String name = request.getHeader("name");
        Integer age = NumberUtils.StringToInteger(request.getHeader("age"));
        Integer areaCode = NumberUtils.StringToInteger(request.getHeader("areaCode"));
        Integer classId = NumberUtils.StringToInteger(request.getHeader("classId"));

        // 封装类
        StudentInfo studentInfo = new StudentInfo(name, age, areaCode, classId);
        log.info("ReadHeaderInfo studentInfo:{}", JSON.toJSONString(studentInfo, SerializerFeature.WriteMapNullValue));

        // 填充属性
        request.setAttribute("studentInfo", studentInfo);
    }

}
