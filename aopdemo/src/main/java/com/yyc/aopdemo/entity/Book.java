package com.yyc.aopdemo.entity;

import com.yyc.common.interfaces.Insert;
import com.yyc.common.interfaces.Update;
import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.io.Serializable;

/**
 * @Auther: yangyongcui
 * @Date: 2018/10/16: 15:50
 * @Description:
 */
@Data
@ToString
public class Book implements Serializable {
    private static final long serialVersionUID = 1670292046158771865L;
    @NotNull(groups = {Update.class} , message = "主键必须不为空")
    @Null(groups = {Insert.class},message = "主键必须为空")
    private Integer id;

    private String name;
}
