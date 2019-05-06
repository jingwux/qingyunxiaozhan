package top.sicso.blog.constant;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class FileHelper {

    public static String BASE_FILEPATH;

    public static String EBOOK_FILEPATH;

    public static String VIDEO;

    public static String DOCUMENT;

    public static String SOFTWARE;

    public static String CRACK;

    public static String PICTURE;


    @Value("${base.filepath}")
    public void setBaseFilepath(String baseFilepath) {
        BASE_FILEPATH = baseFilepath;
    }

    @Value("${filepath.ebook}")
    public void setEbookFilepath(String ebookFilepath) {
        EBOOK_FILEPATH = ebookFilepath;
    }

    @Value("${filepath.video}")
    public void setVIDEO(String VIDEO) {
        FileHelper.VIDEO = VIDEO;
    }

    @Value("${filepath.document}")
    public void setDOCUMENT(String DOCUMENT) {
        FileHelper.DOCUMENT = DOCUMENT;
    }

    @Value("${filepath.software}")
    public void setSOFTWARE(String SOFTWARE) {
        FileHelper.SOFTWARE = SOFTWARE;
    }

    @Value("${filepath.crack}")
    public void setCRACK(String CRACK) {
        FileHelper.CRACK = CRACK;
    }

    @Value("${filepath.picture}")
    public static void setPICTURE(String PICTURE) {
        FileHelper.PICTURE = PICTURE;
    }
}
