/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.kivipaperisakset;

/**
 *
 * @author cocacoca
 */
import java.util.Scanner;
       
public class KPS {
    public Pelaaja p1;
    public Pelaaja p2;
    public IO io;
    
    public KPS(Pelaaja p1, Pelaaja p2, IO io){
        this.p1=p1;
        this.p2=p2;
        this.io=io;
    }
    
    public void pelaa(){
        Tuomari tuomari =new Tuomari();
        vuoro(p1);
        vuoro(p2);
        
        while(siirtoOk(p1.getSiirto()) && siirtoOk(p2.getSiirto())){
            tuomari.kirjaaSiirto(p1.getSiirto(), p2.getSiirto());
            io.print(tuomari.toString());
            io.print("");
            
            vuoro(p1);
            vuoro(p2);
        }
        io.print("");
        io.print("Kiitos käynnistä!");
        io.print(tuomari.toString());
                 
    }
    public void vuoro(Pelaaja pelaaja){
        pelaaja.setSiirto();
    }
    private static boolean siirtoOk(String s){
        return "k".equals(s) || "p".equals(s) ||"s".equals(s);
    }
}
