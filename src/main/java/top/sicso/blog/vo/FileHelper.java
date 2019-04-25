package top.sicso.blog.vo;

import org.springframework.beans.factory.annotation.Value;

public class FileHelper {

    @Value("{base.filepath}")
    public static String BASE_FILEPATH;

    @Value("{filepath.ebook}")
    public static String EBOOK_FILEPATH;

    @Value("{filepath.video}")
    public static String VIDEO;

    @Value("{filepath.document}")
    public static String DOCUMENT;

    @Value("{filepath.software}")
    public static String SOFTWARE;

    @Value("{filepath.crack}")
    public static String CRACK;


}
