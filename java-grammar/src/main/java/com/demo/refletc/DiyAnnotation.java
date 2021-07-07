package com.demo.refletc;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 自定注解，但没有处理该注解的代码，所以该注解实际上没啥用
 * */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface DiyAnnotation {

 //
 String gg() default "";

}
