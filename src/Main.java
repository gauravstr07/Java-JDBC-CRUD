import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //getData();
        //insertData();
        //DeleteData();
        //updateData();
        getRecordWithInput();
    }

    // ---------------------- Create jdbc connection
    public static Connection getConnection() {
        try {
            String driver = "com.mysql.cj.jdbc.Driver";
            String dataBaseUrl = "jdbc:mysql://localhost:3306/codestep";
            String username = "root";
            String password = "Akshu&2680";
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(dataBaseUrl, username, password);
            System.out.println("database connected: ");
            return conn;
        } catch (Exception e) {
            System.out.println("some error - " + e);
        }
        return null;
    }

    // ---------------------- Get Data
    public static void getData() {
        try {
            Statement statement = getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery("Select * from user");

            while (resultSet.next()) {
                System.out.println(resultSet.getString("id"));
                System.out.println(resultSet.getString("name"));
                System.out.println(resultSet.getString("email"));
            }

        } catch (Exception e) {
            System.out.println("error - " + e);
        }
    }

    // ---------------------- Insert Data
    public static void insertData(){
        try {
            Statement statement = getConnection().createStatement();
            int result = statement.executeUpdate("insert into user (id, name, email) values (3, \"Hema\", \"hema07@\")");
            System.out.println(result);
            if(result == 1){
                System.out.println("Data inseted into database!");
            }else {
                System.out.println("some error");
            }

        }catch (Exception e){
            System.out.println("error  - " + e);
        }
    }

    // ---------------------- Delete Data
    public static void DeleteData(){
        try {
            Statement statement = getConnection().createStatement();
            int result = statement.executeUpdate("delete from user where id=2");

            if(result == 1){
                System.out.println("Record deleted");
            }else {
                System.out.println("error while delteding data");
            }

        }catch (Exception e){
            System.out.println("error - " + e);
        }
    }

    // ---------------------- Update data
    public static void updateData(){
        try {
            Statement statement = getConnection().createStatement();
            int result = statement.executeUpdate("update user set email='gauravstr05@gmail.com' where id=1");

            if(result == 1){
                System.out.println("Record updated into database");
            }else {
                System.out.println("Failed to update record");
            }

        }catch (Exception e){
            System.out.println("error - " + e);
        }
    }

    // ---------------------- Java Get record with input from MySQL Database
    public static void getRecordWithInput(){
        try {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter user id to find:- ");
            int id = sc.nextInt();
            Statement statement = getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery("select * from user where id="+ id +" ");

            while (resultSet.next()){
                System.out.println(resultSet.getString("id"));
                System.out.println(resultSet.getString("name"));
                System.out.println(resultSet.getString("email"));
            }

        }catch (Exception e){
            System.out.println("error - " + e);
        }
    }
}
