package com.ws.handler;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.ws.annotation.CustomHttpHeader;
import com.ws.entity.StudentInfo;
import com.ws.utils.NumberUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

@Component
@Slf4j
public class CustomHttpHeaderArgumentHandler implements HandlerMethodArgumentResolver {
    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        log.info("CustomHttpHeaderArgumentHandler supportsParameter =====");
        boolean res = parameter.hasParameterAnnotation(CustomHttpHeader.class);
        log.info("CustomHttpHeaderArgumentHandler res:{}",res);
        return res;
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest request, WebDataBinderFactory binderFactory) throws Exception {
        log.info("CustomHttpHeaderArgumentHandler resolveArgument =====");

        // 解析参数
        String name = request.getHeader("name");
        Integer areaCode = NumberUtils.StringToInteger(request.getHeader("areaCode"));
        Integer classId = NumberUtils.StringToInteger(request.getHeader("classId"));
        Integer age = NumberUtils.StringToInteger(request.getHeader("age"));

        // 封装类
        StudentInfo studentInfo = new StudentInfo(name, age, areaCode, classId);
        log.info("resolveArgument studentInfo:{}", JSON.toJSONString(studentInfo, SerializerFeature.WriteMapNullValue));

        return studentInfo;
    }
}
