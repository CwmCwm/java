package com.demo.grammar;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 注解的语法
 注解的属性也叫做成员变量。注解只有成员变量，没有方法。
 注解的成员变量在注解的定义中以“无形参的方法”形式来声明
 其方法名定义了该成员变量的名字，其返回值定义了该成员变量的类型。
 注解中属性可以有默认值，默认值需要用 default 关键值指定。
 所有的Annotation会自动继承java.lang.annotation.Annotation,并不能继承别的类或是接口
 参数成员只能用public或默认(default)这两个访问权修饰
 参数成员只能用基本数据类型(char，boolean,byte、short、int、long、float、double)和String、Enum、Class、annotations数据类型,以及这一些类型的数组
 要获取类方法和字段的注解信息，必须通过Java的反射技术来获取 Annotation对象,除此之外没有别的获取注解对象的方法


 https://www.runoob.com/w3cnote/java-annotation.html
 @Documented  并没啥用
 @Target  很重要，设置了该注解的使用范围，能设置什么，看链接；设置成什么值的语义，看链接
 @Retention  很重要，设置使用该注解的的类携带注解信息到什么时候

 肯定知道 spring的 @Component注解 => org.springframework.stereotype.Component
 这里定义的 @Component注解  => com.demo.grammar.Component


 * */




/**
 @Target({ElementType.TYPE})   指明该 @Component注解只能使用在类/接口上
 @Retention(RetentionPolicy.RUNTIME)   指明使用该 @Component注解 的类会携带注解的信息到JVM中，这样反射的时候就能拿到注解信息，所以另外两个好像没啥用

 这样就定义好 @Component注解了，注意仅仅是定义好注解，需要反射区获取类上的注解，然后反射做了什么就是反射的事了
 注解就是定好好寓意，如这@Component注解 的语义就是，打上@Component注解的类会帮您实例化，
 具体反射实例化见 ComponentMain
 * */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Component {

    /**
     Component注解的属性，属性值是 value
     这里value 语义是名称，语义是自己定义的
     * */
    String value();


    /**
     Component注解的另一个属性，属性名是 type
     这里type 语义是类型
     取值范围，这里应该写枚举，但我就没写
     Controller
     Service
     Repository
     * */
    String type();


}
