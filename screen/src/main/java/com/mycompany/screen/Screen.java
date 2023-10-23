/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.screen;

/**
 *
 * @author ALUNO
 */
public class Screen {
    static screenLogin screenlogin;
    static SystemScreen systemScreen;
    public static void main(String[] args) {
        System.out.println("Hello World!");
        
        
        screenlogin = new screenLogin();
        screenlogin.setVisible(true);
        systemScreen = new SystemScreen();
        systemScreen.setVisible(false);
            
    }
    public static void returnLogin (boolean result)
    {
   
        screenlogin.setVisible(false);
        systemScreen.setVisible(true);
    }
   

}
