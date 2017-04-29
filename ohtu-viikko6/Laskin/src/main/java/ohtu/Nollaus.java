/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu;

/**
 *
 * @author cocacoca
 */
public class Nollaus implements Komento {

  private int alkuarvo;


  public Nollaus(int luku) {
   this.alkuarvo = luku;
  }

  public void nollaaAlkuarvo() {
      alkuarvo = 0;
  }

  

 @Override
 public int suorita(int luku) {
   return 0;
 }

 @Override
 public int undo() {
   int palautus = alkuarvo;
   nollaaAlkuarvo();
   return palautus;
 }
}
