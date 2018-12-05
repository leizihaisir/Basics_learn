package chain.biz;

import chain.dto.Request;
import chain.dto.Response;

/**
 * @Author zihailei
 * @Date 2018/12/4
 * @Description
 */
public class HTMLFilter extends AbstractFilter {
    @Override
    public void handler(Request request, Response response) {
        System.out.println(this.getClass().toString());
    }
}
