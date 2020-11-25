package sample;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import static sample.Main.stageMain;
public class ControllerMainWindow {

    @FXML
    private ButtonBar buttonbar;

    @FXML
    private AnchorPane anchoPane_seting;

    @FXML
    private ListView<String> table;


    @FXML
    private MenuButton menubutton;

    @FXML
    private MenuItem settingConnection;

    @FXML
    private MenuItem buttonChangeAc;

    @FXML
    private MenuItem buttonExit;

    @FXML
    private Button buttonSelectTable;

    @FXML
    private ListView<String> text_table;

    @FXML
    private Button buttonBack;

    @FXML
    private Button buttonNext;
    @FXML
    private TableColumn<User, Integer> table_col;

    @FXML
    void initialize() {



        ResultSet rs = null;

        SaveConnection d = SaveConnection.getInstance();
        rs = d.dbWorks[0].ShowDatabases();

        ObservableList<String> it = FXCollections.observableArrayList();



        while (true) {
            try {
                if (!rs.next()) break;
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            try {

                it.add(rs.getString(1));
                System.out.println(rs.getString(1));

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }


         table.setItems(it);


        table.setVisible(true);
        text_table.setVisible(false);



        settingConnection.setOnAction(event -> {
            try {
                stageMain.setScene(new SceneBuilder().getScene("ConnectionDB"));
            } catch (IOException e) {
                e.printStackTrace();
            }

        });
        buttonNext.setOnAction(event -> {
            SaveConnection dd = SaveConnection.getInstance();
            dd.dbWorks[0].SetNameTable(text_table.getSelectionModel().getSelectedItem());
            try {
                stageMain.setScene(new SceneBuilder().getScene("InsertWindow"));
            } catch (IOException e) {
                e.printStackTrace();
            }

        });
        buttonSelectTable.setOnAction(event -> {

            ResultSet r = null;

            SaveConnection dd = SaveConnection.getInstance();
            r = dd.dbWorks[0].Use(table.getSelectionModel().getSelectedItem());
            dd.dbWorks[0].SetNameUse(table.getSelectionModel().getSelectedItem());
            r = dd.dbWorks[0].ShowTables();
            ObservableList<String> it_2 = FXCollections.observableArrayList();
            while (true) {
                try {
                    if (!r.next()) break;
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }

                try {
                    it_2.add(r.getString(1));

                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }


            }
            text_table.setItems(it_2);

            text_table.setVisible(true);
            table.setVisible(false);

            buttonbar.setVisible(true);
            buttonSelectTable.setVisible(false);



        });





    }

}




