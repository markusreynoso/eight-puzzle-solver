import java.util.ArrayList;

public class Grid {
    private ArrayList<ArrayList<String>> layout = new ArrayList<>();

    public Grid(String inputLayout) {
        // Adds three rows to the grid
        for (int time = 0; time < 3; time++) {
            this.layout.add(new ArrayList<String>());
        }

        for (int rowIndex = 0; rowIndex < 3; rowIndex++) {
            this.layout.get(0).add(String.valueOf(inputLayout.charAt(rowIndex)));
        }

        for (int rowIndex = 3; rowIndex < 6; rowIndex++) {
            this.layout.get(1).add(String.valueOf(inputLayout.charAt(rowIndex)));
        }

        for (int rowIndex = 6; rowIndex < 9; rowIndex++) {
            this.layout.get(2).add(String.valueOf(inputLayout.charAt(rowIndex)));
        }
    }

    public Grid(ArrayList<ArrayList<String>> inputLayout){
        this.layout = inputLayout;
    }

    public ArrayList<ArrayList<String>> getLayout() {
        return layout;
    }

    public String getLayoutPrint(){
        String output = "";
        for(ArrayList<String> row : this.layout){
            output += row.toString() + "\n";
        }
        return output;
    }

}
