/*
 * Java
 */
package gymdemo;

import java.time.LocalDate;
import java.util.*;

/**
 *
 * @author Julia
 */
public class KundInfo extends PersonInfo{
    
    protected LocalDate checkDate;
    
    public KundInfo(String number, String name, LocalDate regDate) {
        super(number, name, regDate);
    }
    
    public void setDate(LocalDate checkDate){
        this.checkDate=checkDate;
    }
    public String getNum(){
        return number;
    }
    public LocalDate getDate(){
        return checkDate;
    }
    @Override
    public String getInfo(){
        return super.name + " , " + number + " , " + checkDate;
    }
    
}
