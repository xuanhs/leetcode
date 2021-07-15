package annotation;


@Description("测试对应的注释")
public class Person {

    @Name(name = "临地-字段", description = "作用于字段")
    private String name1;

    public String getName1() throws NoSuchFieldException {
        //获取字段name1上的Name注释的name值
        return this.getClass().getDeclaredField("name1").getAnnotation(Name.class).name();
    }

    @Name(name = "临地-方法", description = "作用于方法")
    public String getName2() throws NoSuchMethodException {
        //获取getName2方法上的Name注释的name值
        return this.getClass().getMethod("getName2").getAnnotation(Name.class).name();
    }

}
