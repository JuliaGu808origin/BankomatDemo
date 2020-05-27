/*
 * Java
 */
package gymdemo;
import java.util.*;
/**
 *
 * @author Julia
 */
public class CheckInfo {
    private String name;
    private String number;
    private String date;
    
    public CheckInfo(String name, String number, String date){
        this.name=name;
        this.number=number;
        this.date=date;
    }

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }

    
    public String getInfo(){
        return "Name: " + name + "\tNumber: " + number + 
                "\tTotal: ";
    }

   
    public String getDate() {
        return date;
    }
    
}
