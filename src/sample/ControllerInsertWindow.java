package sample;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;

import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static sample.Main.stageMain;

public class ControllerInsertWindow {

    @FXML
    private BorderPane boarderPaneQueryAndCompare;

    @FXML
    private ListView<String> listTableCompare;

    @FXML
    private CheckBox CheckboxCompareTable;

    @FXML
    private Button compareWithSelectItem;

    @FXML
    private TableView<ObservableList<String>> tableSelect;

    @FXML
    private Button buttonExucutedQueru;

    @FXML
    private TextArea textAreaForQuery;

    @FXML
    private Button buttonQueryTemplate;

    @FXML
    private Button buttonForFile;

    @FXML
    private Button buttonCancel;

    @FXML
    private BorderPane boarderPaneSynxronize;
    @FXML
    void initialize() {

        ResultSet rs = null;
        ResultSet temp_11 = null;

        SaveConnection d = SaveConnection.getInstance();
        rs = d.dbWorks[0].Use(d.dbWorks[0].GetNameUse());
        rs = d.dbWorks[0].ShowDesc(d.dbWorks[0].GetNameTable());

        tableSelect.getColumns().clear();

        int b = 0;

        List<String> a1 = new ArrayList<>();
        while (true) {

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

        for (int i = 0; i < a1.size(); i++) {
            int xerr = i;
            TableColumn<ObservableList<String>, String> qq = new TableColumn<ObservableList<String>, String>(a1.get(i));
            qq.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().get(xerr)));
            tableSelect.getColumns().add(qq);
        }


        temp_11 = d.dbWorks[0].SelectFrom(d.dbWorks[0].GetNameTable());

        ObservableList<String> it_2 = FXCollections.observableArrayList();


        String tem = "";
        while (true) {

            try {
                if (!temp_11.next()) break;
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            try {
                tem = tem + temp_11.getString(1);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }


            ObservableList<String> it_3 = FXCollections.observableArrayList();
            List<String> a2 = new ArrayList<>();
            for (int i = 0; i <= b - 1; i++) {
                try {
                    a2.add(temp_11.getString(i + 1));

                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }


            it_3.addAll(a2);
            tableSelect.getItems().add(it_3);


        }

       // table_select.setVisible(true);


        compareWithSelectItem.setOnAction(event -> {
            if(CheckboxCompareTable.isSelected())   {
                System.out.println("lf");

            }
            else
            {
                System.out.println("ytn");
            }


        });
        buttonForFile.setOnAction(event -> {
           // hndlOpenFile();
            textAreaForQuery.setText(hndlOpenFile());

        });
        buttonExucutedQueru.setOnAction(event -> {
            SaveConnection l=SaveConnection.getInstance();
            l.dbWorks[0].ExecuteQuery(textAreaForQuery.getText());
        });




        MultipleSelectionModel<String> langsSelectionModel = listTableCompare.getSelectionModel();
        langsSelectionModel.setSelectionMode(SelectionMode.MULTIPLE);
        ReadNameFile();





        compareWithSelectItem.setOnAction(event -> {
            SaveConnection a=SaveConnection.getInstance();
           // a.dbWorks[0].SetNameUse(table.getSelectionModel().getSelectedItem().getName());
            //a.dbWorks[0].SetNameTable(text_table.getSelectionModel().getSelectedItem());
            try {
                stageMain.setScene(new SceneBuilder().getScene("CompareWindow"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            // anchorpane_compare_with_itams.setVisible(true);
            //anchoPane_seting.setVisible(false);
            //ReadNameFile();

        });



    }
    @FXML
    private String hndlOpenFile() {
        FileChooser fileChooser = new FileChooser();//Класс работы с диалогом выборки и сохранения
        fileChooser.setTitle("Open Document");//Заголовок диалога
        FileChooser.ExtensionFilter extFilter =
                new FileChooser.ExtensionFilter("(*.txt)", "*.txt");//Расширение
        fileChooser.getExtensionFilters().add(extFilter);
        File file = fileChooser.showOpenDialog(stageMain);//Указываем текущую сцену CodeNote.mainStage
        if (file != null) {
            //Open
            System.out.println("Процесс открытия файла");
        }

        String s = "1";
        Scanner in = null;
        try {
            in = new Scanner(new File(file.toString()));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while(in.hasNext())
            s += in.nextLine() + "\r\n";
        in.close();

        return s;
    }

    private void ReadNameFile(){
        File dir=new  File("E://name_DB");
        ObservableList <String> it_2= FXCollections.observableArrayList();
        if(dir.isDirectory()) {

            if (dir.listFiles().length > 0) {
                for (File item : dir.listFiles()) {

                    //FileReader red = null;
                    it_2.add(item.getName());
                    listTableCompare.setItems(it_2);



                }
            }
        }


    }

}

