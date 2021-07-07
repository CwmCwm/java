package com.demo.grammar;


import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 注解的作用就是为 类/接口/方法/属性 等等打上 标识/标签/元数据
 然后要有对应的处理类来解析注解并做一些工作（实现注解的语义），这样打上注解的 类/接口/方法/属性 才有注解说的语义

 spring的注解就是这样实现的，当然spring的实现IOC和AOP复杂多了，原理就这些
 * */
public class ComponentMain {

    // 下面这些Map看命名也知道啥意思， 键为 @Component.value , 值为对应的实例对象
    private static Map<String, Object> controllerMap = new HashMap<>();
    private static Map<String, Object> serviceMap = new HashMap<>();
    private static Map<String, Object> repositoryMap = new HashMap<>();

    // 这里说明了类加载的时间点不同
    public static void main(String[] args) {
        // 要反射就要获取类的信息，获取类信息有几种写法，自己百度咯
        String[] classNames = {"com.demo.grammar.ComponentController", "com.demo.grammar.ComponentService", "com.demo.grammar.ComponentRepository"};
        List<Class> classes = new ArrayList<>();
        for (String className : classNames) {
            // 因为class是关键字，所以用clazz命名，这很经常看见
            try {
                Class clazz = Class.forName(className);
                classes.add(clazz);
            } catch (ClassNotFoundException e) {
                System.out.println("没找对应的类，你是不是类的全路径名写错了");
                e.printStackTrace();
            }
        }


        // 上面获取了几个类的类信息，并翻入 classes ，接下来就看类信息上的注解信息
        for (Class clazz : classes) {
            // 你看能 Class 的api方法就知道反射能做什么，不知道语义，百度；具体怎么用，百度；
            Annotation[] annotations = clazz.getAnnotations();
            for (Annotation annotation : annotations) {
                if (annotation instanceof Component) {
                    // 这个反射就处理 @Component 注解
                    Component component = (Component) annotation;
                    String value = component.value();
                    String type = component.type();
                    System.out.println(clazz.getName() + " 上有@Component注解 " + " value=" + value + ", type=" + type );

                    // 反射实例化对象，这里反射使用无参构造器，有参构造器的自行百度
                    try {
                        Object object = clazz.newInstance();
                        if (type.equals("Controller")) {
                            controllerMap.put(value, object);
                        }
                        if (type.equals("Service")) {
                            serviceMap.put(value, object);
                        }
                        if (type.equals("Repository")) {
                            repositoryMap.put(value, object);
                        }
                    } catch (InstantiationException e) {
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }

                }
                // 你打上其他注解，我这个反射有不处理
            }
        }


        System.out.println(controllerMap);
        System.out.println(serviceMap);
        System.out.println(repositoryMap);

    }

}
