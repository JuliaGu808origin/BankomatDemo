/*
 * Java
 */
package gymdemo;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.LinkOption;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.util.*;
import javax.swing.*;

/**
 *
 * @author Julia
 */
public class GymCenter {
    
    public static List<PersonInfo> readFile(String src){
        Path path = Paths.get(src);
        List<PersonInfo> people = new ArrayList<>();
        String temp = null;
        String num=null;
        String name=null;
        LocalDate regDate=null;
        try(BufferedReader br = Files.newBufferedReader(path)){
            while((temp=br.readLine()) != null && !temp.trim().equals("")){
                num=temp.substring(0, temp.indexOf(",")).trim();
                name=temp.substring(temp.indexOf(",")+1).trim();
                if((temp=br.readLine()).trim() != ""){
                    regDate=LocalDate.parse(temp.trim());
                }
                people.add(new PersonInfo(num, name, regDate));
            }
        }
        catch(IOException exc){
            System.out.println("Error: " + exc);
        }
        return people;
    }
    public static PersonInfo matchKund(String num, List<PersonInfo> allpeople){
        for(PersonInfo p: allpeople){
            if(p.getNum().equals(num.trim()) || p.getName().equals(num.trim())){
                return p;
            }
        }
        return null;
    }
    public static PersonInfo matchDate(PersonInfo kund){
        int year = LocalDate.now().getYear() -1;
        int month = LocalDate.now().getMonthValue();
        int day = LocalDate.now().getDayOfMonth();
        LocalDate oneyear = LocalDate.of(year, month, day); 
        if(oneyear.isBefore(kund.getDate())){
            return kund;
        } 
        else{
            return null;
        }
    }
    public static List<KundInfo> checked(List<KundInfo> kunder, PersonInfo person){
        KundInfo kund = new KundInfo(person.getNum(), person.getName(), person.getDate());
        LocalDate today = LocalDate.now();
                kunder.add(kund);
                kund.setDate(today);
        return kunder;
    }
    public static void writeFile(String src, List<KundInfo> checkPerson){
        Path writePath = Paths.get(src);
        try{
            if(!Files.exists(writePath, LinkOption.NOFOLLOW_LINKS)){
                Files.createFile(writePath);
            }
        }
        catch(IOException exc){
            System.out.println("Error: " + exc);
        }
        try(PrintWriter pw = new PrintWriter(Files.newBufferedWriter(writePath, StandardCharsets.UTF_8,
                                                StandardOpenOption.APPEND))){
            for(KundInfo k: checkPerson){
                pw.print(k.getInfo()+ "\n");
            }
        }
        catch(Exception exc){
            System.out.println("Error: " + exc);
        }
    }
    public static List<CheckInfo> checkFile(String src){
        Path path = Paths.get(src);
        List<CheckInfo> trainees = new ArrayList<>();
        String temp = null;
        String str = null;
        String name = null;
        String num=null;
        String date=null;
        try(BufferedReader br = Files.newBufferedReader(path)){
            while((temp=br.readLine()) != null && !temp.trim().equals("")){
                name=temp.substring(0, temp.indexOf(",")).trim();
                str = temp.substring(temp.indexOf(",")+1);
                num=str.substring(0, str.indexOf(",")).trim();
                date = str.substring(str.indexOf(",")+1).trim();
                trainees.add(new CheckInfo(name, num, date));
            }
        }
        catch(IOException exc){
            System.out.println("Error: " + exc);
        }
        return trainees;
    }
    public static List<CheckInfo> noSameKund(List<CheckInfo> sameKund){
        for(int i=0; i<sameKund.size()-1; i++){
            for(int j=i+1; j<sameKund.size(); j++){
                if(sameKund.get(i).getNumber().equals(sameKund.get(j).getNumber()) &&
                       sameKund.get(i).getDate().equals(sameKund.get(j).getDate()) ){
                    sameKund.remove(j); 
                    j=j-1;
                }
            }
        }
        return sameKund;
    }
    public static void writeListFile(String src, List<CheckInfo> list){
        Path writePath = Paths.get(src);
        try{
            if(!Files.exists(writePath, LinkOption.NOFOLLOW_LINKS)){
                Files.createFile(writePath);
            }
        }
        catch(IOException exc){
            System.out.println("Error: " + exc);
        }
        try(PrintWriter pw = new PrintWriter(Files.newBufferedWriter(writePath, StandardCharsets.UTF_8))){
            for(int i=0; i<list.size(); i++){
                int count = 1;
                for(int j=i+1; j<list.size(); j++){
                    if(list.get(i).getNumber().equals(list.get(j).getNumber())){
                        list.remove(j);
                        j=j-1;
                        count += 1;
                    }
                }
                pw.print(list.get(i).getInfo() + count + " times.\n");
            }
        }
        catch(Exception exc){
            System.out.println("Error: " + exc);
        }
    }
}
