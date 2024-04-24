import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class Solver {
    public void slideTile(Grid grid, String move){
        int spaceYPos = 0;
        int spaceXPos = 0;
        String temp = "";

        // Find space
        for (int y = 0; y < 3; y++){
            for (int x = 0; x < 3; x++){
                if (grid.getLayout().get(y).get(x).equals(" ")){
                    spaceYPos = y;
                    spaceXPos = x;
                }
            }
        }

        switch (move) {
            case "u":
                if (spaceYPos != 2) {
                    temp = grid.getLayout().get(spaceYPos).get(spaceXPos);
                    grid.getLayout().get(spaceYPos).set(spaceXPos, grid.getLayout().get(spaceYPos + 1).get(spaceXPos));
                    grid.getLayout().get(spaceYPos + 1).set(spaceXPos, temp);
                }
                break;
            case "d":
                if (spaceYPos != 0) {
                    temp = grid.getLayout().get(spaceYPos).get(spaceXPos);
                    grid.getLayout().get(spaceYPos).set(spaceXPos, grid.getLayout().get(spaceYPos - 1).get(spaceXPos));
                    grid.getLayout().get(spaceYPos - 1).set(spaceXPos, temp);
                }
                break;
            case "l":
                if (spaceXPos != 2) {
                    temp = grid.getLayout().get(spaceYPos).get(spaceXPos);
                    grid.getLayout().get(spaceYPos).set(spaceXPos, grid.getLayout().get(spaceYPos).get(spaceXPos + 1));
                    grid.getLayout().get(spaceYPos).set(spaceXPos + 1, temp);
                }
                break;
            case "r":
                if (spaceXPos != 0) {
                    temp = grid.getLayout().get(spaceYPos).get(spaceXPos);
                    grid.getLayout().get(spaceYPos).set(spaceXPos, grid.getLayout().get(spaceYPos).get(spaceXPos - 1));
                    grid.getLayout().get(spaceYPos).set(spaceXPos - 1, temp);
                    break;
                }
        }
    }

    public boolean isSolved(Grid grid){
        String numbers = "12345678";
        String extracted = "";
        for (ArrayList<String> row : grid.getLayout()){
            for (String tile : row){
                if (numbers.contains(tile)){
                    extracted += tile;
                }
            }
        }

        for (int index = 0; index <= 7; index++){
            if (index + 1 != Integer.parseInt(String.valueOf(extracted.charAt(index)))){
                return false;
            }
        }
        return true;
    }

    public int computeHeuristic(Grid grid){
        String numbers = "12345678";
        String extracted = "";
        int counter = 0;

        for (ArrayList<String> row : grid.getLayout()){
            for (String tile : row){
                if (numbers.contains(tile)){
                    extracted += tile;
                }
            }
        }

        for (int index = 0; index <= 7; index++){
            if (index + 1 != Integer.parseInt(String.valueOf(extracted.charAt(index)))){
                counter++;
            }
        }

        return counter;
    }

    public Grid deepCopyGrid(Grid grid){
        ArrayList<ArrayList<String>> layoutCopy = new ArrayList<>();
        for (ArrayList<String> row : grid.getLayout()){
            ArrayList<String> newRow = new ArrayList<>(row);
            layoutCopy.add(newRow);
        }
        return new Grid(layoutCopy);
    }

    public String solvePuzzleAStar(Grid grid){
        if (isSolved(grid)){
            return "Already solved";
        }

        HashSet<String> visited = new HashSet<>();
        ArrayList<State> frontiers = new ArrayList<>();
        String[] moves = {"u", "d", "l", "r"};

        State initialState = new State(grid, "", computeHeuristic(grid));
        frontiers.add(initialState);

        while (frontiers.size() != 0){
            State currentState = frontiers.get(0);
            frontiers.remove(0);
            for (String move : moves){
                Grid gridcopy = deepCopyGrid(currentState.getGrid());
                slideTile(gridcopy, move);
                if (isSolved(gridcopy)){
                    return currentState.getMoveSequence() + move;
                }
                if (visited.contains(gridcopy.getLayout().toString())){
                    continue;
                }
                visited.add(gridcopy.getLayout().toString());

                int newStateHeuristic = computeHeuristic(gridcopy);
                State newState = new State(gridcopy, currentState.getMoveSequence() + move, newStateHeuristic);

                int insertIndex = 0;

                while (insertIndex < frontiers.size() && newStateHeuristic > frontiers.get(insertIndex).getHeuristic()){
                    insertIndex++;
                }
                frontiers.add(insertIndex, newState);
            }
        }
        return "Dead";
    }

    public String solvePuzzleBfs(Grid grid){
        if (isSolved(grid)){
            return "Already solved";
        }

        HashSet<String> visited = new HashSet<>();
        ArrayList<State> frontiers = new ArrayList<>();
        String[] moves = {"u", "d", "l", "r"};

        State initialState = new State(grid, "", computeHeuristic(grid));
        frontiers.add(initialState);

        while (frontiers.size() != 0){
            State currentState = frontiers.get(0);
            frontiers.remove(0);
            for (String move : moves){
                Grid gridcopy = deepCopyGrid(currentState.getGrid());
                slideTile(gridcopy, move);
                if (isSolved(gridcopy)){
                    return currentState.getMoveSequence() + move;
                }
                if (visited.contains(gridcopy.getLayout().toString())){
                    continue;
                }
                visited.add(gridcopy.getLayout().toString());

                State newState = new State(gridcopy, currentState.getMoveSequence() + move, 0);

                frontiers.add(newState);
            }
        }
        return "Dead";
    }
}
