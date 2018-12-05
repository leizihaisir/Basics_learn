package chain;

import chain.dto.Request;
import chain.dto.Response;

/**
 * @Author zihailei
 * @Date 2018/12/4
 * @Description
 */
public interface Filter {

    void doFilter(Request request, Response response, FilterChain chain);
}
