package ohtu.kivipaperisakset;

public class Tekoaly implements Pelaaja {
    private IO io;
    int siirto;
    String nimi;
    public Tekoaly(IO io){
        siirto=0;
        this.io=io;
        nimi="";
    }

    
    public String annaSiirto() {
        siirto++;
        siirto = siirto % 3;

        switch (siirto) {
            case 0:
                return "k";
            case 1:
                return "p";
            default:
                return "s";
        }
}
    
     @Override
    public void setSiirto() {
        siirto++;
        siirto = siirto % 3;
        
        if (siirto == 0) {
            nimi =  "k";
        } else if (siirto == 1) {
            nimi=  "p";
        } else {
            nimi=  "s";
        }
        io.print("Tietokone valitsi: " + nimi);
}
   
@Override
    public String getSiirto() {
      return nimi;
}

}
