import java.util.ArrayList;

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

    public String solvePuzzle(Grid grid){
        return "";
    }
}
