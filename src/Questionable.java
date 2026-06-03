// Interface: Questionable
// Defines behaviors that every question type must implement.
// Created By: Nashrur Aisyha Hani binti Suphian @ Sharbini

public interface Questionable {

    // Returns the question text
    // @return question
    String getQuestion();

    // Checks whether user's answer is correct.
    // @param answer user's answer
    // @return true if correct
    boolean checkAnswer(String answer);
}
