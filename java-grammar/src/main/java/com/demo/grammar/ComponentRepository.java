package com.demo.grammar;


/**
 打上 @Component注解，等下看ComponentMain 能不能反射获取注解信息
 * */
@Component(value = "componentRepository", type = "Repository")
public class ComponentRepository {

    // 写个空构造器给反射用
    public ComponentRepository() {

    }

}
