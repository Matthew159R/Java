package com.mycompany.projectjava;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import javax.swing.JOptionPane;

public class ProjectJava {

    public static void main(String[] args) {
        
        try {
            String filePath = "C:\\Users\\ALUNO\\Desktop\\Cadastro de usuário em Java\\Banco de dados.txt";
            FileInputStream file = new FileInputStream(filePath);
            FileWriter fileWriter = new FileWriter(filePath, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            int byteValue;
            String text = "";
            
            while((byteValue = file.read()) != -1) {
                char byteValueChar = (char) byteValue;
                text += byteValueChar;
                int countBar = 0;
                
                if (byteValueChar == '|') {
                    countBar++;
                }
                if (countBar == 5) {
                    text += "\n";
                    countBar = 0;
                }
            }
            System.out.println(text);
            file.close();
            int maxNameLength = 15;  
            int maxAgeLength = 3;    
            int maxCpfLength = 11;   
            int maxEmailLength = 25;  
            
            while (true) {
                int cadastro = Integer.parseInt(JOptionPane.showInputDialog("Deseja cadastrar um usuário? (0) para não e (1) para sim"));
                
                if (cadastro == 0) {
                    System.out.println(text);
                    break;
                }
                String name = JOptionPane.showInputDialog("Digite o nome");
                String age = JOptionPane.showInputDialog("Digite a idade");
                String cpf = JOptionPane.showInputDialog("Digite o cpf");
                String email = JOptionPane.showInputDialog("Digite o email");
                
                String alignedName = String.format("%-" + maxNameLength + "s", name);
                String alignedAge = String.format("%-" + maxAgeLength + "s", age);
                String alignedCpf = String.format("%-" + maxCpfLength + "s", cpf);
                String alignedEmail = String.format("%-" + maxEmailLength + "s", email);
                
                String template = "       " + alignedName + alignedName + alignedCpf + alignedEmail + "   \n" + "   |-----------------------------------------------------------------------------|" + "\n";
                text += template;
                bufferedWriter.write(template);
                System.out.println(text);
            }
            
            bufferedWriter.close();
        } catch(IOException e) {
            e.printStackTrace();
            System.out.println("O CAMINHO DO TXT QUE SIMULA O BANCO DE DADOS PODE ESTAR ERRADO");
        }       
    }
}
