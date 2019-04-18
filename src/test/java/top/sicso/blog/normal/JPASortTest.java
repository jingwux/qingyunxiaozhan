package top.sicso.blog.normal;


import org.junit.Test;
import org.springframework.data.domain.Sort;

public class JPASortTest {

    @Test
    public void sortTest(){
        Sort.Direction desc = Sort.Direction.valueOf("desc".toUpperCase());

    }

}
