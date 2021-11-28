package lokn.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @description:
 * @author: lokn
 * @date: 2021/11/27 17:07
 */
public class CallableMethod {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Task task = new Task();
        FutureTask<String> futureTask = new FutureTask<>(task);
        new Thread(futureTask).start();
        String result = futureTask.get();
        System.out.println("主线程获取异步方法执行结果为：" + result);
    }

    static class Task implements Callable<String> {

        @Override
        public String call() throws Exception {
            return "我是异步执行结果";
        }
    }

}
