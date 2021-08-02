package invo;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Proxy;

/**
 * @author ：zhenjie.xuan
 * @date ：Created in 2021/7/30 14:35
 * @description： 测试类
 */
public class ProxyMain {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        // =========================第一种==========================
        // 1、生成$Proxy0的class文件
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        // 2、获取动态代理类
        Class proxyClazz = Proxy.getProxyClass(Say.class.getClassLoader(), Say.class);
        // 3、获得代理类的构造函数，并传入参数类型InvocationHandler.class
        Constructor constructor = proxyClazz.getConstructor(InvocationHandler.class);
        // 4、通过构造函数来创建动态代理对象，将自定义的InvocationHandler实例传入
        Say say = (Say) constructor.newInstance(new InvocationHandleImpl(new SayImpl()));
        // 5、通过代理对象调用目标方法
        say.sayHello();

        // ==========================第二种=============================
        /**
         * Proxy类中还有个将2~4步骤封装好的简便方法来创建动态代理对象，
         *其方法签名为：newProxyInstance(ClassLoader loader,Class<?>[] instance, InvocationHandler h)
         */
        Say iHello2 = (Say) Proxy.newProxyInstance(Say.class.getClassLoader(), // 加载接口的类加载器
                new Class[]{Say.class}, // 一组接口
                new InvocationHandleImpl(new SayImpl())); // 自定义的InvocationHandler
        iHello2.sayHello();

    }
}
