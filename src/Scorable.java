public interface Scorable {
    
    int calculateScore();
    void saveScore(String name, int score);
    java.util.List<String> loadScores();
}
