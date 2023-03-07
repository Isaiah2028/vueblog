package com.luyuan.common;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author: IsaiahLu
 * @date: 2023/3/7 16:12
 */
@Data
public class DbResponse implements Serializable {
    private int code;
    private String msg;
    private Object data;
    private Long count;
    private String url;

    public DbResponse() {
    }

    public DbResponse(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public DbResponse(int code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public DbResponse(int code, String msg, Object data, Long count) {
        this.code = code;
        this.msg = msg;
        this.data = data;
        this.count = count;
    }

    public static DbResponse getDbResponse(int code, String msg) {
        return new DbResponse(code, msg);
    }

    public static DbResponse getDbResponse(int code, String msg, Object data) {
        return new DbResponse(code, msg, data);
    }

    public static DbResponse getDbResponse(int code, String msg, Object data, Long count) {
        return new DbResponse(code, msg, data, count);
    }

    @Override
    public String toString() {
        return "DBResponse{" + "retCode=" + code + ", msg='" + msg + '\'' + ", data=" + data + ", count=" + count
                + ", url='" + url + '\'' + '}';
    }

}
