package com.springboot.demo.recipe;

public class Patient {
    private String first;
    private int born;
    private String last;

    public Patient(){}

    public Patient(String first, int born, String last) {
        this.first = first;
        this.born = born;
        this.last = last;
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public int getBorn() {
        return born;
    }

    public void setBorn(int age) {
        this.born = age;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }
}
