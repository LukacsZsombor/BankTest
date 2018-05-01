
package hu.petrik.bankapp14s;

import java.util.ArrayList;
import java.util.List;


public class Bank {
    private List<Szamla> szamlak = new ArrayList<>();
    private List<Tranzakcio> tranzakciok = new ArrayList<>();
    private String elotag = "321";
    public void utalas(String honnan, String hova, long osszeg) throws Exception {
        
        Szamla forras = null, cel = null;
        
        if (honnan.equals(hova) == true || osszeg < 1) {
        
            throw new Exception("A felado es a cimzett szamlaszam nem lehet ugyanaz");
            
       
        
        }
        else {
            
             for (Szamla sz: szamlak) {
            if (honnan.equals(sz.getSzamlaszam())) {
                forras = sz;
            }
            else if (hova.equals(sz.getSzamlaszam())) {
                cel = sz;
            }
        }
        
        forras.setOsszeg(forras.getOsszeg() - osszeg);
        cel.setOsszeg(cel.getOsszeg() + osszeg);
        tranzakciok.add(new Tranzakcio(forras, cel, osszeg));
            
        
        }
    }

    public void ujSzamla(Szamla sz) {
        
        
        if (sz.getSzamlaszam().startsWith(elotag) == true) { 
        szamlak.add(sz);
        }
        
        else {
            
            throw new IllegalArgumentException("Nem megfelelo a szamlaszam kezdete");
            
        }
    }

    List<Tranzakcio> getTranzakciok() {
        return new ArrayList<>(tranzakciok);
    }
}
