/*
 * Java
 */
package gymobjdemo;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Julia
 */
public class GymCenter {
    public static List<PersonInfo> readFile(String src){
        Path path = Paths.get(src);
        List<PersonInfo> allpeople = new ArrayList<>();
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
                allpeople.add(new PersonInfo(num, name, regDate));
            }
        }
        catch(IOException exc){
            System.out.println("Error: " + exc);
        }
        return allpeople;
    }
    public static PersonInfo matchKund(String num, List<PersonInfo> allpeople){
        for(PersonInfo p: allpeople){
            if(p.getNum().equals(num.trim()) || p.getName().equalsIgnoreCase(num.trim())){
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
        LocalDateTime today = LocalDateTime.now();
                kunder.add(kund);
                kund.setDateTime(today);
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
            System.out.println("Error01: " + exc);
        }
        try(PrintWriter pw = new PrintWriter(Files.newBufferedWriter(writePath, StandardCharsets.UTF_8,
                                                StandardOpenOption.APPEND))){
            for(KundInfo k: checkPerson){
                pw.print(k.getInfo()+ "\n");
            }
        }
        catch(Exception exc){
            System.out.println("Error02: " + exc);
        }
    }
    public static List<KundInfo> checkFile(String src){
        Path path = Paths.get(src);
        List<KundInfo> allcheck = new ArrayList<>();
        String temp = null;
        String str = null;
        String name = null;
        String num=null;
        String datetime=null;
        try(BufferedReader br = Files.newBufferedReader(path)){
            while((temp=br.readLine()) != null && !temp.trim().equals("")){
                name=temp.substring(0, temp.indexOf(",")).trim();
                str = temp.substring(temp.indexOf(",")+1);
                num=str.substring(0, str.indexOf(",")).trim();
                datetime = str.substring(str.indexOf(",")+1).trim();
                allcheck.add(new KundInfo(name, num, datetime));
            }
        }
        catch(IOException exc){
            System.out.println("Error03: " + exc);
        }
        return allcheck;
    }
    public static void writeListFile(String src, List<KundInfo> kundlist){
        Path writePath = Paths.get(src);
        try{
            if(!Files.exists(writePath, LinkOption.NOFOLLOW_LINKS)){
                Files.createFile(writePath);
            }
        }
        catch(IOException exc){
            System.out.println("Error04: " + exc);
        }
        try(PrintWriter pw = new PrintWriter(Files.newBufferedWriter(writePath, StandardCharsets.UTF_8))){
            for(int i=0; i<kundlist.size(); i++){
                String eachInfo = 
                        kundlist.get(i).getDatetime() + "\n";
                int count = 1;
                for(int j=i+1; j<kundlist.size(); j++){
                    if(kundlist.get(i).getNum().equals(kundlist.get(j).getNum())){
                        eachInfo = eachInfo + 
                                kundlist.get(j).getDatetime() + "\n";
                        kundlist.remove(j);
                        j=j-1;
                        count += 1;
                    }
                }
                pw.print(kundlist.get(i).getMesg() + "\tTotal: " + count + " times.\n");
                pw.print(eachInfo );
            }
        }
        catch(Exception exc){
            System.out.println("Error05: " + exc);
        }
    }
    public static String countimes(List<KundInfo> kundlist){
        String str ="";
        for(int i=0; i<kundlist.size(); i++){
            String eachInfo = 
                    kundlist.get(i).getDatetime() + "\n";
            int count = 1;
            for(int j=i+1; j<kundlist.size(); j++){
                if(kundlist.get(i).getNum().equals(kundlist.get(j).getNum())){
                    eachInfo = eachInfo + 
                            kundlist.get(j).getDatetime() + "\n";
                    kundlist.remove(j);
                    j=j-1;
                    count += 1;
                }
            }
            str = str + count ;
        }
        return str;
    }
           
}
