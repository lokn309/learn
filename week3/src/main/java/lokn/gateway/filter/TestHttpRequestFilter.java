package lokn.gateway.filter;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.FullHttpRequest;

/**
 * @description: 测试过滤器
 * @author: lokn
 * @date: 2021/11/21 17:43
 */
public class TestHttpRequestFilter implements HttpRequestFilter {

    @Override
    public void filter(FullHttpRequest fullRequest, ChannelHandlerContext ctx) {
        fullRequest.headers().set("test", "filter test");
    }
}
