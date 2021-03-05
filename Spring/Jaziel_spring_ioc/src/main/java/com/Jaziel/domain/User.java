package com.Jaziel.domain;

/**
 * @author 王杰
 * @time 2020/9/23 16:53
 */
public class User {
    private String name;
    private String add;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdd() {
        return add;
    }

    public void setAdd(String add) {
        this.add = add;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", add='" + add + '\'' +
                '}';
    }
}
