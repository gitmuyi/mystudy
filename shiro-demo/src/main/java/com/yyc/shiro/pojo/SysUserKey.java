package com.yyc.shiro.pojo;



import java.io.Serializable;


public class SysUserKey  implements Serializable {
    private static final long serialVersionUID = -8423189153548960699L;
    private Integer id;

    private String userId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}