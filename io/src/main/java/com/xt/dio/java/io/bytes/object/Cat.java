package com.xt.dio.java.io.bytes.object;

import java.io.Serializable;

public class Cat implements Serializable {

    private static final long serialVersionUID = 2L;
    private String name;
    private Integer age;
    private String color;
    private boolean castrated;

    public Cat() {
    }

    public Cat(String name, Integer age, String color, boolean castrated) {
        this.name = name;
        this.age = age;
        this.color = color;
        this.castrated = castrated;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isCastrated() {
        return castrated;
    }

    public void setCastrated(boolean castrated) {
        this.castrated = castrated;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", color='" + color + '\'' +
                ", castrated=" + castrated +
                '}';
    }
}
