package puzzles;

public class RiddlePuzzle extends Puzzle {
    private String answer;
    private String reward;

    public RiddlePuzzle(String name, String riddle, String answer, String reward) {
        super(name, riddle);
        this.answer = answer.toLowerCase();
        this.reward = reward;
    }

    public String getReward() {
        return reward;
    }

    @Override
    public String attemptSolve(String guess) {
        if (solved) {
            return "You've already solved this riddle.";
        }
        if (guess.trim().toLowerCase().equals(answer)) {
            solved = true;
            return "Correct! " + reward;
        }
        return "That's not right. Think harder...";
    }
}
