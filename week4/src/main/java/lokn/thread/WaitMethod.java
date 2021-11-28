package lokn.thread;

/**
 * @description:
 * @author: lokn
 * @date: 2021/11/27 17:15
 */
public class WaitMethod {

    private static String result;

    public static void main(String[] args) throws InterruptedException {
        Object lock = new Object();
        new Thread(() -> {
            synchronized (lock) {
                result = "我是异步执行方法";
                lock.notifyAll();
            }
        }).start();
        synchronized (lock) {
            lock.wait(1000);
        }
        System.out.println("主线程获取异步方法执行结果为：" + result);
    }

}
