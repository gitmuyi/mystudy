package com.yyc.common.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @Auther: yangyongcui
 * @Date: 2018/10/30: 16:43
 * @Description:
 */
@Data
public class User1 implements Serializable {
    private static final long serialVersionUID = -5217065440799738301L;
    private String name;
    private Integer age;
}
