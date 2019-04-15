package top.sicso.blog.common;

public enum ResultCodeEnum {

    /***
     * 成功：    0
     * 未知错误： 1
     * 参数错误： 1000x
     * 用户错误： 2000x
     * 系统错误： 4000x
     *
     */

    UNKNOWN_ERROR(1,"未知错误");

    private int code;

    private String message;


    ResultCodeEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}