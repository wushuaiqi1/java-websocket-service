package com.ws.annotation;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.Element;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD) // 注解可用在方法上
@Retention(RetentionPolicy.RUNTIME)  // 运行期进行解析
public @interface StudentHeaderInfo {
    String toName() default "";
}
