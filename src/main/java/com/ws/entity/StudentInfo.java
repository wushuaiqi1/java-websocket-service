package com.ws.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
@AllArgsConstructor
public class StudentInfo {

    private String name;

    private Integer age;

    private Integer areaCode;

    private Integer classId;

}
