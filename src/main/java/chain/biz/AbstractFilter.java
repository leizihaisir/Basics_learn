package chain.biz;

import chain.Filter;
import chain.FilterChain;
import chain.dto.Request;
import chain.dto.Response;

/**
 * @Author zihailei
 * @Date 2018/12/4
 * @Description
 */
public abstract class AbstractFilter implements Filter {

    @Override
    public void doFilter(Request request, Response response, FilterChain chain) {
        try {
            handler(request, response);
        } finally {
            chain.doFilter(request, response, chain);
        }
    }

    public abstract void handler(Request request, Response response);
}
