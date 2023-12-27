package com.lulu.mywebdb.data;
import java.sql.*;
public class DBProvider {

    public DBProvider(){
        try {
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.err.println("驅動程式戴入失敗,請確認MariaDB-Java-Connector 是否有載入");
        }
    }
    public ResultSet getData(String sql){
        Connection con = null;
        Statement stmt =null;
        ResultSet rs = null;
        try {
            con = DriverManager.getConnection("jdbc:mariadb://localhost/classicomels","root","12345");
            stmt = con.createStatement();
            rs = stmt.executeQuery(sql);
            return rs;
        } catch (SQLException e) {
            return null;
        }
    }
}
