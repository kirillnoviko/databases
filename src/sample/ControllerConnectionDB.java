package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


import javafx.scene.control.PasswordField;

import static sample.Main.stageMain;
import javafx.scene.control.TextField;


public class ControllerConnectionDB {

    @FXML
    private AnchorPane Anchor_window_connection;

    @FXML
    private TabPane tabPaneConnection;

    @FXML
    private Button change_connection_button;

    @FXML
    private Button create_a_new_connection_button;

    @FXML
    private AnchorPane AnchorPane;

    @FXML
    private TextField port_name;

    @FXML
    private TextField host_name;

    @FXML
    private TextField User_name;

    @FXML
    private PasswordField password_name;

    @FXML
    private TextField connection_name;

    @FXML
    private Button button_create_connection;

    DB_Work[] dbWork ;

   /* public ControllerConnectionDB (){
        dbWork= new DB_Work[10];

    }*/

    public void Scene(){
        try {
            stageMain.setScene(new SceneBuilder().getScene("ConnectionDB"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    void initialize() {

        dbWork= new DB_Work[10];
        File dir = new File("E://ad");

        if (dir.isDirectory()) {

            if (dir.listFiles().length > 0) {
                for (File item : dir.listFiles()) {

                    FileReader red = null;
                    try {
                        red = new FileReader(dir + "//" + item.getName());
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                    GridPane p = new GridPane();
                    Scanner fr = new Scanner(red);
                    List<Label> temper = new ArrayList<>();
                    Label label_nameconnection = new Label();
                    Label label_hostname = new Label();
                    Label label_nameport = new Label();
                    Label label_username = new Label();
                    Label label_password = new Label();

                    label_hostname.setTextFill(Color.web("#FFFFFFFF"));
                    label_hostname.setFont(new Font(16));
                    label_nameconnection.setTextFill(Color.web("#FFFFFFFF"));
                    label_nameconnection.setFont(new Font(16));
                    label_nameport.setTextFill(Color.web("#FFFFFFFF"));
                    label_nameport.setFont(new Font(16));
                    label_username.setTextFill(Color.web("#FFFFFFFF"));
                    label_username.setFont(new Font(16));
                    label_password.setTextFill(Color.web("#FFFFFFFF"));
                    label_password.setFont(new Font(16));

                    for (int i = 0; i < 4; i++) {

                        switch (i) {
                            case 0: {
                                temper.add(new Label("HOSTNAME: "));

                            }
                            case 1: {
                                temper.add(new Label("HOSTPORT: "));
                            }
                            case 2: {
                                temper.add(new Label("USERNAME: "));
                            }
                            case 3: {
                                temper.add(new Label("PASSWORD: "));
                            }
                            break;
                            default:
                                throw new IllegalStateException("Unexpected value: " + i);
                        }
                        temper.get(i).setTextFill(Color.web("#FFFFFFFF"));
                        temper.get(i).setFont(new Font(16));
                        p.add(temper.get(i), 1, i + 1);
                       p.gridLinesVisibleProperty();
                    }
                    while (fr.hasNextLine()) {
                        label_nameconnection.setText(item.getName());
                        label_hostname.setText(fr.nextLine());
                        label_nameport.setText(fr.nextLine());
                        label_username.setText(fr.nextLine());
                        label_password.setText(fr.nextLine());

                    }


                    try {
                        red.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    // });


                    System.out.println("folder");
                    Anchor_window_connection.setVisible(true);
                    //untitled1.getTabPane().getTabs().clear();


                    AnchorPane bb = new AnchorPane();


                    Button b = new Button(" CONNECTION SERVER ");

                    // p.add(label_nameconnection,2,1);
                    p.add(label_hostname, 2, 1);
                    p.add(label_nameport, 2, 2);
                    p.add(label_username, 2, 3);
                    p.add(label_password, 2, 4);
                    p.add(b, 1, 5);

                    Tab a = new Tab("adg", p);

                    a.setText("server" + label_nameconnection.getText());
                    bb.setStyle("-fx-background-color : #ffffff");

                    b.setOnAction(event1 -> {

                        dbWork[0] = new DB_Work(label_hostname.getText(), label_nameport.getText(), label_username.getText(), label_password.getText());
                        SaveConnection save_db=SaveConnection.getInstance(dbWork);


                        Anchor_window_connection.setVisible(false);
                        try {
                            stageMain.setScene(new SceneBuilder().getScene("MainWindow"));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        //anchoPane_seting.setVisible(true);
                        tabPaneConnection.getTabs().clear();
                    });

                 /*   b.setOnAction(event2 -> {

                        AnchorPane.setVisible(true);
                        Anchor_window_connection.setVisible(false);
                        connection_name.setText(label_nameconnection.getText());
                        host_name.setText(label_hostname.getText());
                        port_name.setText(label_nameport.getText());
                        User_name.setText(label_username.getText());
                        password_name.setText(label_password.getText());

                    });*/

                    tabPaneConnection.getTabs().add(a);

                }
            } else {
                System.out.println("file");
                AnchorPane.setVisible(true);
            }
        } else {

        }



        create_a_new_connection_button.setOnAction(event -> {

            AnchorPane.setVisible(true);

           // Anchor_window_connection.setVisible(false);


        });



        button_create_connection.setOnAction(event -> {

            //dbWork[0]=new DB_Work(host_name.getText(),port_name.getText(),User_name.getText(),password_name.getText());
            //SaveConnection.getInstance(dbWork);
            // db[0] =Connectiondatabase(host_name.getText(),port_name.getText(),User_name.getText(),password_name.getText());
            AnchorPane.setVisible(false);
            try {
                stageMain.setScene(new SceneBuilder().getScene("MainWindow"));
            } catch (IOException e) {
                e.printStackTrace();
            }

            FileWriter temp= null;
            try {
                temp = new FileWriter("E://ad//"+connection_name.getText()+".txt",false);
            } catch (IOException e) {
                e.printStackTrace();
            }
            /*try {
                temp.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
            FileWriter
            /*try {
                db.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }*/
            try {
                temp.write(host_name.getText()+"\n"+port_name.getText()+"\n"+User_name.getText()+"\n"+password_name.getText()+"\n");
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                temp.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                temp.close();
            } catch (IOException e) {
                e.printStackTrace();
            }



            FileReader red=null;
            try {
                red=new FileReader("E://ad//"+connection_name.getText()+".txt");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

            Scanner fr=new Scanner(red);
            while(fr.hasNextLine()){
                System.out.println(fr.nextLine());
            }
            try {
                red.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

}
