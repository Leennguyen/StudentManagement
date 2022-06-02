package com.example.demo.data.models;

public class Student {
    public int id;
    public String name;
    public int score;

    public Student(int id, String name, int score) {
        this.id = id;
        this.name = name;
        this.score = score;
    }
    public Student(String name, int score){
        this.name = name;
        this.score = score;
    }
}
