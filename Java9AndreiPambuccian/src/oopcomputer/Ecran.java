/*
 * Ecranul calculatorului
 */
package oopcomputer;

/**
 *
 * @author gheor
 */
public class Ecran {
    
    private String afisaj = "0";
    private Carcasa carcasa;
    
    public Ecran(Carcasa nouaCarcasa) {
        this.carcasa = nouaCarcasa;        
    }
    
    public String getAfisaj() {
        return this.afisaj;
    }

    public void setAfisaj(String afisaj) {
        this.afisaj = afisaj;
    }
    
    public void printAfisaj(String afisaj) {
        System.out.println(this.afisaj);
    }
    
}
