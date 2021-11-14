package nio.client;

import okhttp3.*;
import org.apache.http.HttpEntity;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.jupiter.api.Test;
import sun.net.www.http.HttpClient;

import java.io.IOException;
import java.io.InputStream;

/**
 * @description: HttpClint 测试
 * @author: lokn
 * @date: 2021/11/14 15:48
 */
public class HttpClientTest {

    /**
     *  httpClint 测试
     */
    @Test
    public void httpClientTest() {
        String url = "http://localhost:8801";
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        HttpGet httpGet = new HttpGet(url);
        CloseableHttpResponse response = null;
        try {
            response = httpClient.execute(httpGet);
            HttpEntity entity = response.getEntity();
            StatusLine statusLine = response.getStatusLine();
            System.out.println("响应状态：" + statusLine.toString());
            System.out.println("返回结果：" + EntityUtils.toString(entity));
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
            if (httpClient != null) {
                try {
                    httpClient.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void okHttp() {
        String url = "http://localhost:8801";
        OkHttpClient okHttpClient = new OkHttpClient();
        Request request = new Request.Builder().get().url(url).build();
        Call call = okHttpClient.newCall(request);
        Response response = null;
        try {
            response = call.execute();
            ResponseBody body = response.body();
            System.out.println("响应信息：" + response.toString());
            System.out.println("响应结果：" + body.string());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
