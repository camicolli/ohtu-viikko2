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
public class Kayttoliittyma {
private IO io;
private Pelitehdas tehdas;

public Kayttoliittyma() {
    this.io = new IO();
    tehdas = new Pelitehdas(io);
}

public void kaynnista(){
     while (true) {
        io.print("\nValitse pelataanko"
                + "\n (a) ihmistä vastaan "
                + "\n (b) tekoälyä vastaan"
                + "\n (c) parannettua tekoälyä vastaan"
                + "\nmuilla valinnoilla lopetataan");

        String vastaus = io.readLine();
        if (vastaus.length() != 1) {
          break;
        }
        KPS peli = tehdas.hae(vastaus.charAt(0));
        if (peli == null) {
          break;
        }
        peli.pelaa();
}
}

}
