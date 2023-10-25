/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.testespring;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
/**
 *
 * @author salomao pc
 */
public class ConnectionToDatabase {
    
    static ArrayList ids = new ArrayList();
    static ArrayList nomes = new ArrayList();
    static ArrayList emails = new ArrayList();
    
    public static void ConnectionRun()
    {
        String jdbcUrl = "jdbc:mysql://localhost:3306/users";
        String username = "root";
        String password = "159159";

        try {
            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);

            Statement statement = connection.createStatement();

            String sqlQuery = "SELECT * FROM users";
            ResultSet resultSet = statement.executeQuery(sqlQuery);

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nome = resultSet.getString("nome");
                String email = resultSet.getString("email");
                
                ids.add(id);
                nomes.add(nome);
                emails.add(email);
            }

            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static String returnValues() {
    StringBuilder jsonResult = new StringBuilder("[");
    
    for (int i = 0; i < ids.size(); i++) {
        jsonResult.append("{");
        jsonResult.append("\"id\":").append(ids.get(i)).append(",");
        jsonResult.append("\"nome\":\"").append(nomes.get(i)).append("\",");
        jsonResult.append("\"email\":\"").append(emails.get(i)).append("\"");
        jsonResult.append("}");
        
        if (i < ids.size() - 1) {
            jsonResult.append(",");
        }
    }
    
    jsonResult.append("]");
    System.out.println(jsonResult);
    return jsonResult.toString();
    }
}
