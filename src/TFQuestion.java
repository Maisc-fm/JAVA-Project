// Class: TFQuestion
// Represents a True/False question.
// Demonstrates:
// - Interface Implementation
// - Polymorphism
// - Method Overriding
// Created By: Nashrur Aisyha Hani binti Suphian @ Sharbini (102776)

public class TFQuestion implements Questionable {

    private String question;
    private boolean answer;

    // Constructor
    // @param question Question text
    // @param answer Correct answer
    public TFQuestion(String question, boolean answer) {
        this.question = question;
        this.answer = answer;
    }

    // Returns question text.
    @Override
    public String getQuestion() {
        return question;
    }

    // Checks answer.
    @Override
    public boolean checkAnswer(String userAnswer) {

        boolean userBoolean =
                Boolean.parseBoolean(userAnswer);

        return userBoolean == answer;
    }

    //Returns question type.
    public String getType() {
        return "True/False Question";
    }
}
