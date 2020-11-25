package sample;

import java.io.*;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;

import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Scene;
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

import static sample.Main.stageMain;

public class Controller {

        @FXML
        private AnchorPane anchoPane_seting;
        @FXML
        private Button button_create_connection;
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
        private Button change_connection;

        @FXML
        private Button create_a_new_connection;

        @FXML
        private MenuButton menubutton;

        @FXML
        private MenuItem MenuButtonConnect;

        @FXML
        private AnchorPane AnchorPane;

        @FXML
        private AnchorPane AnchorPaneMain;

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
    private Button button_insert;

    @FXML
    private Button button_update;

    @FXML
    private Button button_compare;

    @FXML
    private Button button_synchronize;

    @FXML
    private AnchorPane anchorpane_compare_with_itams;

    @FXML
    private ListView<String> listview_servers;

    @FXML
    private Button compare_with_selected_items;



    @FXML
    void initialize() {

        final Connection[] db = {null};
        MultipleSelectionModel<String> langsSelectionModel = listview_servers.getSelectionModel();
        langsSelectionModel.setSelectionMode(SelectionMode.MULTIPLE);
        button_compare.setOnAction(event -> {

            anchorpane_compare_with_itams.setVisible(true);
            anchoPane_seting.setVisible(false);
            ReadNameFile();

        });

        compare_with_selected_items.setOnAction(event -> {

            final Connection[] db1 = {null};
DB_Work[] dbWork=new DB_Work[10];
            ObservableList<String> selected = langsSelectionModel.getSelectedItems();
            for (String item : selected) {
                FileReader red = null;
                try {
                    red = new FileReader("E://name_DB/" + item);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }

                Scanner fr = new Scanner(red);
                dbWork[1]=new DB_Work(fr.nextLine(), fr.nextLine(), fr.nextLine(), fr.nextLine());
                //db1[0] = Connectiondatabase(fr.nextLine(), fr.nextLine(), fr.nextLine(), fr.nextLine());


                try {
                    red.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }


                Statement PR = null;


                ResultSet rs = null;
                Statement PR1 = null;


                ResultSet rs1 = null;

                rs= dbWork[1].Use(table.getSelectionModel().getSelectedItem().getName());
                rs=dbWork[1].ShowDesc(text_table.getSelectionModel().getSelectedItem());
                rs=dbWork[1].SelectFrom(text_table.getSelectionModel().getSelectedItem());
                /*
                try {
                    PR = db1[0].createStatement(
                            ResultSet.TYPE_SCROLL_INSENSITIVE,
                            ResultSet.CONCUR_UPDATABLE
                    );
                } catch (SQLException throwables) {

                    throwables.printStackTrace();
                }

                try {
                    rs = PR.executeQuery("use " + table.getSelectionModel().getSelectedItem().getName() + " ;");
                    rs = PR.executeQuery("desc " + text_table.getSelectionModel().getSelectedItem() + " ;");
                   rs=PR.executeQuery(" select * from " + text_table.getSelectionModel().getSelectedItem() + " ; ");

                } catch (SQLException throwables) {
                    throwables.printStackTrace();


                }
                */

                rs1= dbWork[0].Use(table.getSelectionModel().getSelectedItem().getName());
                rs1=dbWork[0].ShowDesc(text_table.getSelectionModel().getSelectedItem());
                rs1=dbWork[0].SelectFrom(text_table.getSelectionModel().getSelectedItem());
                /*
                try {
                    PR1= db[0].createStatement(
                            ResultSet.TYPE_SCROLL_INSENSITIVE,
                            ResultSet.CONCUR_UPDATABLE
                    );
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }

                try {
                    rs1 = PR1.executeQuery("use " + table.getSelectionModel().getSelectedItem().getName()+ " ;");
                    rs1=PR1.executeQuery("desc "+ text_table.getSelectionModel().getSelectedItem() + " ;");
                    rs1=PR1.executeQuery(" select * from " + text_table.getSelectionModel().getSelectedItem() + " ; ");
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                */

                String tem="";
                String tem1="";
                while (true)
                {

                    try {
                        if(! rs.next()) break;
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                    try {

                        tem=tem+rs.getString(1);;
                        System.out.println(rs.getString("name"));
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }


                }
                while (true)
                {

                    try {
                        if(! rs1.next()) break;
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                    try {

                        tem1=tem1+rs1.getString(1);;
                        System.out.println(rs1.getString("name"));
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }


                }
               tem1= HechSum(tem1);
               tem=HechSum(tem);
                if(CompareHechSum(tem1,tem))
                {
                    System.out.println("sovpadaet");
                }else
                {
                   InputDateDB(rs,rs1);

                }



            }
        });

        create_a_new_connection.setOnAction(event -> {

            AnchorPane.setVisible(true);

            Anchor_window_connection.setVisible(false);


        });

        MenuButtonConnect.setOnAction(event->{

    anchoPane_seting.setVisible(false);




    File dir=new  File("E://ad");
   // boolean creat=dir.mkdir();
    if(dir.isDirectory()) {

        if(dir.listFiles().length >  0) {
            for (File item : dir.listFiles()) {

                FileReader red=null;
                try {
                    red=new FileReader(dir+"//"+item.getName());
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                GridPane p=new GridPane();
                Scanner fr=new Scanner(red);
                List <Label> temper = new ArrayList<>();
                Label label_nameconnection=new Label();
                Label label_hostname=new Label();
                Label label_nameport=new Label();
                Label label_username=new Label();
                Label label_password=new Label();

                label_hostname.setTextFill(Color.web("#FFFFFFFF"));
                label_hostname.setFont(new Font(20));
                label_nameconnection.setTextFill(Color.web("#FFFFFFFF"));
                label_nameconnection.setFont(new Font(30));
                label_nameport.setTextFill(Color.web("#FFFFFFFF"));
                label_nameport.setFont(new Font(20));
                label_username.setTextFill(Color.web("#FFFFFFFF"));
                label_username.setFont(new Font(20));
                label_password.setTextFill(Color.web("#FFFFFFFF"));
                label_password.setFont(new Font(20));

                for(int i=0;i<4;i++){

                    switch (i) {
                        case 0: {
                            temper.add(new Label("hostname: "));
                        }
                        case 1: {
                            temper.add(new Label("hostport: "));
                        }
                        case 2: {
                            temper.add(new Label("username: "));
                        }
                        case 3: {
                            temper.add(new Label("password: "));
                        }
                        break;
                        default:
                            throw new IllegalStateException("Unexpected value: " + i);
                    }
                    temper.get(i).setTextFill(Color.web("#FFFFFFFF"));
                    temper.get(i).setFont(new Font(30));
                    p.add(temper.get(i),1,i+1);
                }
                while(fr.hasNextLine()){
                    label_nameconnection.setText( item.getName());
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
                p.add(label_hostname,2,1);
                p.add(label_nameport,2,2);
                p.add(label_username,2,3);
                p.add(label_password,2,4);
                p.add(b,1,5);

                Tab a = new Tab("adg", p);

                a.setText("server"+label_nameconnection.getText());
                bb.setStyle("-fx-background-color : #ffffff");

                b.setOnAction(event1 -> {
                    //dbWork[0] =new DB_Work(label_hostname.getText(),label_nameport.getText(),label_username.getText(),label_password.getText());
                   // db[0] =Connectiondatabase(label_hostname.getText(),label_nameport.getText(),label_username.getText(),label_password.getText());

                    Anchor_window_connection.setVisible(false);
                    anchoPane_seting.setVisible(true);
                    tabpane.getTabs().clear();
                });

                b.setOnAction(event2 -> {

                    AnchorPane.setVisible(true);
                    Anchor_window_connection.setVisible(false);
                    connection_name.setText(label_nameconnection.getText());
                    host_name.setText(label_hostname.getText());
                    port_name.setText(label_nameport.getText());
                    User_name.setText(label_username.getText());
                    password_name.setText(label_password.getText());

                });

                tabpane.getTabs().add(a);

            }
        }
        else {
            System.out.println("file");
            AnchorPane.setVisible(true);
        }
    }

   else
    {

    }




});

        button_create_connection.setOnAction(event -> {
         //   dbWork[0]=new DB_Work(host_name.getText(),port_name.getText(),User_name.getText(),password_name.getText());
          // db[0] =Connectiondatabase(host_name.getText(),port_name.getText(),User_name.getText(),password_name.getText());
            AnchorPane.setVisible(false);
            anchoPane_seting.setVisible(true);
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
        DB_Work[] dbWork = new DB_Work[10];

        button_select.setOnAction(event -> {



            Statement PR= null;
            Statement PR1=null;

            ResultSet rs= null;
            ResultSet temp_11=null;


           rs= dbWork[0].Use(table.getSelectionModel().getSelectedItem().getName());
           rs= dbWork[0].ShowDesc(text_table.getSelectionModel().getSelectedItem());
          /*  try {
                PR= db[0].createStatement();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

            try {
                rs = PR.executeQuery("use " + table.getSelectionModel().getSelectedItem().getName()+ " ;");
                rs=PR.executeQuery("desc "+ text_table.getSelectionModel().getSelectedItem() + " ;");
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }*/

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


                b++;
            }

            for(int i=0;i< a1.size();i++)
            {
                int xerr=i;
                TableColumn<ObservableList<String>,String>  qq = new TableColumn<ObservableList<String>, String>(a1.get(i));
                qq.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().get(xerr)));
                table_select.getColumns().add(qq);
            }


           temp_11= dbWork[0].SelectFrom(text_table.getSelectionModel().getSelectedItem());
            /*try {
                PR1= db[0].createStatement();

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            try {
                temp_11=PR1.executeQuery(" select * from " + text_table.getSelectionModel().getSelectedItem() + " ; ");

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }*/


            ObservableList <String> it_2=FXCollections.observableArrayList();


            String tem="";
            while (true)
            {

                try {
                    if(! temp_11.next()) break;
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                try {
                    tem=tem+temp_11.getString(1);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }


                ObservableList <String> it_3=FXCollections.observableArrayList();
                List<String> a2 = new ArrayList<>();
                for(int i=0;i<=b-1;i++) {
                    try {
                        a2.add(temp_11.getString(i+1));

                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                }


                    it_3.addAll(a2);
               table_select.getItems().add(it_3);


            }







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
          /*  try {
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
         }*/
            rs=dbWork[0].Use(table.getSelectionModel().getSelectedItem().getName());
            rs=dbWork[0].ShowTables();
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
        /* Statement st = null;
         try {
             st = db[0].createStatement();
         } catch (SQLException throwables) {
             throwables.printStackTrace();
         }*/
         ResultSet rs = null;
         /*try {
             rs = st.executeQuery("Show Databases");
         } catch (SQLException throwables) {
             throwables.printStackTrace();
         }*/
            //DB_Work temp= new DB_Work();
           rs= dbWork[0].ShowDatabases();
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
        button_insert.setOnAction(event ->
        {
            try {
                stageMain.setScene(new SceneBuilder().getScene("RegistrAndAuthorizat"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

    }

    public static class User{
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

    private boolean CompareHechSum( String a,String b)
    {
       return a.equals(b);
    }

    private void InputDateDB(ResultSet a,ResultSet b)
    {


        try {
            a.first();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
           b.first();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        while (true)
        {
            String c = "";
            int i=0;
            try {
                b.first();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            while(true) {
                try {
                    if(b.getString(2).equals(a.getString(2)))
                    {
                        i++;break;
                    }
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }


                try {
                    if(! b.next()) break;
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }


            if (i==0) {


                try {
                    c = a.getString(2);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }


                try {
                    b.moveToInsertRow();
                    b.updateString(2, c);
                   b.updateString(1, c);
                    b.insertRow();
                    b.moveToCurrentRow();
                    //rs1.updateString(2,a);
                    //rs1.updateRow();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }


            }
            try {
                if(! a.next()) break;
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }





    }




    private String HechSum(String a)
    {

        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        byte[]hashInBytes = md.digest(a.getBytes(StandardCharsets.UTF_8));

        //bytes to hex
        StringBuilder sb = new StringBuilder();
        for (byte b : hashInBytes) {
            sb.append(String.format("%02x", b));
        }
        System.out.println(sb.toString());
        return sb.toString();
    }
    private void ReadNameFile(){
        File dir=new  File("E://name_DB");
        ObservableList <String> it_2=FXCollections.observableArrayList();
        if(dir.isDirectory()) {

            if (dir.listFiles().length > 0) {
                for (File item : dir.listFiles()) {

                    //FileReader red = null;
                    it_2.add(item.getName());
                    listview_servers.setItems(it_2);



                }
            }
        }


    }
   /* private Connection Connectiondatabase(String localhost,String port, String name,String password) {

        String url ="jdbc:mysql://" + localhost + ":" + port +"/?serverTimezone=Europe/Moscow&useSSL=false";
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
*/
}

