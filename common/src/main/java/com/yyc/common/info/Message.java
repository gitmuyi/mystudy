package com.yyc.common.info;

import com.yyc.common.constant.SuccessOrFailed;
import lombok.Data;

import java.io.Serializable;
import java.util.Map;

/**
 * @Auther: yangyongcui
 * @Date: 2018/10/23: 13:59
 * @Description:
 */
@Data
public class Message implements Serializable {
    private static final long serialVersionUID = 8718323621925012801L;
    private String code;
    private String msg;
    private String status;

    private Object data;

    /**
     * 默认成功
     */
    public Message() {
        this.code = "0000";
        this.msg = "操作成功";
        this.status = SuccessOrFailed.SUCCESS;
    }

    /**
     * 成功的代码和消息
     *
     * @param code
     * @param msg
     */
    public Message success(String code, String msg) {
        return new Message(code, msg, SuccessOrFailed.SUCCESS);
    }

    /**
     * 失败
     *
     * @param
     * @param
     * @param
     */
    public Message failed() {
        return new Message("9999", "操作失败", SuccessOrFailed.FAILED);
    }

    /**
     * 失败
     *
     * @param code
     * @param msg
     * @param
     */
    public Message failed(String code, String msg) {
        return new Message(code, msg, SuccessOrFailed.FAILED);
    }

    public Message(String code, String msg, String status) {
        this.code = code;
        this.msg = msg;
        this.status = status;
    }

}
