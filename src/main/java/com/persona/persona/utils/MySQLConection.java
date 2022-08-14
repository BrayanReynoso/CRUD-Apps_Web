package com.persona.persona.utils;
//BRAYAN REYNOSO MACEDO
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConection {
    public Connection getConnection() {
        final String DBNAME = "persona",
                USERNAME = "root",
                PASSWORD = "root",
                TIMEZONE = "America/Mexico_City",
                USESSL = "false",
                PUBLICKEY = "true";
        String dataSource = String.format("jdbc:mysql://localhost:3306/%s?user=%s" +
                        "&password=%s&serverTimezone=%s&useSSL=%s&allowPublicKeyRetrieval=%s",
                DBNAME, USERNAME, PASSWORD, TIMEZONE, USESSL, PUBLICKEY);
        try {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            return DriverManager.getConnection(dataSource);
        } catch (SQLException e) {
            System.out.println(this.getClass().getCanonicalName() +
                    "->" + e.getMessage());
        }
        return null;
    }

    public static void main(String[] args) {
        Connection conn = new MySQLConection().getConnection();
        if (conn != null) {
            try {
                System.out.println("Conexión realizada con Exito");
                conn.close();
            } catch (SQLException e) {
            }
        } else {
            System.out.println("Conexión fallida");
        }
    }
}
