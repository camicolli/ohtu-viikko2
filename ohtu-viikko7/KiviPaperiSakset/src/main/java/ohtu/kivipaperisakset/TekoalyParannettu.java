package ohtu.kivipaperisakset;

// "Muistava tekoäly"
public class TekoalyParannettu implements Pelaaja {

    private String[] muisti;
    private int vapaaMuistiIndeksi;
    private String siirto;

    public TekoalyParannettu(int muistinKoko) {
        muisti = new String[muistinKoko];
        vapaaMuistiIndeksi = 0;
    }

    public void asetaSiirto(String siirto) {
        // jos muisti täyttyy, unohdetaan viimeinen alkio
        if (vapaaMuistiIndeksi == muisti.length) {
            for (int i = 1; i < muisti.length; i++) {
                muisti[i - 1] = muisti[i];
            }

            vapaaMuistiIndeksi--;
        }

        muisti[vapaaMuistiIndeksi] = siirto;
        vapaaMuistiIndeksi++;
    }

    public void setSiirto() {
        if (vapaaMuistiIndeksi == 0 || vapaaMuistiIndeksi == 1) {
            siirto = "k";
        } else {

            String viimeisinSiirto = muisti[vapaaMuistiIndeksi - 1];

            int k = 0;
            int p = 0;
            int s = 0;

            for (int i = 0; i < vapaaMuistiIndeksi - 1; i++) {
                if (viimeisinSiirto.equals(muisti[i])) {
                    String seuraava = muisti[i + 1];

                    if ("k".equals(seuraava)) {
                        k++;
                    } else if ("p".equals(seuraava)) {
                        p++;
                    } else {
                        s++;
                    }
                }
            }

            if (k > p && k > s) {
                siirto = "p";
            } else if (p > k && p > s) {
                siirto = "s";
            } else {
                siirto = "k";
            }

        }

    }

    @Override
    public String getSiirto() {
        return siirto;
    }
}
