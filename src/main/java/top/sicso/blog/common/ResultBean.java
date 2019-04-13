package top.sicso.blog.common;


import lombok.Data;

import java.io.Serializable;

@Data
public class ResultBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private static final boolean SUCCESS = true;
    private static final boolean FAILED = false;

    private boolean success = false;
    private int code;
    private String message;
    private Object data;

}


