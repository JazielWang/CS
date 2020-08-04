package com.itheima07;

public class Student2 {
    private String name;
    private int Chinese;
    private int Math;
    private int English;

    public Student2() {
    }

    public Student2(String name, int chinese, int math, int english) {
        this.name = name;
        Chinese = chinese;
        Math = math;
        English = english;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getChinese() {
        return Chinese;
    }

    public void setChinese(int chinese) {
        Chinese = chinese;
    }

    public int getMath() {
        return Math;
    }

    public void setMath(int math) {
        Math = math;
    }

    public int getEnglish() {
        return English;
    }

    public void setEnglish(int english) {
        English = english;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student2 student2 = (Student2) o;

        if (Chinese != student2.Chinese) return false;
        if (Math != student2.Math) return false;
        if (English != student2.English) return false;
        return name != null ? name.equals(student2.name) : student2.name == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + Chinese;
        result = 31 * result + Math;
        result = 31 * result + English;
        return result;
    }
}
