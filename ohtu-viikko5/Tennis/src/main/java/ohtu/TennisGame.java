package ohtu;

import java.util.HashMap;

public class TennisGame {

    private HashMap<Integer, String> pointToText;
    private int m_score1 = 0;
    private int m_score2 = 0;
    private String player1Name;
    private String player2Name;

    public TennisGame(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
        pointToText.put(0, "Love");
        pointToText.put(1, "Fifteen");
        pointToText.put(2, "Thirty");
        pointToText.put(3, "Forty");
    }

    public void wonPoint(String playerName) {
        if (playerName.equals(player1Name)) {
            m_score1++;
        } else if(playerName.equals(player2Name)){
            m_score2++;
        }
    }

    public String resultCounter() {
        int result = m_score1 - m_score2;
        if (result == 1) {
            return "Advantage " + player1Name;
        }
        if (result == -1) {
            return "Advantage " + player2Name;
        }
        if (result >= 2) {
            return "Win for " + player1Name;
        }

        return "Win for " + player2Name;

    }

    public String getScore() {

        if (m_score1 == m_score2) {
            if (m_score1 < 4) {
                return pointToText.get(m_score1) + "-All";
            }
            return "Deuce";
        
        } else if (m_score1 >= 4 || m_score2 >= 4) {
            return resultCounter();

        }
        return pointToText.get(m_score1) + "-" + pointToText.get(m_score2);

    }
}
