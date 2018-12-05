package chain;

import chain.biz.FaceFilter;
import chain.biz.HTMLFilter;
import chain.biz.SensitiveFilter;
import chain.dto.Request;
import chain.dto.Response;

/**
 * @Author zihailei
 * @Date 2018/12/4
 * @Description
 */
public class TestChain {

    public static void main(String[] args) {

        String name = "zihailei";
        Request request = new Request();
        request.setName(name);
        Response response = new Response();
        FilterChain filterChain = new FilterChain();
        filterChain.addFilter(new HTMLFilter())
                .addFilter(new SensitiveFilter())
                .addFilter(new FaceFilter());
        filterChain.doFilter(request, response, filterChain);
    }
}
