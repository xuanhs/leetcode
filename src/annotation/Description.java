package annotation;

import java.lang.annotation.*;

@Documented //将此注解包含在javadoc
@Target(ElementType.TYPE) //此注解作用于类
@Retention(RetentionPolicy.RUNTIME) //运行时生效
public @interface Description {
    String value();
}
