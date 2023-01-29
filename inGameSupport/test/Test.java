
import bo.impl.NegocioBOImpl;
import org.junit.AfterClass;
import org.junit.BeforeClass;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author manue
 */
public class Test {
    NegocioBOImpl tester;

  @BeforeClass
  public static void testSetup() {
    tester = new NegocioBOImpl();
  }

  @AfterClass
  public static void testCleanup() {
    // Do your cleanup here like close URL connection , releasing resources etc
  }

  @Test(expected = IllegalArgumentException.class)
  public void testExceptionIsThrown() {        
    tester.divide(1000, 0);
  }

  @Test
  public void testMultiply() {
    assertEquals("Result", 50, tester.multiply(10, 5));
  }
}
