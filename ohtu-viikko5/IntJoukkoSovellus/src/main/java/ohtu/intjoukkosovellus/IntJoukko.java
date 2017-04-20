
package ohtu.intjoukkosovellus;

public class IntJoukko {

    public final static int KAPASITEETTI = 5, // aloitustalukon koko
                            OLETUSKASVATUS = 5;  // luotava uusi taulukko on 
    // näin paljon isompi kuin vanha
    private int kasvatuskoko;     // Uusi taulukko on tämän verran vanhaa suurempi.
    private int[] ljono;      // Joukon luvut säilytetään taulukon alkupäässä. 
    private int alkioidenLkm;    // Tyhjässä joukossa alkioiden_määrä on nolla. 

    public IntJoukko() {
        this(KAPASITEETTI,OLETUSKASVATUS);

 }

    public IntJoukko(int kapasiteetti) {
     this(kapasiteetti,OLETUSKASVATUS);

    }
    
    
    public IntJoukko(int kapasiteetti, int kasvatuskoko) {
        if(kapasiteetti>0 && kasvatuskoko>0){
            aloitus(kapasiteetti,kasvatuskoko);
        }
    }
    
    public void aloitus(int kapasiteetti,int kasvatuskoko){
        this.kasvatuskoko=kasvatuskoko;
        this.ljono=new int[kapasiteetti];
        this.alkioidenLkm=0;
    }
    public boolean kasvata(){
       if (alkioidenLkm < ljono.length) {
        return false;
      }
        int[] uusi = new int[alkioidenLkm + kasvatuskoko];
        kopioiTaulukko(ljono,uusi);
        ljono = uusi;
        return true;
    }
    

    public boolean lisaa(int luku) {
      if (kuuluu(luku)) {
        return false;
      }
      kasvata();
      ljono[alkioidenLkm] = luku;
      alkioidenLkm++;
      return true;
        
        
    }

    public boolean kuuluu(int luku) {
        return indeksi(luku)!=-10;
    }
    public int indeksi(int luku){
         for (int i = 0; i < alkioidenLkm; i++) {
          if (luku == ljono[i]) {
              return i;
          }
      }
      return -10;
    }
    

    public boolean poista(int luku) {
        if (indeksi(luku) != -10) {
        
            for (int i = indeksi(luku) ; i < alkioidenLkm - 1; i++) {
             ljono[i] = ljono[i + 1];
        }
        alkioidenLkm--;
        return true;
      }
      return false;
    }

    private void kopioiTaulukko(int[] vanha, int[] uusi) {
        for (int i = 0; i < vanha.length; i++) {
            uusi[i] = vanha[i];
        }

    }

    public int mahtavuus() {
        return alkioidenLkm;
    }
public String getAlkiot() {
    String alkiot="";
    for(int i=0; i<alkioidenLkm -1;i++){
        alkiot+=ljono[i]+", ";
       }
    alkiot+=ljono[alkioidenLkm-1];
    return alkiot;
}

    @Override
    public String toString() {
        if (alkioidenLkm == 0) {
          return"{}";
        }return "{"+getAlkiot()+"}";
    }

    public int[] toIntArray() {
        int[] taulu = new int[alkioidenLkm];
        for (int i = 0; i < taulu.length; i++) {
            taulu[i] = ljono[i];
        }
        return taulu;
    }
   

    public static IntJoukko yhdiste(IntJoukko a, IntJoukko b) {
        IntJoukko x = new IntJoukko();
        
        for (int i = 0; i < a.mahtavuus(); i++) {
            x.lisaa(a.toIntArray()[i]);
        }
        for (int i = 0; i < b.mahtavuus(); i++) {
            x.lisaa(b.toIntArray()[i]);
        }
        return x;
    }

    public static IntJoukko leikkaus(IntJoukko a, IntJoukko b) {
        IntJoukko joukko = new IntJoukko();
        for (int j = 0; j < b.mahtavuus(); j++) {
                if (jonokuuluu(a.toIntArray(), b.toIntArray()[j])) {
                    joukko.lisaa(b.toIntArray()[j]);
                }
            }
        
        return joukko;

    }public static boolean jonokuuluu(int[] jono,int luku){
        for (int i = 0; i < jono.length; i++) {
        if (luku == jono[i]) {
          return true;
        }
      }
      return false;
    }
    
    public static IntJoukko erotus ( IntJoukko a, IntJoukko b) {
        IntJoukko z = new IntJoukko();
        int[] aTaulu = a.toIntArray();
        int[] bTaulu = b.toIntArray();
        for (int i = 0; i < aTaulu.length; i++) {
            z.lisaa(aTaulu[i]);
        }
        for (int i = 0; i < bTaulu.length; i++) {
            z.poista(i);
        }
 
        return z;
    }
        
}