package sample;

import java.sql.ResultSet;
import java.sql.SQLException;

public class User {
    String login;
    String password;
    String personalNum;
    String codeWord;

    public User (String a,String b,String c,String d,String h){

        if(b.equals(c)){
            login=a;
            password=b;
            personalNum=d;
            codeWord=h;
        }
        else{
            codeWord="-1";
        }
    }
    public String UserSearchCodeWord (){

        String name="нет такого пользователя";
        DB_Work temp=new DB_Work("localhost","3306","root","12345");
        temp.Use("Users");
        //if(personalNum!=null && password!=null && )
        ResultSet t= temp.SelectFromWhereCodeWord(personalNum,login,codeWord);
        try {
            t.next();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        try {
            name=t.getString("name");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return name;
        }

        return name;
    }
    public boolean UserPasswordUpdate(){
        DB_Work temp=new DB_Work("localhost","3306","root","12345");
        temp.Use("Users");



        return  temp.ExecuteQuery("UPDATE user  SET password = '"+ password+ "' WHERE  personalNum = '" +personalNum+ "' ;");
    }
    public String UserSearch (){
        String name="нет такого пользователя";
        DB_Work temp=new DB_Work("localhost","3306","root","12345");
        temp.Use("Users");
        //if(personalNum!=null && password!=null && )
            ResultSet t= temp.SelectFromWhereID(personalNum,login,password);
        try {
            t.next();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        try {
            name=t.getString("name");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return name;
    }
    public int InputUserDB(){

        DB_Work a=new DB_Work("localhost","3306","root","12345");
        a.Use("Users");
        return a.InsertDate(login,password,personalNum,codeWord);

    }

}

