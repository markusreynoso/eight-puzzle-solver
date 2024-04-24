public class Main {
    public static void main(String[] args) {
        Grid grid = new Grid("58761324 ");
        Solver solver = new Solver();
        System.out.println(grid.getLayoutPrint());
        System.out.println(solver.solvePuzzleBfs(grid));
    }
}