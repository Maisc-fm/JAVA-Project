import java.util.ArrayList;
import java.util.List;

public class User implements Scorable {
    
    private String username;
    private int    score;
    private String badge
    
    public User(String username) {
        this.username = username;
        this.score    = 0;
        this.badge    = "";
    }
    
    public boolean login(String enteredName) {
        if (enteredName == null || enteredName.trim().isEmpty()) {
            return false;
        }
        this.username = enteredName.trim();
        return true;

    @Override
    public int calculateScore() {
        return this.score;
    }

    @Override
    public void saveScore(String name, int score) {
        // FileStorage handles actual DB/file write (Member 3)
        FileStorage fs = new FileStorage();
        fs.wroteScore(name, score);
        this.score = score;
    }
        
    @Override
    public List<String> loadScores() {
        FileStorage fs = new FileStorage();
        return fs.readAllScores();
    }
        
    public String getUsername() { return username; }
    public void   setUsername(String username) { this.username = username; }

    public int  getScore()          { return score; }
    public void setScore(int score) { this.score = score; }

    public String getBadge()            { return badge; }
    public void   setBadge(String badge){ this.badge = badge; }

    @Override
    public String toString() {
        return "User{username='" + username + "', score=" + score
                + ", badge='" + badge + "'}";
    }
}
