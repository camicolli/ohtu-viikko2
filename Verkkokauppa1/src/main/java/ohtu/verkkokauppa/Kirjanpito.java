
package ohtu.verkkokauppa;

import java.util.ArrayList;


public class Kirjanpito implements KirjanpitoRajapinta{
//    private static Kirjanpito instance;
    
//    public static Kirjanpito getInstance() {
//        if ( instance==null) {
//            instance = new Kirjanpito();
 //       }
//        
////        return instance;
//    }
    
    private ArrayList<String> tapahtumat;

    public Kirjanpito() {
        tapahtumat = new ArrayList<String>();
    }
    
    @Override
    public void lisaaTapahtuma(String tapahtuma) {
        tapahtumat.add(tapahtuma);
    }

    @Override
    public ArrayList<String> getTapahtumat() {
        return tapahtumat;
    }       
}
