package top.sicso.blog.utils;

import org.junit.Test;
import top.sicso.blog.vo.BlogVO;

import java.util.Date;

public class ObjectUtilsTest {

    @Test
    public void isNotBlank() {
        BlogVO blogVO = new BlogVO();
//        blogVO.setArticle("");
        blogVO.setDate(new Date());
        boolean notBlank = ObjectUtils.isNotBlank(blogVO);

    }
}