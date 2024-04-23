public class Main {
    public static void main(String[] args) {
        Grid grid = new Grid("12 345678");
        Solver solver = new Solver();
        System.out.println(solver.computeHeuristic(grid));
    }
}