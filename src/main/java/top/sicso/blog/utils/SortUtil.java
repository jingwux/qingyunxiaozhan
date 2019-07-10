package top.sicso.blog.utils;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Sort;
import top.sicso.blog.common.BaseCondition;

/**
 * @Author: myyl
 * @Time: 2019/04/15 13:14:00
 * @Description:
 */


public class SortUtil {

    /**
     * 创建 Sort 对象
     * @param baseCondition
     * @return
     */
    public static Sort createSort(BaseCondition baseCondition){
        Sort sort;
        if (StringUtils.isNotBlank(baseCondition.getSort()) && StringUtils.isNotBlank(baseCondition.getOrder())) {
            sort = new Sort(Sort.Direction.valueOf(baseCondition.getSort()), baseCondition.getOrder());
        } else {
            sort = Sort.unsorted();
        }
        return sort;
    }


}
