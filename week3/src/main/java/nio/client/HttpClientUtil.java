package nio.client;

import io.netty.handler.codec.http.FullHttpRequest;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * @description: httpClient工具
 * @author: lokn
 * @date: 2021/11/21 16:55
 */
public class HttpClientUtil {

    private static CloseableHttpClient httpClient = HttpClientBuilder.create().build();

    /**
     * @param url
     * @return
     */
    public static String get(String url) {
        return get(url, null);
    }

    /**
     * @param url
     * @param fullHttpRequest
     * @return
     */
    public static String get(String url, FullHttpRequest fullHttpRequest) {
        HttpGet get = new HttpGet(url);
        if (fullHttpRequest != null) {
            get.setHeader("test", fullHttpRequest.headers().get("test"));
        }
        CloseableHttpResponse response = null;
        try {
            response = httpClient.execute(get);
            HttpEntity entity = response.getEntity();
            return EntityUtils.toString(entity);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (response != null) {
                try {
                    response.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

}
