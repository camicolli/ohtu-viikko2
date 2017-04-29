package statistics;

import statistics.matcher.KyselyBuilderi;
import statistics.matcher.*;

public class Main {
    public static void main(String[] args) {
          Statistics stats = new Statistics(new PlayerReaderImpl("http://nhlstats-2013-14.herokuapp.com/players.txt"));



                          KyselyBuilderi query = new KyselyBuilderi();

                          Matcher m = query.oneOf(
                          query.playsIn("PHI")
                               .hasAtLeast(10, "goals")
                               .hasFewerThan(30, "assists").build(),

                          query.playsIn("EDM")
                               .hasAtLeast(50, "points").build()
                         ).hasFewerThan(70,"points").build();

        
                          stats.matches(m).forEach((player) -> {
                              System.out.println( player );
        });
}
}
