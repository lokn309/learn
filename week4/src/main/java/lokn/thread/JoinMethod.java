package lokn.thread;

/**
 * @description:
 * @author: lokn
 * @date: 2021/11/27 22:31
 */
public class JoinMethod {

    static String result;

    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            result = "我是异步执行结果";
        });
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("主线程获取异步方法执行结果为：" + result);
    }

}
