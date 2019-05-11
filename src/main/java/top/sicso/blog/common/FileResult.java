package top.sicso.blog.common;

import lombok.Data;

@Data
public class FileResult {

    private static final boolean SUCCESS = true;
    private static final boolean FAILED = false;

    private boolean success = false;
    private int code;
    private String url;

}
