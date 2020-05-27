/*
 * Java
 */
package bankomatdemo;
import java.util.*;

/**
 *
 * @author Julia
 */
public class Server implements Person{
    protected String name;
    protected double incomes;
    protected int serverNr;
    
    Calendar today = Calendar.getInstance();
    
    
    public Server(String name, double incomes, int serverNr){
        this.name=name;
        this.incomes=incomes;
        this.serverNr=serverNr;
    }
    
    public void setLan(Kund k, Loan l){
        if(k.hasLan(l)){
            System.out.println( "Server " + name + " har beviljat " +
                k.getName() + l.getInfo());
        }
    }
    
    public void setLanRan(Kund k, Loan l, double r){
        if(k.hasLan(l)){
            l.setRantesats(this, k, r);
        }
    }
    
    public void setKonRan(Kund k, Konton kon, double r){
        if(k.hasKon(kon)){
            kon.setRantesats(this, k, r);
        }
    }
    
    public String getName(){
        return name;
    }

    @Override
    public String getInfo() {
        return "Servers name: " + name + ", number: " + serverNr + ", incomes: " + incomes;
    }
    
}
