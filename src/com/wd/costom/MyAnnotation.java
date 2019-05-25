package com.wd.costom;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * desc 自定义注解类
 * @author wu
 * @date Create in 2019/05/25 10:12:22
 *
 */
public class MyAnnotation {

    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface MyAnno{
        public String id();
        public String description() default "默认的描述";
    };
    
}