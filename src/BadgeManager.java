public class BadgeManager {
    //Member 4
    //Made by Nur Syukrinah binti Suhaidi (97717)
    
    // This method takes the player's score as input
    // and returns the corresponding badge (rank).
    public String getBadge(int score) {
        if (score >= 90) return "Master";
        else if (score >= 75) return "Expert";
        else if (score >= 50) return "Intermediate";
        else return "Beginner";
    }
    
}
