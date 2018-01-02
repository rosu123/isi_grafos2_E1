package org.urjc.isi.travis;


import static org.junit.Assert.*;
import org.junit.*;
import java.util.*;
import java.io.*;


public class PrintPrimesTest 
{
	//private int n;
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private ByteArrayOutputStream errContent = new ByteArrayOutputStream();
		
    		
    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
        System.setErr(null);
    }
    
    
    @Test
    public void t1() throws IOException {
        String[] args = {"5"};
        
        PrintPrimes.main(args);
        assertEquals("Prime: 2\n" + "Prime: 3\n" + "Prime: 5\n" + "Prime: 7\n" + 
        			"Prime: 9\n", outContent.toString());
    }
    
    @Test
    public void t2() throws IOException {
        String[] args = {"3"};
        
        PrintPrimes.main(args);
        assertEquals("Prime: 2\n" + "Prime: 3\n" + "Prime: 5\n", outContent.toString());
    }
    
    @Test
    public void t3() throws IOException {
        String[] args = {"2"};
        
        PrintPrimes.main(args);
        assertEquals("Prime: 2\n" + "Prime: 3\n", outContent.toString());
    }
    
    @Test
    public void t4() throws IOException {
        String[] args = {"1"};
        
        PrintPrimes.main(args);
        assertEquals("Prime: 2\n", outContent.toString());
    }
    
    @Test //Falla en este test ya que por defecto mete el 2 como mínimo a la lista de numeros primos
    public void t5() throws IOException {
        String[] args = {"0"};
        
        PrintPrimes.main(args);
        assertEquals("", outContent.toString());
    }
    
    @Test
    public void t6() throws IOException {
        String[] args = {""};
        
        PrintPrimes.main(args);
        assertEquals("Entry must be a integer, using 1.\n" + "Prime: 2\n", outContent.toString());
    }
	
    
    
}
