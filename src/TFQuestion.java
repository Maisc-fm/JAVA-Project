import java.util.Arrays;
import java.util.List;

// TFQuestion (True/False Question)
// Made by Nashrur Aisyha Hani binti Suphian @ Sharbini (102776) 
// This class represents a True/False quiz question.
// It stores the question, the correct answer and checks whether the user's answer is correct.
public class TFQuestion implements Questionable {

    // Stores the correct answer (true = True, false = False)
    private boolean answer;

    // Stores the question text
    private String question;

    // Creates a new True/False question.
    // @param question The question to display
    // @param answer The correct answer (true or false)
    public TFQuestion(String question, boolean answer) {
        this.question = question;
        this.answer = answer;
    }

    // Returns the question text.
    @Override
    public String getQuestion() {
        return question;
    }

    // Checks if the user's answer is correct.
    // Accepts either a Boolean value or a String. 
    @Override
    public boolean checkAnswer(Object a) {

        // If the answer is a Boolean, compare it directly
        if (a instanceof Boolean) {
            return (Boolean) a == answer;
        }

        // If the answer is a String, convert it to true/false first
        if (a instanceof String) {
            boolean parsed = Boolean.parseBoolean(((String) a).trim());
            return parsed == answer;
        }

        // Any other type of input is considered incorrect
        return false;
    }

    // Returns the question type.
    @Override
    public String getType() {
        return "TF";
    }

    // Returns the available answer choices.
    @Override
    public List<String> getOptions() {
        return Arrays.asList("True", "False");
    }

    // Returns the correct answer.
    public boolean getAnswer() {
        return answer;
    }

    // Updates the correct answer.
    public void setAnswer(boolean answer) {
        this.answer = answer;
    }

    // Updates the question text.
    public void setQuestion(String question) {
        this.question = question;
    }

    // Returns the object information as a String.
    // Useful for testing and debugging.
    @Override
    public String toString() {
        return "TFQuestion{" +
               "question='" + question + '\'' +
               ", answer=" + answer +
               '}';
    }
}
