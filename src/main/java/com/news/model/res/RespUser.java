package com.news.model.res;

public class RespUser {

    /**
     * 1 -> 成功
     * 0 -> 用户名存在
     * -1 -> 未知错误
     */
    private int code;
    private int credential;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getCredential() {
        return credential;
    }

    public void setCredential(int credential) {
        this.credential = credential;
    }
}
