/*
 * Carcasa calculatorului de birou
 */
package oopcomputer;

/**
 *
 * @author gheor
 */
public class Carcasa {
    
    public Ecran ecran = new Ecran();
    public Buton buton0 = new Buton('0');
    public Buton buton1 = new Buton('1');
    public Buton buton2 = new Buton('2');
    public Buton buton3 = new Buton('3');
    public Buton buton4 = new Buton('4');
    public Buton buton5 = new Buton('5');
    public Buton buton6 = new Buton('6');
    public Buton buton7 = new Buton('7');
    public Buton buton8 = new Buton('8');
    public Buton buton9 = new Buton('9');
    public Buton butonPlus = new Buton('+');
    public Buton butonMinus = new Buton('-');
    public Buton butonOri = new Buton('*');
    public Buton butonImpartire = new Buton('/');
    public Buton butonEgal = new Buton('=');
    private ALU alu = new ALU();      
}
