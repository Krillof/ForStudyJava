package my.spring_proj.model;

import my.spring_proj.model.entities.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Type;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MyDB {

    public static String DB_NAME = "formyproj";
    public static String URL = "jdbc:postgresql://localhost:5432/";
    public static String LOGIN = "postgres";
    public static String PASSWORD = "31102002";



    public static Connection connection;

    private static void execute(final String SQL_str){
        Statement statement = null;
        try {
            statement = connection.createStatement();
            statement.execute( SQL_str );
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    public static void onStart() {

        System.out.println("Loading database connection...");

        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            connection = DriverManager.getConnection(URL + DB_NAME, LOGIN, PASSWORD);
        } catch (SQLException t) {
            try {
                connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
                Statement statement = connection.createStatement();
                ResultSet rs =
                        statement.executeQuery(
                                "SELECT 1 FROM pg_database WHERE datname='" + DB_NAME + "'");

                if (!rs.next()){
                    connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);

                    execute("CREATE DATABASE forMyProj WITH OWNER = " + LOGIN + ";");

                    connection = DriverManager.getConnection(URL + DB_NAME, LOGIN, PASSWORD);

                    execute("CREATE TABLE competition (" +
                            " competition_id int,  " +
                            " competition_name varchar," +
                            " world_record int," +
                            " set_date date" +
                            ");");

                    execute("CREATE TABLE result (" +
                            " competition_id int,  " +
                            " sportsman_id  int," +
                            " _result int," +
                            " city varchar," +
                            " hold_date date" +
                            ");");

                    execute("CREATE TABLE sportsman (" +
                            " sportsman_id int,  " +
                            " sportsman_name varchar," +
                            " _rank int," +
                            " year_of_birth int," +
                            " personal_record int," +
                            " country varchar" +
                            ");");

                    //---------------------------------------------------------------------------------------------
                    execute("INSERT INTO sportsman VALUES " +
                            "(1, 'Aaron', 1, 1960, 25, 'German');");

                    execute("INSERT INTO sportsman VALUES " +
                            "(2, 'John', 2, 1955, 40, 'USA');");

                    execute("INSERT INTO sportsman VALUES " +
                            "(3, 'Ivan', 3, 1957, 30, 'Russia');");

                    execute("INSERT INTO sportsman VALUES " +
                            "(4, 'Katya', 3, 1958, 17, 'Russia');");

                    execute("INSERT INTO sportsman VALUES " +
                            "(5, 'Albert', 3, 1959, 20, 'German');");

                    //---------------------------------------------------------------------------------------------
                    execute("INSERT INTO competition VALUES " +
                            "(1, 'New World Championship I', 30, DATE '1980-10-7');");

                    execute("INSERT INTO competition VALUES " +
                            "(2, 'New World Championship II', 40, DATE '1982-10-5');");

                    execute("INSERT INTO competition VALUES " +
                            "(3, 'New World Championship III', 29, DATE '1984-10-5');");

                    execute("INSERT INTO competition VALUES " +
                            "(4, 'New World Championship IV', 29, DATE '1986-10-5');");

                    //---------------------------------------------------------------------------------------------
                    execute("INSERT INTO result VALUES " +
                            "(1, 1, 25, 'Moscow', DATE '1980-10-5');");

                    execute("INSERT INTO result VALUES " +
                            "(1, 3, 30, 'Moscow', DATE '1980-10-7');");

                    execute("INSERT INTO result VALUES " +
                            "(1, 4, 15, 'Moscow', DATE '1980-10-8');");



                    execute("INSERT INTO result VALUES " +
                            "(2, 1, 19, 'Berlin', DATE '1982-10-6');");

                    execute("INSERT INTO result VALUES " +
                            "(2, 2, 40, 'Berlin', DATE '1982-10-5');");

                    execute("INSERT INTO result VALUES " +
                            "(2, 4, 17, 'Berlin', DATE '1982-10-8');");

                    execute("INSERT INTO result VALUES " +
                            "(2, 5, 20, 'Berlin', DATE '1982-10-9');");




                    execute("INSERT INTO result VALUES " +
                            "(3, 1, 22, 'Madrid', DATE '1984-10-7');");

                    execute("INSERT INTO result VALUES " +
                            "(3, 2, 29, 'Madrid', DATE '1984-10-5');");

                    execute("INSERT INTO result VALUES " +
                            "(3, 3, 28, 'Madrid', DATE '1984-10-6');");




                    execute("INSERT INTO result VALUES " +
                            "(4, 1, 24, 'Moscow', DATE '1986-10-5');");

                    execute("INSERT INTO result VALUES " +
                            "(4, 3, 29, 'Moscow', DATE '1986-10-7');");

                    execute("INSERT INTO result VALUES " +
                            "(4, 4, 14, 'Moscow', DATE '1986-10-8');");


                    System.out.println("Database was created!");
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        }

        System.out.println("Database loaded.");
    }

    public static <T extends Entity> List<Entity> query(String SQL_str, Class<T> cls){
        Statement statement = null;
        try {
            statement = connection.createStatement();
            ResultSet res = statement.executeQuery(SQL_str);

            List<Entity> answer = new ArrayList<>();
            while (res.next()){
                Entity entity = cls.getDeclaredConstructor().newInstance();
                entity.queryPackUp(res);
                answer.add(entity);
            }
            return answer;
        } catch (SQLException throwables) {
            System.out.println("Error: " + throwables.getMessage());
            throwables.printStackTrace();
        } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
        }

        return new ArrayList<Entity>();
    }

    public static List<Entity> getAllCompetitions(){
        return query("SELECT * FROM competition;", Competition.class);
    }

    public static List<Entity> getAllResults(){
        return query("SELECT * FROM result;", Result.class);
    }

    public static List<Entity> getAllSportsmans(){
        return query("SELECT * FROM sportsman;", Sportsman.class);
    }

}
