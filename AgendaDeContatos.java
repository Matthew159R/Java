/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.agendadecontatos;
import java.util.ArrayList;
import javax.swing.JOptionPane;

class Contact {
    private String name;
    private String telephone;
    
    Contact (String name, String telephone) {
        this.name = name;
        this.telephone = telephone;
    }
    
    public String getName() {
        return name;
    }
    
    public String getTelephone() {
        return telephone;
    }
    
    public String returnNameAndTelephone () {
        return name + " " + telephone;
    }
}

class Schedule {
    ArrayList<Contact> contactList = new ArrayList();
    
    public void addContact (Contact name) {
        contactList.add(name);
    }
    
    public String showContacts () {
        String contacts = "";
        for(Contact contact : contactList) {
            contacts += contact.returnNameAndTelephone() + "\n";
         }
        return contacts;
    }
    
    public String showSpecificContact(String nameContactOrTelephone) {
        for (Contact contact : contactList) {
            boolean conditionName = contact.getName().toUpperCase().equals(nameContactOrTelephone.toUpperCase());
            boolean conditionTelephone = contact.getTelephone().equals(nameContactOrTelephone);
            
            if (conditionName || conditionTelephone) {
               return contact.returnNameAndTelephone();
            }
        }
        return null;
    }
    
    public void removeContact(String nameContactOrTelephone) {
        ArrayList contactsToRemove = new ArrayList();
        for(Contact contact : contactList) {
            boolean conditionName = contact.getName().toUpperCase().equals(nameContactOrTelephone.toUpperCase());
            boolean conditionTelephone = contact.getTelephone().equals(nameContactOrTelephone);
            
            if (conditionName || conditionTelephone) {
                contactsToRemove.add(contact);
            }
        }   
        contactList.removeAll(contactsToRemove);
    }
}

public class AgendaDeContatos {

    public static void main(String[] args) {
        JOptionPane.showMessageDialog(null, "+----------------------------------------------------------------+" + "\n" + "Abaixo adcione, remova e consulte seus contatos" + "\n" + "+----------------------------------------------------------------+");
        Schedule schedule = new Schedule();
        
        while(true) {
            String input = JOptionPane.showInputDialog("(0) Para adcionar (1) Para remover (2) Para pesquisar contato específico (3) Para mostrar todos os contatos (4) Para encerrar o programa");
           
                if (input != null && input.equals("0")) {
                    String contactName = JOptionPane.showInputDialog("Digite o nome do contato");
                    String contactTelephone = JOptionPane.showInputDialog("Digite o número do contato");
                    
                    Contact contact = new Contact(contactName.trim(), contactTelephone.trim());
                    schedule.addContact(contact);
                    JOptionPane.showMessageDialog(null, contactName + " foi adcionado à sua lista de contatos");
                
                }else if (input != null && input.equals("1")) {
                    String contactNameToDelete = JOptionPane.showInputDialog("Digite o nome do contato que deseja deletar");
                    String search = schedule.showSpecificContact(contactNameToDelete.trim());
                    
                    if (search != null) {
                        String certainty = JOptionPane.showInputDialog("Você tem certeza que deseja deletar " + contactNameToDelete + "S/N");
                        
                        if (certainty.equals("S") || certainty.equals("s")) {
                            schedule.removeContact(contactNameToDelete);
                        }else {
                            JOptionPane.showMessageDialog(null, "Seu contato NÃO foi deletado");
                        }
                    }else {
                        JOptionPane.showMessageDialog(null, "Contato não encontrado");
                    }
                }else if (input != null && input.equals("2")) {
                
                    String contactNameToSearch = JOptionPane.showInputDialog("Digite o nome ou o número do contato que deseja pesquisar");
                    String contactFound = schedule.showSpecificContact(contactNameToSearch);
                    
                    if (contactFound != null) {
                        JOptionPane.showMessageDialog(null, contactFound);
                    }else {
                        JOptionPane.showMessageDialog(null, "Contato não encontrado");
                    }
                }else if (input != null && input.equals("3")) {
         
                    String contactsFound = schedule.showContacts();
                    JOptionPane.showMessageDialog(null, contactsFound);    
                }else if (input != null && input.equals("4")) {
                    break;
                }
            } 
        }
        
        
       /*
       Contact contact1 = new Contact("Mark", "31 9 9999-9999"); 
       Contact contact2 = new Contact("Luck", "31 9 8888-8888");
       Contact contact3 = new Contact("Nick", "31 9 7777-7777");
       Schedule schedule = new Schedule();     
       schedule.addContact(contact1);
       schedule.addContact(contact2);
       schedule.addContact(contact3);
       System.out.println(schedule.showSpecificContact("Nick"));
       schedule.removeContact("nick");
       System.out.println(schedule.showSpecificContact("Nick"));
*/
       
 
      
    }

