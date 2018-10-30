package com.yyc.shiro.pojo;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
public class SysUserKey  implements Serializable {
    private static final long serialVersionUID = -8423189153548960699L;
    private Integer id;

    private String userId;

}