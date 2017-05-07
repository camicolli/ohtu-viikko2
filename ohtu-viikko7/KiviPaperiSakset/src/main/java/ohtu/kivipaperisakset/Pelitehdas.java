/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.kivipaperisakset;

import java.util.*;

/**
 *
 * @author cocacoca
 */
public class Pelitehdas {

    private HashMap<Character, KPS> peliMap;
    private IO io;

    public Pelitehdas(IO io) {
        this.peliMap = new HashMap();
        this.io = io;
        alusta();
    }

    public void alusta() {
        peliMap.put('a', new KPS(new Ihminen(this.io), new Ihminen(this.io), this.io));
        peliMap.put('b', new KPS(new Ihminen(this.io), new Tekoaly(io), this.io));
        peliMap.put('c', new KPS(new Ihminen(this.io), new TekoalyParannettu(20), this.io));
    }
    
    public KPS hae( char x){
        return peliMap.get(x);
    }
}
