package lokn.thread;

import java.util.concurrent.*;

/**
 * @description:
 * @author: lokn
 * @date: 2021/11/27 17:28
 */
public class ThreadPoolMethod {

    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(1);
        Future<String> submit = pool.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "我是异步执行结果";
            }
        });
        try {
            String result = submit.get();
            System.out.println("主线程获取异步方法执行结果为：" + result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        pool.shutdown();
    }

}
