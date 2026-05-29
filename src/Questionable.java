//Interface: Questionable
//Creator：Bong Ming Meng (103541)
//Defines the contract for all question types in the Quality Education Quiz.

public interface Questionable {

    String getQuestionText();
    boolean checkAnswer(String userAnswer);
    String getCorrectAnswer();
    String getQuestionType();
    int getPoints();
    
}
