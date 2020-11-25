package sample;

import com.mysql.cj.xdevapi.Column;
import javafx.beans.InvalidationListener;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.*;
import java.io.File;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.function.UnaryOperator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static javafx.scene.input.KeyCode.Z;
import static sample.Main.stageMain;
public class ControllerRegistrAndAuthorizat {

    @FXML
    private Label labelPassord;
    @FXML
    private AnchorPane anchorAuthorization;
    @FXML
    private TextField persNum;
    @FXML
    private TextField user_name;
    @FXML
    private PasswordField password_name;
    @FXML
    private Button loginButton;
    @FXML
    private Button regNewUser;
    @FXML
    private Button exitProg;



    @FXML
    private AnchorPane anchorRegistration;
    @FXML
    private Button inputNewUserButton;
    @FXML
    private Button buttonCancel;
    @FXML
    private TextField newPersNum;
    @FXML
    private TextField newLogin;
    @FXML
    private TextField codeWord;
    @FXML
    private PasswordField newPassword;
    @FXML
    private PasswordField newPasswordRepeat;



    @FXML
    private AnchorPane anchorChangePassword;

    @FXML
    private TextField anchorChangePersNum;

    @FXML
    private TextField anchorChangeLogin;

    @FXML
    private PasswordField anchorChangeSavePassword;
    @FXML
    private PasswordField anchorChangeSaveRepeatPassword;

    @FXML
    private TextField anchorChangecodeWord;
    @FXML
    private Label anchorChangeSaveLabelpassword;

    @FXML
    private Label anchorChangeLabelLogin;

    @FXML
    private Label anchorChangeLabelPersonalNum;

    @FXML
    private Label anchorChangeLabelTeg;

    @FXML
    private Button anchorChangeButtonDalee;

    @FXML
    private Button anchorChangeSaveButtonCancel;

    @FXML
    private Label anchorChangeSaveLabelRepeatPassword;



    @FXML
    private Label anchorChangeLabelCodeword;

    @FXML
    private Button anchorChangeSaveButtonSavePassword;

    @FXML
    private Label anchorChangeSaveLabelTeg;

    @FXML
    private Button anchorChangeButtonCancel;
void ClearAnchorPassword(){
    anchorChangecodeWord.clear();
    anchorChangePersNum.clear();
    anchorChangeLogin.clear();
    anchorChangeSaveRepeatPassword.clear();
    anchorChangeSavePassword.clear();
}
 void ChangeAnchorPassword(boolean a,boolean b){
     //окно смены пароля (ввод логина и т.д.)

     anchorChangeLabelTeg.setVisible(a);
     anchorChangeLabelLogin.setVisible(a);
     anchorChangeLabelPersonalNum.setVisible(a);
     anchorChangeLabelCodeword.setVisible(a);
     anchorChangecodeWord.setVisible(a);
     anchorChangePersNum.setVisible(a);
     anchorChangeLogin.setVisible(a);
     anchorChangeButtonCancel.setVisible(a);
     anchorChangeButtonDalee.setVisible(a);


     //окно ввода нового пароля

     anchorChangeSavePassword.setVisible(b);
     anchorChangeSaveLabelpassword.setVisible(b);
     anchorChangeSaveLabelTeg.setVisible(b);
     anchorChangeSaveLabelRepeatPassword.setVisible(b);
     anchorChangeSaveRepeatPassword.setVisible(b);
     anchorChangeSaveButtonSavePassword.setVisible(b);
     anchorChangeSaveButtonCancel.setVisible(b);


 }
    @FXML
    void initialize() {

        user_name.textProperty().addListener((observable, oldValue, newValue) -> {
            user_name.setText(newValue.replaceAll("[^\\d a-zA-Z ]", ""));
            System.out.println("textfield changed from " + oldValue + " to " + newValue);
        });
        persNum.textProperty().addListener((observable, oldValue, newValue) -> {
            persNum.setText(newValue.replaceAll("[^\\d a-zA-Z ]", ""));
            System.out.println("textfield changed from " + oldValue + " to " + newValue);
        });
        password_name.textProperty().addListener((observable, oldValue, newValue) -> {
            password_name.setText(newValue.replaceAll("[^\\d a-zA-Z ]", ""));
            System.out.println("textfield changed from " + oldValue + " to " + newValue);
        });
        newPersNum.textProperty().addListener((observable, oldValue, newValue) -> {
            newPersNum.setText(newValue.replaceAll("[^\\d a-zA-Z ]", ""));
            System.out.println("textfield changed from " + oldValue + " to " + newValue);
        });
        newLogin.textProperty().addListener((observable, oldValue, newValue) -> {
            newLogin.setText(newValue.replaceAll("[^\\d a-zA-Z ]", ""));
            System.out.println("textfield changed from " + oldValue + " to " + newValue);
        });
        codeWord.textProperty().addListener((observable, oldValue, newValue) -> {
            codeWord.setText(newValue.replaceAll("[^\\d a-zA-Z ]", ""));
            System.out.println("textfield changed from " + oldValue + " to " + newValue);
        });
        newPassword.textProperty().addListener((observable, oldValue, newValue) -> {
            newPassword.setText(newValue.replaceAll("[^\\d a-zA-Z ]", ""));
            System.out.println("textfield changed from " + oldValue + " to " + newValue);
        });
        newPasswordRepeat.textProperty().addListener((observable, oldValue, newValue) -> {
            newPasswordRepeat.setText(newValue.replaceAll("[^\\d a-zA-Z ]", ""));
            System.out.println("textfield changed from " + oldValue + " to " + newValue);
        });

        anchorChangePersNum.textProperty().addListener((observable, oldValue, newValue) -> {
            anchorChangePersNum.setText(newValue.replaceAll("[^\\d a-zA-Z ]", ""));
            System.out.println("textfield changed from " + oldValue + " to " + newValue);
        });
        anchorChangeLogin.textProperty().addListener((observable, oldValue, newValue) -> {
            anchorChangeLogin.setText(newValue.replaceAll("[^\\d a-zA-Z ]", ""));
            System.out.println("textfield changed from " + oldValue + " to " + newValue);
        });
        anchorChangeSavePassword.textProperty().addListener((observable, oldValue, newValue) -> {
            anchorChangeSavePassword.setText(newValue.replaceAll("[^\\d a-zA-Z ]", ""));
            System.out.println("textfield changed from " + oldValue + " to " + newValue);
        });
        anchorChangeSaveRepeatPassword.textProperty().addListener((observable, oldValue, newValue) -> {
            anchorChangeSaveRepeatPassword.setText(newValue.replaceAll("[^\\d a-zA-Z ]", ""));
            System.out.println("textfield changed from " + oldValue + " to " + newValue);
        });
        anchorChangecodeWord.textProperty().addListener((observable, oldValue, newValue) -> {
            anchorChangecodeWord.setText(newValue.replaceAll("[^\\d a-zA-Z ]", ""));
            System.out.println("textfield changed from " + oldValue + " to " + newValue);
        });

        anchorChangeButtonCancel.setOnAction(event -> {
            ClearAnchorPassword();
            anchorAuthorization.setVisible(true);
            anchorChangePassword.setVisible(false);
            ChangeAnchorPassword(true,false);
        });
        anchorChangeSaveButtonSavePassword.setOnAction(event -> {
            if (!anchorChangeSavePassword.getText().trim().isEmpty() && !anchorChangeSaveRepeatPassword.getText().trim().isEmpty() ) {

                User a = new User(anchorChangeLogin.getText(),anchorChangeSavePassword.getText() , anchorChangeSaveRepeatPassword.getText(), anchorChangePersNum.getText(),anchorChangecodeWord.getText() );
                if(a.codeWord!= "-1")
                {
                    if(a.UserPasswordUpdate()){
                        SecondMain temp=new SecondMain("пароль успешно обновлен");
                        ClearAnchorPassword();
                        anchorAuthorization.setVisible(true);
                        anchorChangePassword.setVisible(false);
                        ChangeAnchorPassword(true,false);

                    }
                    else
                    {
                        SecondMain temp=new SecondMain("произошла ошибка");
                    }

                }
                else
                {
                    SecondMain temp=new SecondMain("пароли не совпадают, попробуйте еще раз");
                }




            }else {
                SecondMain temp=new SecondMain("заполните пустые поля");
            }

        });

        anchorChangeButtonDalee.setOnAction(event -> {
            if (!anchorChangecodeWord.getText().trim().isEmpty() && !anchorChangePersNum.getText().trim().isEmpty() && !anchorChangeLogin.getText().trim().isEmpty()) {

                User a = new User(anchorChangeLogin.getText(), "0", "0", anchorChangePersNum.getText(),anchorChangecodeWord.getText() );
                if(a.UserSearchCodeWord()== "нет такого пользователя" || a.UserSearchCodeWord()== ""  ){
                    SecondMain temp=new SecondMain("пользователь не найден, проверьте введенные данные");

                }
                else{
                    ChangeAnchorPassword(false, true);

                }


            }else {
                SecondMain temp=new SecondMain("заполните пустые поля");
            }

        });
        anchorChangeSaveButtonCancel.setOnAction(event -> {

            ChangeAnchorPassword(true,false);

        });

    labelPassord.setOnMouseClicked(new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent event) {
            anchorAuthorization.setVisible(false);
            anchorChangePassword.setVisible(true);

        }
    });

        labelPassord.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                labelPassord.setTextFill(Color.web("#022c87"));
            }
        });
        labelPassord.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
               labelPassord.setTextFill(Color.web("#b9cfff"));
            }
        });
    regNewUser.setOnAction(event -> {
        anchorAuthorization.setVisible(false);
        anchorRegistration.setVisible(true);

    });
    buttonCancel.setOnAction(event -> {
        anchorAuthorization.setVisible(true);
        anchorRegistration.setVisible(false);
    });
    exitProg.setOnAction(event -> {
        stageMain.close();
    });
    inputNewUserButton.setOnAction(event -> {
        if(!newLogin.getText().trim().isEmpty() && !newPassword.getText().trim().isEmpty() && !newPasswordRepeat.getText().trim().isEmpty()&& !newPersNum.getText().trim().isEmpty()&& !codeWord.getText().trim().isEmpty())
        {
            User a= new User(newLogin.getText(),newPassword.getText(),newPasswordRepeat.getText(),newPersNum.getText(),codeWord.getText());

            if(a.InputUserDB()==1){

                anchorAuthorization.setVisible(true);
                newLogin.clear();
                newPassword.clear();
                newPasswordRepeat.clear();
                newPersNum.clear();
                codeWord.clear();
                anchorRegistration.setVisible(false);

            }
            else {
                SecondMain temp=new SecondMain("произошла ошибка, попробуйте еще раз");
            }
        }
        else{
            SecondMain temp=new SecondMain("заполните все поля");
        }


    });
    loginButton.setOnAction((event -> {

        if (!user_name.getText().trim().isEmpty() && !password_name.getText().trim().isEmpty() && !persNum.getText().trim().isEmpty()) {

                    User a = new User(user_name.getText(), password_name.getText(), password_name.getText(), persNum.getText(), "0");

                if (a.UserSearch() == "нет такого пользователя") {
                    SecondMain temp=new SecondMain("пользователь не найден, проверьте введенные данные");
                } else {

                    try {
                        stageMain.setScene(new SceneBuilder().getScene("ConnectionDB"));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
             }else {
            SecondMain temp=new SecondMain("заполните пустые поля");
        }

       // System.out.println(a.UserSearch());

    }));
    }

}