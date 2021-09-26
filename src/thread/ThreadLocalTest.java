package thread;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author ：zhenjie.xuan
 * @date ：Created in 2021/9/24 9:16
 * @description： threadLocalTest
 */
public class ThreadLocalTest {

    private static ThreadLocal<String> threadLocal = new ThreadLocal<>();

    private static ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(10, 10, 10,
            TimeUnit.MINUTES, new LinkedBlockingQueue<>(10));

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            poolExecutor.execute(() -> runThread(finalI));
        }
    }


    private static void runThread(Integer i) {
        System.out.println(i + "_" + threadLocal.get());
        threadLocal.set(i.toString());
        System.out.println(i + "_" + threadLocal.get());
    }
}
