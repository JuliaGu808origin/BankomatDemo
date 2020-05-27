/*
 * Java
 */
package bankomatdemo;

/**
 *
 * @author Julia
 */
public class Loan {
    protected double rantesats;
    protected double belopp;
    protected String history = "";
    
    public Loan(double rantesats, double belopp){
        this.rantesats=rantesats;
        this.belopp=belopp;
    }
    
    public void setRantesats(Server s, Kund k, double r){
        rantesats = r;
        history = history + s.getName()+" beviljade " + k.getName() + 
                "s lån ränteändringen till " + rantesats + "\n";
    }
    
    public String getHistory(){
        return history;
    }
    
    public String getInfo(){
        return "s lån( räntesats: " + rantesats + ", belopp: " + belopp + " )";
    }
    
}
