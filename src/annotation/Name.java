package annotation;


import java.lang.annotation.*;

@Documented //将此注解包含在javadoc
@Target({ElementType.METHOD, ElementType.FIELD}) //此注解作用于方法,字段
@Retention(RetentionPolicy.RUNTIME) //运行时生效
public @interface Name {
    String name();

    String description();
}
