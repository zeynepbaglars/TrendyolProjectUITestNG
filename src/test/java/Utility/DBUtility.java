package Utility;

import java.sql.*;
import java.util.ArrayList;
public class DBUtility {

    public static Connection connection;
    public static Statement statement;


    public static ArrayList<ArrayList<String>> getListData(String sql) {
        DBConnectionOpen();
        ArrayList<ArrayList<String>> table = new ArrayList<>();

        try {
            ResultSet rs = statement.executeQuery(sql);

            while (rs.next()) {

                ArrayList<String> row = new ArrayList<>();
                for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
                    row.add(rs.getString(i));
                }
                table.add(row);
            }
        } catch (Exception e) {
            System.out.println("e.getMessage() = " + e.getMessage());
        }
        DBConnectionClose();

        return table;
    }

    public static void DBConnectionOpen() {
        String hostUrl = "jdbc:mysql://db-technostudy.ckr1jisflxpv.us-east-1.rds.amazonaws.com:3306/sakila";
        String username = "root";
        String password = "'\"-LhCB'.%k[4S]z";

        try {
            connection = DriverManager.getConnection(hostUrl, username, password);
            statement = connection.createStatement();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void DBConnectionClose() {
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
