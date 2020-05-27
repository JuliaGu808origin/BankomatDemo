/*
 * Java
 */
package bankomatdemo;

/**
 *
 * @author Julia
 */
public class Konton {
    protected double rantesats;
    protected double saldo;
    protected String history = "";
    
    public Konton(double rantesats, double saldo){
        this.rantesats=rantesats;
        this.saldo=saldo;
    }
    
    public void setRantesats(Server s, Kund k, double r){
        rantesats = r;
        history = history + s.getName()+" beviljade " + k.getName() + 
                "s konton ränteändringen till " + rantesats + "\n";
    }
    
    public String getHistory(){
        return history;
    }
    
    public String getInfo(){
        return "s konton( räntesats: " + rantesats + ", saldo: " + saldo + " )";
    }
    
}
