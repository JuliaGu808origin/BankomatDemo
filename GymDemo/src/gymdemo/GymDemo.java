/*
 * Java
 */

package gymdemo;
import java.awt.Toolkit;
import java.io.*;
import java.nio.file.Files;
import java.util.*;
import javax.swing.*;


public class GymDemo {
    public GymDemo(){
        String readPath = "src\\gymdemo\\customers.txt";            
        String writePath = "src\\gymdemo\\kunders.txt"; 
        String coachPath = "src\\gymdemo\\coach.txt";
//        String writePath = "src\\gymdemo\\oktperday.txt"; 
//        String coachPath = "src\\gymdemo\\oktpermonth.txt";
        List<PersonInfo> allpeople = GymCenter.readFile(readPath);
        List<KundInfo> kunder = new ArrayList<>();
        List<CheckInfo> coach = new ArrayList<>();
        List<CheckInfo> noSameK = new ArrayList<>();
        String num;
        boolean again = true;
        while(again){
            num = JOptionPane.showInputDialog("Your number or Your name ?");
            if(num==null || num.trim().equals("")){
                GymCenter.writeFile(writePath, kunder);
                coach = GymCenter.noSameKund(GymCenter.checkFile(writePath));
                for(CheckInfo c: coach)
                    System.out.println(c.getName() + " " + c.getNumber() + " "+ c.getDate());
                GymCenter.writeListFile(coachPath, coach);
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
                        kunder=GymCenter.checked(kunder, person);
                    }
                }
            }
        }    
    }

    
    public static void main(String[] args) {
        GymDemo gym = new GymDemo();
       
    }

}
