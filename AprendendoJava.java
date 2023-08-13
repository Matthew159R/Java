/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.aprendendojava;

/**
 *
 * @author salomao pc
 */
public class AprendendoJava {

    public static void main(String[] args) {
        System.out.println("Usando o barra n \n para imrprir uma mensagem só em duas linhas");
        
       // Casting, transformando valores numéricos;
       double a = 3.14;
       int x = (int) a;
       System.out.println(x);
       
       // outerLoop e innerLoop para referenciar loops com rótulo
       outerLoop:
       for(int i = 0; i < 10; i++) {           
           innerLoop:
           for(int j = 0; j < 5; j++) {
                System.out.println("i: "+ i);
                System.out.println("j: "+ j);
                
                if (j == 3) {
                    System.out.println("Encerramento do outerLoop;");
                    break outerLoop;
                }
            }
       }
       
       //Exercício fatorial;
       int number = 5;
       int fatorial = 1;
       for(int i = number; i > 0; i--) {
           fatorial = fatorial * i;
           
       }
       System.out.println(fatorial);
       
       for(int i = 1; i < 5; i++) 
            {
            String template = "";
             for(int j = 1; j <= i; j++) 
                {
                  template += Integer.toString(i * j) + " ";
                       
                }
             System.out.println(template);
            }
       // Sequência fibonacci;
       
      int u = 0;
      int l = 1;
      while (l < 20) {
        l = l + u;
        u = l - u;
        System.out.println(u);
      }
      
      // Orientação a objetos;
      
      class Account {
          int number;
          String name;
          double balance;
          double limit;
          
          void withdraw (double amount) {
              double newBalance = this.balance - amount;
              this.balance = newBalance;
          }
          
          void deposit (double amount) {
              this.balance += amount;
          }
          
          void transfer (Account nameAccount, double value) {
              this.balance = this.balance - value;
              nameAccount.balance = nameAccount.balance + value;
          }
      }
      
     Account myAccount;
     Account luckAccount;
     
     myAccount = new Account();
     luckAccount = new Account();
     
     myAccount.number = 123;
     myAccount.name = "Matheus";
     myAccount.balance = 8000.0;
     
     luckAccount.number = 321;
     luckAccount.name = "Luck";
     luckAccount.balance = 7000;
     
     myAccount.withdraw(500);
     myAccount.deposit(1000);
     System.out.println(myAccount.balance);
     
     myAccount.transfer(luckAccount, 500);
     System.out.println(myAccount.balance);
     System.out.println(luckAccount.balance);
     
     
     // Exercício do funcionário;
     
     class Funcionario {
        String nome;
        String departamento;
        double salario;
        String data;
        String RG;
        
        void recebeAumento (double aumento) {
            this.salario += aumento;
        } 
        
        double calculaGanhoAnual () {
            return this.salario * 12;
        }
        
        // Usei if, pois não sei utilizar propery name ainda;
        void mostrar (String propery) {
            if (propery == "nome") {
                System.out.println(this.nome);
            }else if (propery == "departamento") {
                System.out.println(this.departamento);
            }else if (propery == "salario") {
                System.out.println(this.salario);
            }else if (propery == "data") {
                System.out.println(this.data);
            }else if (propery == "RG") {
                System.out.println(this.RG);
            }else if (propery == "tudo") {
                System.out.println("Nome: "+ this.nome);
                System.out.println("Departamento: "+ this.departamento);          
                System.out.println("Salário: "+ this.salario);
                System.out.println("Data: "+ this.data);
                System.out.println("RG: "+ this.RG);                
            }
        }
     }
     
     class Empresa {
         String nome;
         String cnpj;
         Funcionario[] empregados;
         
         // @Override indica que estamos modificando um método da classe pai na classe filha;
         @Override
         public String toString() {
             StringBuilder stringBuilder = new StringBuilder();
             
            for(int i = 0; i < this.empregados.length; i++) {
                if (this.empregados[i] != null) {
                    stringBuilder.append(
                            "Nome: " + this.empregados[i].nome +
                            "Departamento: " + this.empregados[i].departamento + "\n" + 
                            "Salario: " + this.empregados[i].salario + "\n" +
                            "Data: " + this.empregados[i].data + "\n" +
                            "RG: " + this.empregados[i].RG).append("\n");
                }
            }
             return stringBuilder.toString();
         }
         
         void adciona(Funcionario f) {
             for(int i = 0; i < this.empregados.length; i++) {
                 if(this.empregados[i] == null) {
                     this.empregados[i] = f;
                     break;
                 }
             }
         }
     }
     
     
     Funcionario lucas = new Funcionario();
     lucas.nome = "Lucas";
     lucas.departamento = "Lorem ipsum";
     lucas.salario = 3000;
     lucas.data = "12/12/2022";
     lucas.RG = "464847894";
     
     lucas.recebeAumento(500);
     lucas.calculaGanhoAnual();
     
     //lucas.mostrar("tudo");
     
     Empresa empresa = new Empresa();
     empresa.nome = "Proz";
     empresa.cnpj = "123";
     empresa.empregados = new Funcionario[2];
     empresa.adciona(lucas);
     
     System.out.println(empresa.toString() + " aqui");
     
     /*
     for(int i = 0; i < empresa.empregados.length; i++) {
         if (empresa.empregados != null) {
             System.out.println(empresa.empregados[i] + " Aqui");
         }
     }
     
     */
     // Testando arrays;
     
     Account[] accounts;
     accounts = new Account[3];
     
     accounts[0] = new Account();
     accounts[0].name = "Nick";
     accounts[0].balance = 3000.0;
     
     accounts[1] = new Account();
     accounts[1].name = "Mark";
     accounts[1].balance = 4000.0;
     
     accounts[2] = new Account();
     accounts[2].name = "Luck";
     accounts[2].balance = 8000.0;
     
     
    }
    
 
       
}
    

