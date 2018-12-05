package chain;

import chain.biz.AbstractFilter;
import chain.dto.Request;
import chain.dto.Response;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author zihailei
 * @Date 2018/12/4
 * @Description
 */
public class FilterChain implements Filter {

    //用List集合来存储过滤规则
    List<AbstractFilter> filters = new ArrayList<>();
    //用于标记规则的引用顺序
    int index = 0;

    //往规则链条中添加规则
    public FilterChain addFilter(AbstractFilter f) {
        filters.add(f);
        return this;
    }

    @Override
    public void doFilter(Request request, Response response, FilterChain chain) {
        if (index == filters.size()) return;
        AbstractFilter filter = filters.get(index++);
        filter.doFilter(request, response, chain);
    }
}
