/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.fierstprojectjava;

/**
 *
 * @author Matheus Batista
 */
public class FierstProjectJava {

    public static void main(String[] args) {
        System.out.println("Olá mundo!");
        
        String fibonacci = FierstProjectJava.fibonacci(10);
        System.out.println(fibonacci);
        drawSquare(15, 5);
    }
    
    //Aprendizado: Funções não podem ser declaradas dentro de outras funções;
    public static String fibonacci (int qtd) {
            int a = 0;
            int b = 1;
            String fibonacciSequence = "";
            
            for(int i = 0; i < qtd; i++) {
                b = a + b;
                a = b - a;
                fibonacciSequence += Integer.toString(a) + " ";
            }
            
            return fibonacciSequence;
        }
   
    public static void drawSquare(int width, int height) {
        
        String widthPoint = "-";
        String space = " ";
        
        System.out.println("1" + widthPoint.repeat(width) + "1"); 
        
        for(int i = 0; i < height; i++) {
            System.out.println("|" + space.repeat(width) + "|");
        }
        
        System.out.println("1" + widthPoint.repeat(width) + "1"); 

    }
}


