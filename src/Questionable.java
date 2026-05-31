import java.util.List;

// Made by Nashrur Aisyha Hani binti Suphian @ Sharbini (102776) 
// Interface for quiz questions.
// It defines the methods that every question class must have.
public interface Questionable {

    // Get the question.
    String getQuestion();

    // Check whether the answer is correct.
    boolean checkAnswer(Object a);

    // Get the question type.
    String getType();

    // Get the answer options.
    List<String> getOptions();
}
