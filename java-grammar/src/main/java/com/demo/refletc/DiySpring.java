package com.demo.refletc;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**


 * */
public class DiySpring {

    //这个beanFactory 就是模仿spring的IOC容器，实例化后的bean就是存放在这个beanFactory
    //这里beanFactory 的key就是 @DiyComponent(name="name1")  中的name值，value就是实例化的对象
    private static Map<String, Object> beanFactory = new HashMap<>();

    //这里通过反射去实例化对象，然后放入IOC容器
    //所以这里就不写反射工具类了，直接写成静态方法，少写个工具类嘛
    //入参className 就是类的全路径名
    public static void reflectToNewInstance(String className) {
        try {
            //这里就没写判断，实际上spring会在这里看类/方法/属性上的有什么注解（用getDeclaredAnnotations）
            //根据不同注解（instanceof），交由不同的BeanProcessor处理（这些BeanProcessor就处理它该处理的注解，不是它该处理的注解就不管）
            //所以下面就这么简单的写，下面代码只处理 @DiyComponent ，没处理 @DiyAnnotation
            Class clazz = Class.forName(className);
            Object object = clazz.newInstance();
            DiyComponent diyComponent = (DiyComponent) clazz.getDeclaredAnnotation(DiyComponent.class);
            String beanName = diyComponent.name();
            Field field = clazz.getDeclaredField("myName");
            field.setAccessible(true);
            field.set(object, "myName is " + beanName);
            field.setAccessible(false);
            beanFactory.put(beanName, object);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    //模仿spring的getBean方法
    public static Object getBean(String beanName) {
        return beanFactory.get(beanName);
    }



}
