package com.demo.refletc;


import java.lang.annotation.*;

/**
 自定义注解，配合反射使用
 这是基础，spring框架的自定义注解是怎么实现的，通过下面demo理解原理，也不难理解spring注解的实现

 这里 @DiyComponent 类似于spring的 @Component
 我们就来模仿一下spring的bean的实例化
 我设计示例会用spring框架作为示例，从熟悉的场景入手

 关于
 @Target 的语义和取值
 @Retention 的语义和取值
 见 https://blog.csdn.net/weixin_45056780/article/details/105127722

 * */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface DiyComponent {

 //对象实例化后，将这个实例化对象放到Map中时，作为key，就是这个实例化对象在spring的name
 String name() default "";

}
