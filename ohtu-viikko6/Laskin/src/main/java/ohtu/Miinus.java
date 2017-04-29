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
public class Miinus implements Komento{

  private int tulos;
  private int vahennettava;

  public Miinus(int luku) {
    this.tulos = luku;
    this.vahennettava = 0;
  }


  public void muutaVahennettava(int luku) {
    vahennettava = luku;
  }

  @Override
  public int suorita(int luku) {
    muutaVahennettava(luku);
    return tulos -= luku;
  }

  @Override
  public int undo() {
    tulos += vahennettava;
    muutaVahennettava(0);
    return tulos;
  }
}
