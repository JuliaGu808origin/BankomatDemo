/*
 * Java
 */
package gymdemo;

import java.time.LocalDate;

/**
 *
 * @author Julia
 */
public class PersonInfo {
    protected String number;
    protected String name;
    protected LocalDate regDate;
    
    public PersonInfo(String number, String name, LocalDate regDate){
        this.number=number;
        this.name=name;
        this.regDate=regDate;
    }
    public String getNum(){
        return number;
    }
    public String getName(){
        return name;
    }
    public LocalDate getDate(){
        return regDate;
    }
    public String getInfo(){
        return "Number: " + number + "\nName: " + name + "\nRegister date: " + regDate;
    }
}
