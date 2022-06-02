package com.example.demo.data;
import com.example.demo.data.models.Student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import  java.sql.SQLException;
import java.util.ArrayList;

public class DBConnection {
    private Connection con;
    public DBConnection() {
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost/students_management", "root", "");
            System.out.println("Connect success");
        } catch (SQLException e){
            System.out.print(e);
        }
    }
    public ArrayList<Student> getStudents() {
        ArrayList<Student> list = new ArrayList<>();
        String sql = "SELECT * FROM students";
        ResultSet results = null;
        try {
            results = con.prepareStatement(sql).executeQuery();
            while (results.next()){
                System.out.println("Id: "+ results.getInt("id"));
                System.out.println("Name: " + results.getString("name"));
                System.out.println("Score: " + results.getInt("score"));

                Student std = new Student(
                        results.getInt("id"),
                        results.getString("name"),
                        results.getInt("score")
                );
                list.add(std);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }
    public void insertStudent (Student std){
        String sql = " INSERT INTO students (name, score) VALUES ('" +std.name + "', '"+std.score+"')";
        System.out.println(sql);
        try {
            con.prepareStatement(sql).executeUpdate();
            System.out.println("Insert successfully");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void updateStudent(Student std){
        String sql = "UPDATE students SET name = '"+std.name+"', score ='"+std.score+"' WHERE id="+std.id;
        try {
            con.prepareStatement(sql).executeUpdate();
            System.out.println("Update successfully");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    public void deleteStudent(int id){
        String sql = "DELETE FROM students WHERE id="+id;
        try {
            con.prepareStatement(sql).executeUpdate();
            System.out.println("Delete successfully");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
