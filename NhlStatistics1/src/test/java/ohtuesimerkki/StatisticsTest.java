/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtuesimerkki;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author cocacoca
 */
public class StatisticsTest {
    
   
     Readeri readerStub = new Readeri() {
 
        public List<Player> getPlayers() {
            ArrayList<Player> players = new ArrayList<Player>();
 
            players.add(new Player("Semenko", "EDM", 4, 12));
            players.add(new Player("Lemieux", "PIT", 45, 54));
            players.add(new Player("Kurri",   "EDM", 37, 53));
            players.add(new Player("Yzerman", "DET", 42, 56));
            players.add(new Player("Gretzky", "EDM", 35, 89));
 
            return players;
        }
    };
 
    Statistics stats;

    @Before
    public void setUp(){
        // luodaan Staatistics-olio joka käyttää "stubia"
        stats = new Statistics(readerStub);
    }@Test
    public void oikeaNimenHakuToimii(){
        String nimi="Semenko";
       assertEquals("Semenko", stats.search(nimi).getName());
    }@Test
    public void vaaraNimenHakuToimii(){
        String nimi="Vaara";
        assertEquals(null, stats.search(nimi));
    }@Test
    public void oikeaTiimiLoytyy(){
      String tiimi="PIT";  
      assertEquals(1, stats.team(tiimi).size());
              
    }@Test
    public void huippuTulosToimii(){
        int maara=2;
        assertEquals(3,stats.topScorers(maara).size());
    }
   
}
  
   

