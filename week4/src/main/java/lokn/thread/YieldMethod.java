package lokn.thread;

/**
 * @description:
 * @author: lokn
 * @date: 2021/11/21 23:27
 */
public class YieldMethod {

    private static String result;

    public static void main(String[] args) {
        int count = Thread.activeCount();
        new Thread(() -> {
            result = "我是异步执行结果";
        }).start();
        while (Thread.activeCount() > count) {
            Thread.yield();
        }
        System.out.println("主线程获取异步方法执行结果为：" + result);
    }

}

