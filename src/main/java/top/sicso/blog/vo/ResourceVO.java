package top.sicso.blog.vo;

import lombok.Data;

/**
 * @Author: myyl
 * @Time: 2019/04/15 13:14:00
 * @Description:
 */


@Data
public class ResourceVO {

    private Integer id;

    private String resourceName;

    private String description;

    private String url;

    private Integer resourceType;

    private String filename;

    private String filepath;


    /**
     * 0 有效 ，1 无效
     */
    private Integer status;

    enum ResourceTypeEnum {
        E_BOOK(0, "电子书籍"),
        VIDEO(1, "教学视频"),
        DOCUMENT(2, "文档资料"),
        SOFTWARE(3, "软件"),
        CRACK_UTILS(4,"破解工具");


        private int resourceType;
        private String resourceTypeValue;

        ResourceTypeEnum(int resourceType, String resourceTypeValue) {
            this.resourceType = resourceType;
            this.resourceTypeValue = resourceTypeValue;
        }

        public int getResourceType() {
            return resourceType;
        }

        public void setResourceType(int resourceType) {
            this.resourceType = resourceType;
        }

        public String getResourceTypeValue() {
            return resourceTypeValue;
        }

        public void setResourceTypeValue(String resourceTypeValue) {
            this.resourceTypeValue = resourceTypeValue;
        }
    }


}
