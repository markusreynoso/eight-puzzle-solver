public class Main {
    public static void main(String[] args) {
        Grid grid = new Grid("12 345678");
        Solver solver = new Solver();
        System.out.println(grid.getLayoutPrint());
        solver.slideTile(grid, "r");
        System.out.println(grid.getLayoutPrint());
        solver.slideTile(grid, "r");
        System.out.println(grid.getLayoutPrint());
        solver.slideTile(grid, "u");
        System.out.println(grid.getLayoutPrint());
    }
}