package thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author ：zhenjie.xuan
 * @date ：Created in 2021/10/9 14:14
 * @description：
 */
public class VolatileTest implements Runnable {

    private  static Integer count = 0;

    private static Integer count2 = 0;

    static ThreadPoolExecutor executor = new ThreadPoolExecutor(20, 20, 10, TimeUnit.MINUTES,
            new ArrayBlockingQueue<>(1), new ThreadPoolExecutor.CallerRunsPolicy());

    public static void main(String[] args) throws InterruptedException {
        VolatileTest test = new VolatileTest();
        for (int i = 0; i < 20; i++) {
            //注意此处，产生的是同一个对象
            Thread thread = new Thread(test);
            thread.start();
            executor.execute(test::inc2);
        }
        Thread.sleep(5000);
        System.out.println("count: " + count + "\ncount2: " + count2);
    }


    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            inc();
        }
    }

    //实例锁
    private synchronized void inc() {
        count++;
    }

    //实例锁
    private synchronized void inc2() {
        for (int i = 0; i < 10000; i++) {
            count2++;
        }
    }
}
