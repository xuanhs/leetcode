package invo;

import java.util.BitSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author ：zhenjie.xuan
 * @date ：Created in 2021/7/30 14:31
 * @description： say接口实现
 */
public class SayImpl implements Say {

    @Override
    public void say(String str) {
        System.out.println(str);
    }

    @Override
    public void sayHello() {
        System.out.println("hello");
    }

}
