package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.MultipleSelectionModel;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.AnchorPane;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class ControllerCompareWindow {

    @FXML
    private AnchorPane anchorpane_compare_with_itams;

    @FXML
    private ListView<String> listview_servers;

    @FXML
    private Button compare_with_selected_items;

    @FXML
    void initialize() {

        MultipleSelectionModel<String> langsSelectionModel = listview_servers.getSelectionModel();
        langsSelectionModel.setSelectionMode(SelectionMode.MULTIPLE);
        ReadNameFile();
        //final Connection[] db1 = {null};
        //DB_Work[] dbWork=new DB_Work[]
        compare_with_selected_items.setOnAction(event -> {
        ObservableList<String> selected = langsSelectionModel.getSelectedItems();
        for (String item : selected) {
            FileReader red = null;
            try {
                red = new FileReader("E://name_DB/" + item);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

            Scanner fr = new Scanner(red);
            DB_Work dbWork = new DB_Work(fr.nextLine(), fr.nextLine(), fr.nextLine(), fr.nextLine());
            //dbWork = Connectiondatabase(fr.nextLine(), fr.nextLine(), fr.nextLine(), fr.nextLine());


            try {
                red.close();
            } catch (IOException e) {
                e.printStackTrace();
            }


            Statement PR = null;


            ResultSet rs = null;
            Statement PR1 = null;


            ResultSet rs1 = null;


            SaveConnection d=SaveConnection.getInstance();

            rs = dbWork.Use(d.dbWorks[0].GetNameUse());
            rs = dbWork.ShowDesc(d.dbWorks[0].GetNameTable());
            rs = dbWork.SelectFrom(d.dbWorks[0].GetNameTable());

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

            rs1 = d.dbWorks[0].Use(d.dbWorks[0].GetNameUse());
            rs1 = d.dbWorks[0].ShowDesc(d.dbWorks[0].GetNameTable());
            rs1 =d.dbWorks[0].SelectFrom(d.dbWorks[0].GetNameTable());

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

            String tem = "";
            String tem1 = "";
            while (true) {

                try {
                    if (!rs.next()) break;
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                try {

                    tem = tem + rs.getString(1);

                    System.out.println(rs.getString("name"));
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }


            }
            while (true) {

                try {
                    if (!rs1.next()) break;
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                try {

                    tem1 = tem1 + rs1.getString(1);
                    ;
                    System.out.println(rs1.getString("name"));
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }


            }
            tem1 = HechSum(tem1);
            tem = HechSum(tem);
            if (CompareHechSum(tem1, tem)) {
                System.out.println("sovpadaet");
            } else {
                InputDateDB(rs, rs1);

            }


        }
        });
    }


    private boolean CompareHechSum(String a, String b) {
        return a.equals(b);
    }

    private void InputDateDB(ResultSet a, ResultSet b) {


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

        while (true) {
            String c = "";
            int i = 0;
            try {
                b.first();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            while (true) {
                try {
                    if (b.getString(2).equals(a.getString(2))) {
                        i++;
                        break;
                    }
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }


                try {
                    if (!b.next()) break;
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }


            if (i == 0) {


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
                if (!a.next()) break;
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }


    }
    private void ReadNameFile(){
        File dir=new  File("E://name_DB");
        ObservableList <String> it_2= FXCollections.observableArrayList();
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

    private String HechSum(String a) {

        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        byte[] hashInBytes = md.digest(a.getBytes(StandardCharsets.UTF_8));

        //bytes to hex
        StringBuilder sb = new StringBuilder();
        for (byte b : hashInBytes) {
            sb.append(String.format("%02x", b));
        }
        System.out.println(sb.toString());
        return sb.toString();
    }

}
