/*
 * Java
 */

package gymobjdemo;

import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import java.io.*;


public class GymObjDemo {
    public GymObjDemo(){
        String readPath = "src\\gymobjdemo\\customers.txt";            
        String writePath = "src\\gymobjdemo\\checkin.txt"; 
        String friquentPath = "src\\gymobjdemo\\friquent.txt";
//        String writePath = "src\\gymobjdemo\\testPath1.txt"; 
//        String friquentPath = "src\\gymobjdemo\\testPath2.txt";
        List<PersonInfo> allpeople = GymCenter.readFile(readPath);
        List<KundInfo> kunder = new ArrayList<>();
        String num;
        boolean again = true;
        while(again){
            num = JOptionPane.showInputDialog("Your number or Your name ?");
            if(num==null || num.trim().equals("")){
                GymCenter.writeFile(writePath, kunder);
                GymCenter.writeListFile(friquentPath, GymCenter.checkFile(writePath));
                System.exit(0);
            }    
            if(GymCenter.matchKund(num, allpeople) == null){
                Toolkit.getDefaultToolkit().beep();
                JOptionPane.showMessageDialog(null, "Unregisted !!!\nJoin us now???");
            }
            else{
                PersonInfo person = GymCenter.matchKund(num, allpeople);
                if(GymCenter.matchDate(person) == null){
                    Toolkit.getDefaultToolkit().beep();
                    JOptionPane.showMessageDialog(null, "Oj! Out of date!!!\nContinue your training now???\n" 
                                                + person.getInfo());
                }
                else{
                    JOptionPane.showMessageDialog(null, "Hej, dear customer!\n" + person.getInfo());
                    int knapp = JOptionPane.showConfirmDialog(null, "Check in!");
                    if(knapp==0){
                        JOptionPane.showMessageDialog(null, "Welcome!");
                        kunder=GymCenter.checked(kunder, person);
                    }
                }
            }
        }    
    }

    
    public static void main(String[] args){
       GymObjDemo gym = new GymObjDemo();
    }

}
