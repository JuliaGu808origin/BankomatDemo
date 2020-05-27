/*
 * Java
 */

package bankomatdemo;


public class BankomatDemo {
    public BankomatDemo(){
        Kund kund1 = new Kund("Mary", 9001);
        Kund kund2 = new Kund("Tom", 9002);

        
        Server server1 = new Server("Peter", 30000, 2001);
        Server server2 = new Server("Rose", 28000, 2002);
        
        Loan loan1 = new Loan(0.25, 5000);
        Loan loan2 = new Loan(0.27, 5500);
        Loan loan3 = new Loan(0.31, 6700);
        Loan loan4 = new Loan(0.29, 5900);
        
        Konton konton1 = new Konton(0.11, 10000);
        Konton konton2 = new Konton(0.15, 20000);
        Konton konton3 = new Konton(0.09, 9000);
        Konton konton4 = new Konton(0.12, 15000);
        
        kund1.addLan(loan1);
        kund1.addLan(loan2);
        kund2.addLan(loan3);
        kund2.addLan(loan4);
        
        kund1.addKon(konton1);
        kund1.addKon(konton2);
        kund2.addKon(konton3);
        kund2.addKon(konton4);
        
        server1.setLan(kund1, loan1);
        server2.setLan(kund1, loan2);
        server1.setLan(kund2, loan3);
        server2.setLan(kund2, loan4);
        System.out.println("-----------------------------");
        
        server1.setLanRan(kund1, loan1, 0.22);
        server2.setLanRan(kund1, loan1, 0.23);
        server1.setLanRan(kund1, loan2, 0.24);
        server2.setLanRan(kund1, loan2, 0.25);
        server1.setLanRan(kund2, loan3, 0.22);
        server2.setLanRan(kund2, loan3, 0.23);
        server1.setLanRan(kund2, loan4, 0.24);
        server2.setLanRan(kund2, loan4, 0.25);
        
        server1.setKonRan(kund1, konton1, 0.11);
        server2.setKonRan(kund1, konton1, 0.12);
        server1.setKonRan(kund1, konton2, 0.13);
        server2.setKonRan(kund1, konton2, 0.14);
        server1.setKonRan(kund2, konton3, 0.11);
        server2.setKonRan(kund2, konton3, 0.12);
        server1.setKonRan(kund2, konton4, 0.13);
        server2.setKonRan(kund2, konton4, 0.14);
        
        System.out.println(loan1.getHistory());
        System.out.println(loan2.getHistory());
        System.out.println(loan3.getHistory());
        System.out.println(loan4.getHistory());
        System.out.println("----------------------------------");
        System.out.println(konton1.getHistory());
        System.out.println(konton2.getHistory());
        System.out.println(konton3.getHistory());
        System.out.println(konton4.getHistory());
    }

    
    public static void main(String[] args) {
        BankomatDemo bank = new BankomatDemo();
       
    }

}
