package com.aohuan.demo.eventbus3test.bean;

/**
 * Created by Administrator on 2016/9/22.
 */
public class FutureBean {String name;
    String age;

    public FutureBean(String name, String age){
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "FutureBean{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}
