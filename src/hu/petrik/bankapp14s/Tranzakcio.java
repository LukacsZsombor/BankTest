
package hu.petrik.bankapp14s;

public class Tranzakcio {
    private Szamla kuldo;
    private Szamla fogado;
    private long osszeg;

    public Tranzakcio(Szamla kuldo, Szamla fogado, long osszeg) {
        
        if (kuldo.equals(fogado) == true) {
            
            throw new IllegalArgumentException("A tranzakcioban a felado es a kuldo nem lehet ugyanaz");
            
        }
        
        else{ 
            if (osszeg < 1) {
                
                throw new IllegalArgumentException("Az osszeg nem lehet 0 vagy negativ");
                
            }
            else {
        
        this.kuldo = kuldo;
        this.fogado = fogado;
        this.osszeg = osszeg;
            }
        }
    }

    public Szamla getKuldo() {
        return kuldo;
    }

    public Szamla getFogado() {
        return fogado;
    }

    public long getOsszeg() {
        return osszeg;
    }
    
    
}
