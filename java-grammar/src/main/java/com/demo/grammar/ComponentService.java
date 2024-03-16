package com.demo.grammar;


import javax.annotation.Resource;

/**
 打上 @Component注解，等下看ComponentMain 能不能反射获取注解信息
 * */
@Component(value = "componentService", type = "Service")
public class ComponentService {

    // 写个空构造器给反射用
    public ComponentService() {

    }

}
