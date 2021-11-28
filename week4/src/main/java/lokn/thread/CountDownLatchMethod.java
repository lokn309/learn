package lokn.thread;

import java.util.concurrent.CountDownLatch;

/**
 * @description:
 * @author: lokn
 * @date: 2021/11/27 17:22
 */
public class CountDownLatchMethod {

    private static String result;

    public static void main(String[] args) {
        int count = 1;
        CountDownLatch latch = new CountDownLatch(count);
        Task task = new Task(latch);
        new Thread(task).start();
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("主线程获取异步方法执行结果为：" + result);
    }

    static class Task implements Runnable {

        private CountDownLatch latch;

        public Task(CountDownLatch latch) {
            this.latch = latch;
        }

        @Override
        public void run() {
            try {
                result = "我是异步执行结果";
            } finally {
                latch.countDown();
            }
        }
    }

}
