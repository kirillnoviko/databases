package sample;

import java.lang.reflect.InvocationTargetException;
import java.sql.*;

public class DB_Work {
    String localhost;
    String port;
    String name;
    String password;
    Connection connection= null;
    Statement PR= null;
    String nameUseDB;
    String nameTable;
   ResultSet rs= null;
    public DB_Work(){

    }
    public void SetNameUse(String name)
    {
        this.nameUseDB=name;
    }

    public void SetNameTable(String name) {
        this.nameTable = name;
    }

    public String GetNameUse()
    {
        return  this.nameUseDB;
    }

    public String GetNameTable() {
        return this.nameTable;
    }

    public DB_Work(String localhost, String port, String name, String password) {
        this.localhost=localhost;
        this.port=port;
        this.name=name;
        this.password=password;

        String url ="jdbc:mysql://" + localhost + ":" + port +"/?allowPublicKeyRetrieval=true&serverTimezone=Europe/Moscow&useSSL=false";
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

        try {
            connection = DriverManager.getConnection(url,this.name,this.password);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        try {
            PR=connection.createStatement();

        } catch (SQLException throwables) {
            throwables.printStackTrace();

        }
        try {
            PR.execute("set names cp1251;");

        } catch (SQLException throwables) {
            throwables.printStackTrace();

        }

    }
    public ResultSet GetResultSet()
    {
        return this.rs;
    }
    public boolean ExecuteQuery(String query){

        try {
            PR=connection.createStatement();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }
        try {
           PR.executeUpdate(query);
           return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }


    }
    public ResultSet Use(String name_DB)
    {
        try {
            PR=connection.createStatement();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            rs=PR.executeQuery("use "+name_DB +" ;");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return rs;
    }
    public ResultSet ShowTables(){

        try {
            PR=connection.createStatement();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {

            rs=PR.executeQuery("show tables;");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return rs;
    }
    public ResultSet ShowDesc(String name_table){

        try {
            PR=connection.createStatement();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {

            rs=PR.executeQuery("desc "+name_table+" ;");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return rs;
    }

    public ResultSet ShowDatabases(){
        try {
            PR=connection.createStatement();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        try {
            rs=PR.executeQuery("Show Databases");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return rs;
    }


    public ResultSet SelectFrom(String name1){

        try {
            PR=connection.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            rs=PR.executeQuery(" select * from " + name1+" ; ");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return rs;
    }
    public int InsertDate(String a,String b,String c,String d){
       int i=0;
        try {
            PR=connection.createStatement();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {//INSERT INTO `users`.`user` (`name`, `password`, `codeword`, `personalNum`) VALUES ('hj', 'nm', 'jnm', 'hj');
          i=  PR.executeUpdate(" Insert into user (`name`, `password`, `codeword`, `personalNum`) values (  '" + a + "' , '" + b + "' , '" +c+"' , '"+d +"' ) ; ");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return i;

    }
    public ResultSet SelectFromWhereCodeWord(String persNum,String name,String codeWord){

        try {
            PR=connection.createStatement();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            rs=PR.executeQuery(" SELECT name FROM  user WHERE personalNum = '" + persNum+ "' AND  name = '"+name + "'  AND codeword =  '"+codeWord+"' ;");

            //d+" ' ; ");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return rs;
    }
    public ResultSet SelectFromWhereID(String persNum,String name,String password){

        try {
            PR=connection.createStatement();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            rs=PR.executeQuery(" SELECT name FROM  user WHERE personalNum =  '" + persNum+ "'   AND  name = '"+name + "'  AND password =  '"+password+"'  ;");

                    //d+" ' ; ");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return rs;
    }



}
