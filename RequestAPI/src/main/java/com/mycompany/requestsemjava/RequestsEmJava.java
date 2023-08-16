/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.requestsemjava;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 *
 * @author salomao pc
 */
public class RequestsEmJava {

    public static void main(String[] args) {
        try {
            // URL da API que você deseja consumir
            URL url = new URL("https://api.github.com/users/Matthew159R");

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            StringBuilder response = new StringBuilder();

            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();

            System.out.println(response.toString());

            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Ocorreu um erro!");
        }
    }
}

