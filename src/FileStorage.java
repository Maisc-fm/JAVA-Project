import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

//Class: FileStorage
//Creator: Bong Ming Meng (103541)
//Tester:
//Handles data storage for user scores using JavaDB for the Quality Education

public class FileStorage {
    private static final String FILE_PATH = "jdbc:derby:QuizDB;create=true";
    private Connection connection;

    public FileStorage(){
        try {
            //connect to JavaDB
            connection = DriverManager.getConnection(FILE_PATH);
            createTable(); // Create table if not exist
            System.out.println("Database connected successfully.");
        } catch (Exception e) {
            System.out.println("Database connection failed: " + e.getMessage());
        }
    }
    
    //Create scores table if not exists
    private void createTable(){
        try{
            Statement stmt = connection.createStatement();
            stmt.executeUpdate(
                "CREATE TABLE scores("+
                "id INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,"+
                "username VARCHAR(255),"+
                "score INT,"+
                "totalPoints INT,"+
                "message VARCHAR(255),"+
                "date TIMESTAMP DEFAULT CURRENT_TIMESTAMP"+
                ")"
            );
            System.out.println("Table created successfully.");
        } catch (Exception e) {
            System.out.println("Table already exists.");
        }
    }

    //Save score to database
    public void wroteScore(String user, int score, String message){
        try{
            PreparedStatement pstmt = connection.prepareStatement(
                "INSERT INTO scores(username, score, message) VALUES(?, ?, ?)"
            );
            pstmt.setString(1, user);
            pstmt.setInt(2, score);
            pstmt.setString(3, message);
            pstmt.executeUpdate();
            System.out.println("Score saved successfully.");
        } catch (Exception e) {
            System.out.println("Error saving score: " + e.getMessage());
        }
    }

    //read all scores from database
    public List <String> readAllScores(){
        List<String> scoreList = new ArrayList<>();
        try{
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(
                "SELECT username, score, message FROM scores ORDER BY score DESC"
            );
            while (rs.next()){
                String entry = rs.getString("username")+ "," +
                                rs.getInt("score") + "," +
                                rs.getString("message");
                scoreList.add(entry);
            }
        } catch (Exception e) {
            System.out.println("Failed to read scores: " + e.getMessage());
        }
        return scoreList;
    }

    //Close databese connection
    public void closeConnection(){
        try {
            if (connection != null){
                connection.close();
                System.out.println("Database connection closed.");
            }
        } catch (Exception e) {
            System.out.println("Failed to close connection: " + e.getMessage());
        }
    }

}
