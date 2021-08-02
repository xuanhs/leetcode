package invo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author ：zhenjie.xuan
 * @date ：Created in 2021/7/30 14:32
 * @description： InvocationHandle的实现类
 */
public class InvocationHandleImpl implements InvocationHandler {

    private Object target;

    public InvocationHandleImpl(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("todo something before");
        Object res = method.invoke(target, args);
        System.out.println("todo something after");
        return res;
    }
}
