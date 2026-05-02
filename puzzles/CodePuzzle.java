package puzzles;

public class CodePuzzle extends Puzzle {
    private String code;
    private String successMessage;

    public CodePuzzle(String name, String prompt, String code, String successMessage) {
        super(name, prompt);
        this.code = code;
        this.successMessage = successMessage;
    }

    @Override
    public String attemptSolve(String attempt) {
        if (solved) {
            return "The code has already been entered.";
        }
        if (attempt.trim().equals(code)) {
            solved = true;
            return successMessage;
        }
        return "Wrong code. Try again.";
    }
}
