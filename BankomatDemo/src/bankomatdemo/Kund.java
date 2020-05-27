/*
 * Java
 */
package bankomatdemo;
import java.util.*;

/**
 *
 * @author Julia
 */
public class Kund implements Person{
    protected String name;
    protected int kundNr;
    
    List<Konton> kontons = new ArrayList<>();
    List<Loan> loans = new ArrayList<>();
    
    public Kund(String name, int kundNr){
        this.name=name;
        this.kundNr=kundNr;
    }
    
    public String getName(){
        return name;
    }
    
    public void addKon(Konton k){
        kontons.add(k);
    }
    
    public void addLan(Loan l){
        loans.add(l);
    }
    
    public boolean hasKon(Konton k){
        return kontons.contains(k);
    }
    
    public boolean hasLan(Loan l){
        return loans.contains(l);
    }

    @Override
    public String getInfo() {
        return "Kundens name: " + name + ", number: " + kundNr;
    }
    
}
