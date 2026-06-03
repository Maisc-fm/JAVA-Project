public class Leaderboard implements Rankable {
    
//Member 4
//Made by Nur Syukrinah binti Suhaidi (97717)

    // Total points in the leaderboard.
    private int points;

    // Current leaderboard rank.
    private String rank;

    // Constructor.
    // Creates a new leaderboard object.
    public Leaderboard() {
        points = 0;
        rank = "Beginner";
    }

    // Returns the current rank.
    @Override
    public String getRank() {
        return rank;
    }

    // Returns the current points.
    @Override
    public int getPoints() {
        return points;
    }

    // Updates rank based on points.
    @Override
    public void updateRank() {

        if(points >= 90)
            rank = "Master";
        else if(points >= 75)
            rank = "Expert";
        else if(points >= 50)
            rank = "Intermediate";
        else
            rank = "Beginner";
    }
}
