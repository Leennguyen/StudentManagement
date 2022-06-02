package com.example.demo;

import com.example.demo.data.DBConnection;
import com.example.demo.data.models.Student;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        DBConnection db = new DBConnection();

        db.getStudents();
        ArrayList<Student> stdList = db.getStudents();

        System.out.println("Size: " + stdList.size());

        db.insertStudent(new Student("Chichu", 10));

        db.updateStudent(new Student(8,"Nanixa", 9));

        db.deleteStudent(11);

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}