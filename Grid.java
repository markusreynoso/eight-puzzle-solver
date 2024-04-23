import java.util.ArrayList;

public class Grid {
    private ArrayList<ArrayList<Character>> layout = new ArrayList<>();

    public Grid(String inputLayout) {
        // Adds three rows to the grid
        for (int time = 0; time < 3; time++) {
            this.layout.add(new ArrayList<Character>());
        }

        for (int rowIndex = 0; rowIndex < 3; rowIndex++) {
            this.layout.get(0).add(inputLayout.charAt(rowIndex));
        }

        for (int rowIndex = 3; rowIndex < 6; rowIndex++) {
            this.layout.get(1).add(inputLayout.charAt(rowIndex));
        }

        for (int rowIndex = 6; rowIndex < 9; rowIndex++) {
            this.layout.get(2).add(inputLayout.charAt(rowIndex));
        }
    }

    public ArrayList<ArrayList<Character>> getLayout() {
        return layout;
    }

    public String getLayoutPrint(){
        String output = "";
        for(ArrayList<Character> row : this.layout){
            output += row.toString() + "\n";
        }
        return output;
    }
}
