import java.util.Arrays;
import java.util.List;

public class MCQuestion implements Questionable {

    private String   question;
    private String[] options;      // e.g. {"A. ...", "B. ...", "C. ...", "D. ..."}
    private int      correctIdx;   // 0-based index of the correct option
  
    public MCQuestion(String question, String[] options, int correctIdx) {
        this.question   = question;
        this.options    = options;
        this.correctIdx = correctIdx;
    }

    @Override
    public String getQuestion() {
        return question;
    }
  
    //@Override
    public boolean checkAnswer(Object answer) {
        if (answer instanceof Integer) {
            return (Integer) answer == correctIdx;
        }
        // Also accept a String matching the option text exactly
        if (answer instanceof String) {
            return options[correctIdx].equalsIgnoreCase((String) answer);
        }
        return false;
    }
  
    //@Override
    public String getType() {
        return "MCQ";
    }
  
    //@Override
    public List<String> getOptions() {
        return Arrays.asList(options);
    }

    public int    getCorrectIdx()          { return correctIdx; }
    public String getCorrectAnswer()       { return options[correctIdx]; }
    public void   setQuestion(String q)    { this.question = q; }
    public void   setOptions(String[] o)   { this.options  = o; }
    public void   setCorrectIdx(int idx)   { this.correctIdx = idx; } 
                                            
    @Override
    public String toString() {
        return "MCQuestion{question='" + question
                + "', correctAnswer='" + getCorrectAnswer() + "'}";
    }
}

