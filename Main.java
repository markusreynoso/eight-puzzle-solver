import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Grid demoGrid = new Grid("123 45678");
        Scanner sc = new Scanner(System.in);
        Solver solver = new Solver();
        String layout = "";

        System.out.println("Input the layout with a space to denote the blank tile. For example, 123 45678 is read as:");
        System.out.println(demoGrid.getLayoutPrint());;

        System.out.print("Layout: ");
        layout = sc.nextLine();
        Grid grid = new Grid(layout);

        System.out.println(grid.getLayoutPrint());
        System.out.println("BFS:");
        System.out.println(solver.solvePuzzleBfs(grid));
        System.out.println("A-Star:");
        System.out.println(solver.solvePuzzleAStar(grid));
    }
}