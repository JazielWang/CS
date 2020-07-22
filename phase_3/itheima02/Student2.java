package com.itheima02;

public class Student2 {
    private String name;
    private int chinesescore;
    private int mathscore;

    public Student2() {
    }

    public Student2(String name, int chinesescore, int mathscore) {
        this.name = name;
        this.chinesescore = chinesescore;
        this.mathscore = mathscore;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getChinesescore() {
        return chinesescore;
    }

    public void setChinesescore(int chinesescore) {
        this.chinesescore = chinesescore;
    }

    public int getMathscore() {
        return mathscore;
    }

    public void setMathscore(int mathscore) {
        this.mathscore = mathscore;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student2 student2 = (Student2) o;

        if (chinesescore != student2.chinesescore) return false;
        if (mathscore != student2.mathscore) return false;
        return name != null ? name.equals(student2.name) : student2.name == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + chinesescore;
        result = 31 * result + mathscore;
        return result;
    }
}
