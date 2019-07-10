package top.sicso.blog.common;


import lombok.Data;

import java.io.Serializable;

/**
 * @Author: myyl
 * @Time: 2019/04/15 13:14:00
 * @Description:
 */


@Data
public class ResultBean implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final boolean SUCCESS = true;
    public static final boolean FAILED = false;

    private boolean success = false;
    private int code;
    private String message;
    private Object data;

}


