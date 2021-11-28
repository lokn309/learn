package lokn.thread;

import javax.xml.transform.Result;
import java.util.concurrent.Semaphore;

/**
 * @description:
 * @author: lokn
 * @date: 2021/11/27 21:34
 */
public class SemaphoreMethod {

    public static String result;

    public static void main(String[] args) throws InterruptedException {
        Semaphore semaphore = new Semaphore(1);
        Task task = new Task(semaphore);
        new Thread(task).start();
        int queueLength = semaphore.availablePermits();
        while (queueLength > 0) {
            queueLength = semaphore.availablePermits();
        }
        System.out.println("主线程获取异步方法执行结果为：" + result);
    }

}

class Task implements Runnable {

    private Semaphore semaphore;

    public Task(Semaphore semaphore) {
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        try {
            semaphore.acquire();
            SemaphoreMethod.result = "我是异步执行结果";
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
