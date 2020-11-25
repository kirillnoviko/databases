package sample;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import static sample.Main.stageMain;
import java.io.IOException;

public class ControllerError  {


    @FXML
    private AnchorPane anchorAuthorization;

    @FXML
    public Button buttonOKError;

    @FXML
    private Label labelError;



    void SetLabel(String nameError){
        labelError.setText(nameError);
    }

    @FXML
    void initialize() {

        }
    }


