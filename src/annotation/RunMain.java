package annotation;

/**
 * @author ：zhenjie.xuan
 * @date ：Created in 2021/7/15 15:39
 * @description：
 */
public class RunMain {
    public static void main(String[] args) throws NoSuchFieldException, NoSuchMethodException {
        Person person = new Person();
        Class personClass = person.getClass();
        //输出类javadoc
        if (personClass.isAnnotationPresent(Description.class)) {
            Description dsc = (Description) personClass.getAnnotation(Description.class);
            System.out.println("javadoc:" + dsc.value());
        }
        //获取对应的字段和方法注释，查看是否生效
        System.out.println("字段注释：" + person.getName1());
        System.out.println("方法注释：" + person.getName2());
    }
}
