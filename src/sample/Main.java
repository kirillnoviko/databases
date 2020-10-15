package sample;

import com.sun.deploy.util.FXLoader;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.fxml.*;
import javafx.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;



public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

       // = FXMLLoader.load(getClass().getResource("sample.fxml"));
        FXMLLoader loader=new FXMLLoader();

        loader.setLocation(getClass().getResource("sample.fxml"));

        Parent root=loader.load();

        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 1345, 960));// ширина 300, длина 275
        Controller controller= loader.getController();
        controller.setPrimaryStage(primaryStage);
        primaryStage.show();


    }



    public static void main(String[] args) {
        launch(args);
    }
}
