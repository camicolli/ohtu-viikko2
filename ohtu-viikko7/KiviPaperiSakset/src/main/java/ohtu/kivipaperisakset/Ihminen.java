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
public class Ihminen implements Pelaaja{
    private IO io;
    private String siirto;

    public Ihminen(IO io){
        this.io=io;
    }
    @Override
    public void setSiirto() {
        io.print("Pelaajan siirto: ");
        this.siirto=io.readLine();
    }

    @Override
    public String getSiirto() {
        return siirto;
    }
    
}
