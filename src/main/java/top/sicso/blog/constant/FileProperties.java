package top.sicso.blog.constant;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Author: myyl
 * @Time: 2019/04/15 13:14:00
 * @Description:
 */

@Data
@Component
@EnableConfigurationProperties(FileProperties.class)
@ConfigurationProperties(prefix = "filepath")
public class FileProperties {

    public  String base;

    public  String ebook;

    public  String video;

    public  String document;

    public  String software;

    public  String crack;

    public  String picture;


}
