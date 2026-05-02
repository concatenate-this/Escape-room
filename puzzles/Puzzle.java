package puzzles;

public abstract class Puzzle {
    protected String name;
    protected String prompt;
    protected boolean solved;

    public Puzzle(String name, String prompt) {
        this.name = name;
        this.prompt = prompt;
        this.solved = false;
    }

    public String getName() {
        return name;
    }

    public String getPrompt() {
        return prompt;
    }

    public boolean isSolved() {
        return solved;
    }

    public abstract String attemptSolve(String answer);
}
