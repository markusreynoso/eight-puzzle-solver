public class Main {
    public static void main(String[] args) {
        Solver solver = new Solver();

        // ToDo: Change this value to the desired tile layout denoting the blank tile with a space. For example, 1234 5678 is read as
        // [1,2,3]
        // [4, ,5]
        // [6,7,8]
        String layout = "1234 5678";

        Grid grid = new Grid(layout);

        System.out.println("Given layout: ");
        System.out.println(grid.getLayoutPrint());

        System.out.println("BFS with pruning:");
        System.out.println(solver.solvePuzzleBfs(grid));
        System.out.print("\n");
        System.out.println("Greedy Best First Search:");
        System.out.println(solver.solvePuzzleGBFS(grid));
    }
}
