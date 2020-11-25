package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class Main extends Application {

    //-Djava.util.logging.config.file=\C:\Users\kiril\IdeaProjects\diplom\src\sample\logger.properties
    static Stage stageMain; // Общая переменная для доступа главной сцене
    @Override
    public void start(Stage primaryStage) throws Exception{

        Logging LOGGER= new Logging();
        LOGGER.someMethod("начало main, ");

        System.out.println(System.getProperty("java.util.logging.config.file"));
        stageMain=primaryStage;
        primaryStage.setScene(new SceneBuilder().getScene("RegistrAndAuthorizat"));

       // Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));

        primaryStage.show();


    }


    public static void main(String[] args) {
        launch(args);
    }
}
