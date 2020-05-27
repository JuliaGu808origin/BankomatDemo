/*
 * Java
 */
package gymdemo;
import java.time.LocalDate;
import java.time.Month;
import org.junit.Test;
import junit.framework.TestCase; 
import java.util.*;
/**
 *
 * @author Julia
 */
public class GymCenterTest {
    LocalDate testDay1 = LocalDate.of(2017, Month.OCTOBER, 15);
    LocalDate testDay2 = LocalDate.of(2017, Month.OCTOBER, 16);
    LocalDate testDay3 = LocalDate.of(2017, Month.OCTOBER, 17);
    LocalDate testDay4 = LocalDate.of(2017, Month.OCTOBER, 18);
    PersonInfo testP1 = new PersonInfo("1001", "Emma", testDay1);
    PersonInfo testP2 = new PersonInfo("1002", "Jack", testDay2);
    PersonInfo testP3 = new PersonInfo("1003", "Rose", testDay3);
    PersonInfo testP4 = new PersonInfo("1004", "Tom", testDay4);
    List<PersonInfo> allP = new ArrayList<>();
    CheckInfo testP5 = new CheckInfo("Peter", "1005", testDay4.toString());
    CheckInfo testP6 = new CheckInfo("Peter", "1005", testDay3.toString());
    List<CheckInfo> sameP = new ArrayList<>();
    
    @Test
    public void GymCenterTest(){
        allP.add(testP1);
        allP.add(testP2);
        allP.add(testP3);
        allP.add(testP4);
        sameP.add(testP5);
        sameP.add(testP6);
        TestCase.assertTrue(GymCenter.matchDate(testP1)==null);
        TestCase.assertTrue(GymCenter.matchDate(testP2)==null);
        TestCase.assertTrue(GymCenter.matchDate(testP3)==testP3);
        TestCase.assertTrue(GymCenter.matchDate(testP4)==testP4);
        TestCase.assertTrue(GymCenter.matchKund("1001", allP)==testP1);
        TestCase.assertFalse(GymCenter.matchKund("Tom", allP)==testP2);
        TestCase.assertTrue(GymCenter.noSameKund(sameP)==sameP);
    }
    
    
}
