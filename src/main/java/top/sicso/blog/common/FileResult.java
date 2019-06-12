package top.sicso.blog.common;

import lombok.Data;

@Data
public class FileResult {

    public static final boolean SUCCESS = true;
    public static final boolean FAILED = false;

    private boolean success = false;
    private int code;
    private String url;

}
