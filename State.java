public class State {
    private Grid grid;
    private String moveSequence;
    private Integer heuristic;

    public State(Grid grid, String moveSequence, Integer heuristic){
        this.grid = grid;
        this.moveSequence = moveSequence;
        this.heuristic = heuristic;
    }

    public Grid getGrid() {
        return grid;
    }

    public String getMoveSequence() {
        return moveSequence;
    }

    public Integer getHeuristic() {
        return heuristic;
    }
}
