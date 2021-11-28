package lokn.thread;

import java.util.concurrent.CompletableFuture;

/**
 * @description:
 * @author: lokn
 * @date: 2021/11/27 22:46
 */
public class CompletableFutureMethod {

    public static void main(String[] args) {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            return "我是异步执行结果";
        });
        String result = future.join();
        System.out.println("主线程获取异步方法执行结果为：" + result);
    }

}
