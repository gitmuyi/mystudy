package com.yyc.common.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @Auther: yangyongcui
 * @Date: 2019/5/7: 20:33
 * @Description:
 */
@Data
public class Student implements Serializable {
    private static final long serialVersionUID = 7665743604557918425L;
    private String name;
    private Integer age;
    private String sex;
    private String birthday;
    public Student(){}

    public Student(String name, Integer age, String sex, String birthday) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.birthday = birthday;
    }
}
