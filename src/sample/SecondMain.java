package sample;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

import static sample.Main.stageMain;

public class SecondMain {
    Stage secondWindow;
    String a;

    public SecondMain(String b) {
        secondWindow = new Stage();
        a = b;
        FXMLLoader loader=new FXMLLoader(getClass().getResource(  "Error.fxml"));
        try {
            secondWindow.setScene(new Scene(loader.load()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        ControllerError a1=loader.getController();
        a1.SetLabel(a);
        a1.buttonOKError.setOnAction(event -> {
            Closse();
        });
        secondWindow.initModality(Modality.WINDOW_MODAL);
        secondWindow.initOwner(stageMain);
        secondWindow.setX(stageMain.getX() + 200);
        secondWindow.setY(stageMain.getY() + 100);
        secondWindow.show();



    }

    public void Closse() {
        secondWindow.close();

    }

    public String GetA() {
        return a;
    }
}


