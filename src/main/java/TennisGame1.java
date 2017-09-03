import java.util.HashMap;

public class TennisGame1 implements TennisGame {
    
	private final int DEFAULT_SAME_SCORE = -1;
	private final int DEFAULT_MORE_THAN_FOUR_SCORE = -2;
	
	private Player playerFirst;
	private Player playerSecond;
	private HashMap<Integer, String> sameScores = new HashMap<Integer, String>();
	private HashMap<Integer, String> scoreMoreThanFour = new HashMap<Integer, String>();
	private HashMap<Integer, String> defualtScore = new HashMap<Integer, String>();
	
    public TennisGame1(String player1Name, String player2Name) {
        playerFirst = new Player(player1Name);
        playerSecond = new Player(player2Name);
        
        putScoreMoreThanFour();
        putSameScores();
        putDefaultScores();
    }

    public void wonPoint(String playerName) {
        if (playerName == "player1")
            playerFirst.setScore(playerFirst.getScore() + 1);
        else
        	playerSecond.setScore(playerSecond.getScore() + 1);

    }

    public String getScore() {
        int playerFirstScore = playerFirst.getScore();
        int playerSecondScore = playerSecond.getScore();
        
        if (playerFirstScore == playerSecondScore)
        {
            return getSameScore(playerFirstScore);
        }
        else if (playerFirstScore>=4 || playerSecondScore>=4)
        {
            return getScoreMoreThanFour(playerFirstScore, playerSecondScore);
        }
        else
        {
            return getDefaultScore(playerFirstScore, playerSecondScore);
        }

    }

	private String getDefaultScore(int playerFirstScore, int playerSecondScore) {
		return defualtScore.get(playerFirstScore) + "-" + defualtScore.get(playerSecondScore);
	}

	private String getScoreMoreThanFour(int playerFirstScore, int playerSecondScore) {
		String score;
		int minusResult = playerFirstScore-playerSecondScore;
		int minMinusResult = Math.min(minusResult, 2);
		
		score = scoreMoreThanFour.get(minMinusResult);
		
		if(score == null)
			score = scoreMoreThanFour.get(DEFAULT_MORE_THAN_FOUR_SCORE);
		
		 return score;
	}

	private String getSameScore(int playerFirstScore) {
		String score;
		
		
		score = sameScores.get(playerFirstScore);
		
		if(score == null){
			score = sameScores.get(DEFAULT_SAME_SCORE);
		}
		return score;
	}
	
	private void putDefaultScores(){
		defualtScore.put(0, "Love");
		defualtScore.put(1, "Fifteen");
		defualtScore.put(2, "Thirty");
		defualtScore.put(3, "Forty");
	}
	private void putSameScores(){
		sameScores.put(0, "Love-All");
		sameScores.put(1, "Fifteen-All");
		sameScores.put(2, "Thirty-All");
		sameScores.put(-1, "Deuce");
	}
	private void putScoreMoreThanFour(){
		scoreMoreThanFour.put(1, "Advantage player1");
		scoreMoreThanFour.put(-1, "Advantage player2");
		scoreMoreThanFour.put(2, "Win for player1");
		scoreMoreThanFour.put(-2, "Win for player2");
	}
}
