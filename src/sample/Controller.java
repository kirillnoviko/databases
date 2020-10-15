package sample;

import java.io.*;
import java.net.URL;
import java.util.*;

import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;

import java.lang.reflect.InvocationTargetException;

import java.sql.*;
import java.util.List;


import java.io.FileNotFoundException;

import javafx.scene.paint.Color;
import javafx.stage.Stage;



public class Controller {
        @FXML
        private AnchorPane anchoPane_seting;
        @FXML
        private AnchorPane AnchorPane;
        @FXML
        private AnchorPane AnchorPaneMain;

        @FXML
        private Button button_create_connection;
        @FXML
        private Button change_connection;
        @FXML
        private Button create_a_new_connection;
        @FXML
        private Button button_create_connection1;



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
        private MenuButton menubutton;
        @FXML
        private MenuItem MenuButtonConnect;

        @FXML
        private TableView<ObservableList<String>> table_select;
        @FXML
        private Button connection_bd;
        @FXML
        private ResourceBundle resources;

        @FXML
        private URL location;

        @FXML
        private PasswordField password_1;


        @FXML
        private ListView<String> text_table;

        @FXML
        private ListView<String> text_select;
        @FXML
        private Button conn;

        @FXML
        private ListView<String> textarray;

        @FXML
        private TableColumn<ObservableList<String>, String> colum_select;
        @FXML
        private Button button_select;
        @FXML
        private TextField username_1;
        @FXML
        private AnchorPane Anchor_window_connection;
        @FXML
        private TableView<User> table=new TableView<User>();


        @FXML
        private TableColumn<User, Integer> table_col_1;

        @FXML
        private TableColumn<User, Integer> table_col_2;

        @FXML
        private TextField username_2;

        @FXML
        private PasswordField password_2;
        @FXML
         private TabPane tabpane;

    @FXML
    private Label label_localServer;

    @FXML
    private Label label_remoteServer;

    private Stage primarystage;


    @FXML
    void initialize() {


        final Connection[] db = {null};

        create_a_new_connection.setOnAction(event -> {

            OnVisible_Anchor(AnchorPane);
            setScenePrimaryStage(1);
            label_localServer.setVisible(true);
            OffVisible_Anchor(Anchor_window_connection);

        });
        MenuButtonConnect.setOnAction(event->{

                OffVisible_Anchor(anchoPane_seting);




                File dir=new  File("E://ad");
                File  dir1=new File ("E://ad1");
                 if(dir.isDirectory()) {

                            if(dir.listFiles().length >  0)
                        {
                                OnVisivle_Anchor_SettingConnection(dir,dir1,db);
                        }
                        else {

                             AnchorPane.setVisible(true);
                             setScenePrimaryStage(1);
                        }
                }
                else
                {   }

        });
        button_create_connection.setOnAction(event -> {

            OnVisible_Anchor(AnchorPane);
            setScenePrimaryStage(1);
            FileWriter("E://ad//");
            //File dir=new  File("E://ad");
           // OnVisivle_Anchor_SettingConnection(dir,db);
            button_create_connection.setVisible(false);
            button_create_connection1.setVisible(true);
            label_localServer.setVisible(false);
            label_remoteServer.setVisible(true);

        });
        button_create_connection1.setOnAction(event -> {
            OnVisible_Anchor(AnchorPane);
            setScenePrimaryStage(1);
            File dir=new  File("E://ad");
            File dir1=new  File("E://ad1");
            FileWriter("E://ad1//");
            OnVisivle_Anchor_SettingConnection(dir,dir1,db);
        });
        button_select.setOnAction(event -> {


            ResultSet temp = null;
            Statement PR= null;
            Statement PR1=null;
            ResultSet rs= null;
            ResultSet temp_11=null;


            try {
                PR= db[0].createStatement();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            try {
                rs = PR.executeQuery("use " + table.getSelectionModel().getSelectedItem().getName()+ " ;");
                rs=PR.executeQuery("desc "+ text_table.getSelectionModel().getSelectedItem() + " ;");
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }


table_select.getColumns().clear();

            int b=0;

            List<String> a1 = new ArrayList<>();
            while(true)
            {

                try {
                    if (!rs.next()) break;
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }


                try {
                    a1.add(rs.getString(1));
                    //a1.set(b,rs.getString(1));
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }


                //  qq.setCellValueFactory(new PropertyValueFactory<select,String>(rs.getString(1)));
                   // table_select.getColumns().add(qq);

                   // table_select.setItems(it_2);


                 //   table_select.getColumns().get (0).setCellValueFactory( new PropertyValueFactory<>(rs.getString(1)));




                    //qq.setVisible(true);

                    //it_2.clear();

                b++;
            }

            for(int i=0;i< a1.size();i++)
            {
                int xerr=i;
                TableColumn<ObservableList<String>,String>  qq = new TableColumn<ObservableList<String>, String>(a1.get(i));
                qq.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().get(xerr)));
                table_select.getColumns().add(qq);
            }



           // String property="sdg";
            //table_select.getColumns().get(0).setCellValueFactory(new   PropertyValueFactory( "nnnn"));
            //table_select.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("name1"));
            try {
                PR1= db[0].createStatement();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            try {
                temp_11=PR1.executeQuery(" select * from " + text_table.getSelectionModel().getSelectedItem() + " ; ");
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }


            ObservableList <String> it_2=FXCollections.observableArrayList();

         //   select p;

            while (true)
            {
           //      p=new select();
                try {
                    if(! temp_11.next()) break;
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }


               ObservableList <String> it_3=FXCollections.observableArrayList();
                List<String> a2 = new ArrayList<>();
                for(int i=0;i<=b-1;i++) {
                    try {
                        a2.add(temp_11.getString(i+1));
                       // a2.set(i,temp_11.getString(i));
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                }


                    it_3.addAll(a2);
               table_select.getItems().add(it_3);


            }
//table_select.setItems(it_2);
     
            //for(int i=0;i<=b-1;i++)
            //{

               // table_select.getColumns().get(i).setText("xerrrrr");
          //      table_select.getColumns().get(i).setText("sdjhg");


               // table_col_1.setCellValueFactory(new PropertyValueFactory<User,String>("name")         );
            //}







            try {
                PR.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }



        });
        connection_bd.setOnAction(event -> {

           //Connection db=null;
            Statement PR= null;
            //db=Connectiondatabase();
            ResultSet rs= null;
            try {
                PR= db[0].createStatement();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

         try {
           //  rs = PR.executeQuery("use "+ textarray.getSelectionModel().getSelectedItem() + " ;");
             rs=PR.executeQuery("use "+ table.getSelectionModel().getSelectedItem().getName()+" ;");
             rs=PR.executeQuery("show tables;");
         } catch (SQLException throwables) {
             throwables.printStackTrace();
         }
            ObservableList <String> it_2=FXCollections.observableArrayList();
         while(true)
             {
                 try {
                     if (!rs.next()) break;
                 } catch (SQLException throwables) {
                     throwables.printStackTrace();
                 }

                 try {
                     it_2.add(rs.getString(1));

                 } catch (SQLException throwables) {
                     throwables.printStackTrace();
                 }


             }
         text_table.setItems(it_2);
            try {
                PR.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        


        });
        conn.setOnAction(event -> {
        // Connectiondatabase();
          primarystage.setHeight(960);
          primarystage.setWidth(1345);
         Statement st = null;
         try {
             st = db[0].createStatement();
         } catch (SQLException throwables) {
             throwables.printStackTrace();
         }
         ResultSet rs = null;
         try {
             rs = st.executeQuery("Show Databases");
         } catch (SQLException throwables) {
             throwables.printStackTrace();
         }
         ObservableList<User> it= FXCollections.observableArrayList();
         ObservableList <String> it_1=FXCollections.observableArrayList();
         Integer kk=0;

         while (true){
             try {
                 if (!rs.next()) break;
             } catch (SQLException throwables) {
                 throwables.printStackTrace();
             }
             try {
                kk+=1;
                it.add(new User(rs.getString(1),kk));
                 System.out.println(rs.getString(1));
                 it_1.add(rs.getString(1));
             } catch (SQLException throwables) {
                 throwables.printStackTrace();
             }
         }
                 //textarray.setItems(it_1);

                table.setItems(it);

                table_col_1.setCellValueFactory(new PropertyValueFactory<User,Integer>("id")      );

                table_col_2.setCellValueFactory(
                new PropertyValueFactory<User,Integer>("name") );
                table.setVisible(true);


     });
    }

    public void setPrimaryStage(Stage primaryStage) {
        this.primarystage=primaryStage;
    }

    public void setScenePrimaryStage( int a) {

        switch(a)
        {
            case 1:

                this.primarystage.setHeight(418);
                this.primarystage.setWidth(479);
                break;

            case 2:
                this.primarystage.setHeight(960);
                this.primarystage.setWidth(1345);
                break;

            case 3:
                this.primarystage.setHeight(597);
                this.primarystage.setWidth(755);
                break;

        }
    }

    

    public void OnVisivle_Anchor_SettingConnection(File dir,File dir1,Connection[] db){

        OnVisible_Anchor(Anchor_window_connection);
        setScenePrimaryStage(3);

        //temp.getTabs().clear();
        for (File item : dir.listFiles()) {
            TabPane a=new TabPane();
            for (File item1 : dir1.listFiles()) {
               // if (item.getName() == item.getName()) {

                a.getTabs().add(OnvisibleTabpane(dir+"//"+item.getName(),db,0));
                a.getTabs().add(OnvisibleTabpane(dir1+"//"+item1.getName(),db,1));
                GridPane p=new GridPane();
                p.add(a,1,1);
                Tab a1=new Tab("qwrq",a);
                tabpane.getTabs().add(a1);
            //}
        }

    }
    }


    public Tab OnvisibleTabpane(String item,Connection[] db,int h)
    {
        FileReader red = null;
        try {
            red = new FileReader(item);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        Scanner fr = new Scanner(red);
        GridPane p = new GridPane();
        List<Label> labels = new ArrayList<>();


        for (int i = 0; i < 4; i++) {


            switch (i) {
                case 0: {
                    labels.add(new Label("hostname: "));
                }
                case 1: {
                    labels.add(new Label("hostport: "));
                }
                case 2: {
                    labels.add(new Label("username: "));
                }
                case 3: {
                    labels.add(new Label("password: "));
                }
                break;
                default:
                    throw new IllegalStateException("Unexpected value: " + i);
            }
            labels.get(i).setTextFill(Color.web("#FFFFFFFF"));
            labels.get(i).setFont(new Font(30));
            p.add(labels.get(i), 1, i + 1);
        }


        List<Label> info_about_labels = new ArrayList<>();


        while (fr.hasNextLine()) {
            info_about_labels.add(new Label(fr.nextLine()));

        }
        for (int i = 0; i < info_about_labels.size(); i++) {
            info_about_labels.get(i).setTextFill(Color.web("#FFFFFFFF"));
            info_about_labels.get(i).setFont(new Font(30));
            p.add(info_about_labels.get(i), 2, i + 1);
        }


        try {
            red.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


        AnchorPane bb = new AnchorPane();
        bb.setStyle("-fx-background-color : #ffffff");

        Button connection_server = new Button(" CONNECTION SERVER ");
        Button change_connection_server = new Button("Change connection");

        p.add(change_connection_server, 1, 5);
        p.add(connection_server, 2, 5);

        Tab a = new Tab(item, p);


        connection_server.setOnAction(event1 -> {

            db[h] = Connectiondatabase(info_about_labels.get(0).getText(), info_about_labels.get(1).getText(), info_about_labels.get(2).getText(), info_about_labels.get(3).getText());

            OffVisible_Anchor(Anchor_window_connection);
            OnVisible_Anchor(anchoPane_seting);
            setScenePrimaryStage(2);


           // temp.getTabs().clear();
        });

        change_connection_server.setOnAction(event2 -> {
            OnVisible_Anchor(AnchorPane);
            setScenePrimaryStage(1);
            OffVisible_Anchor(Anchor_window_connection);


            connection_name.setText(item);
            host_name.setText(info_about_labels.get(0).getText());
            port_name.setText(info_about_labels.get(1).getText());
            User_name.setText(info_about_labels.get(2).getText());
            password_name.setText(info_about_labels.get(3).getText());
            File red1 = new File(item);
            red1.delete();
        });

        //temp.getTabs().add(a);
return a;
    }


    public void OnVisible_Anchor( AnchorPane a){
        a.setVisible(true);
    }

    public void OffVisible_Anchor( AnchorPane a){
        a.setVisible(false);
    }

    public  void FileWriter(String dirname){
        FileWriter temp= null;
        try {
            temp = new FileWriter(dirname+"//"+connection_name.getText()+".txt",false);
        } catch (IOException e) {
            e.printStackTrace();
        }

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

    }

    public class User{
        private IntegerProperty xer;
        private StringProperty name_1;


    public User(String name_2,Integer id) {
        this.xer = new SimpleIntegerProperty(this, "xe", id);
        this.name_1 = new SimpleStringProperty(this, "name_3", name_2);
    }

        public void setId(int id) {
            this.xer.set(id);
        }

        public int getId() {
            return xer.get();
        }

        public void setName(String name) {
            this.name_1.set(name);
        }

        public String getName() {
            return name_1.get();
        }

        public IntegerProperty idProperty() {
            return xer;
        }

        public StringProperty nameProperty() {
            return name_1;
        }


    }


    private Connection Connectiondatabase(String localhost,String port, String name,String password) {

        String url ="jdbc:mysql://" + localhost + ":" + port +"/qq?serverTimezone=Europe/Moscow&useSSL=false";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
        } catch (ClassNotFoundException | NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        Connection connection= null;
        try {
            connection = DriverManager.getConnection(url,name,password);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


        return connection;
    }

}

