
package hu.petrik.bankapp14s;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class BankTest {
    
    public BankTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void sikeresUtalas() throws Exception {
        Bank bank = new Bank();
        Szamla sz1 = new Szamla("32140000-11111111-00000000", 100000);
        Szamla sz2 = new Szamla("32180000-11111111-00000000", 5000);
        bank.ujSzamla(sz1);
        bank.ujSzamla(sz2);
        bank.utalas(sz1.getSzamlaszam(), sz2.getSzamlaszam(), 10000);
        
        assertEquals("Forras osszeg nem stimmel", 90000, sz1.getOsszeg());
        assertEquals("Cel osszeg nem stimmel", 15000, sz2.getOsszeg());
        assertEquals("Nem jott letre uj tranzakcio", 1, bank.getTranzakciok().size());
        
        assertNotEquals("A forras és a cel szamlaszam nem lehet ugyanaz", sz1.getSzamlaszam(), sz2.getSzamlaszam());
        assertNotEquals("A forras és a cel szamlaszam nem lehet ugyanaz", sz2.getSzamlaszam(), sz1.getSzamlaszam());
        
        assertEquals("Nem megfelelo a szamlaszam kezdete", "321", sz1.getSzamlaszam().substring(0, 3));
        assertEquals("Nem megfelelo a szamlaszam kezdete", "321", sz2.getSzamlaszam().substring(0, 3));
    }
}
