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
public class Plus implements Komento {

  private int tulos;
  private int lisattava;

  public Plus(int arvo) {
    this.tulos = arvo;
    this.lisattava = 0;
  }

  public void muutaLisattava(int arvo) {
    this.lisattava = arvo;
  }

  @Override
  public int suorita(int arvo) {
    muutaLisattava(arvo);
    return tulos += arvo;
  }

  @Override
  public int undo() {
    tulos -= lisattava;
    muutaLisattava(0);
    return tulos;
  }

}
