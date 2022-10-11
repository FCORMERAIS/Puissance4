package main.java.puissance4.project;

public class App {
    public static void main(String[] args) throws Exception {   
        int number = 3;   
        Grid grid = new Grid(number);
        if (number == 3) {
            while(!Verify.Win(grid.grille)) {
                Display.printGrid(grid.grille);
                Display.chooseWherePlayX(grid.grille);
                Display.printGrid(grid.grille);
                Display.chooseWherePlayV(grid.grille);
                Display.printGrid(grid.grille);
                Display.chooseWherePlayO(grid.grille);
            }   
        }else {
            while(!Verify.Win(grid.grille)) {
                Display.printGrid(grid.grille);
                Display.chooseWherePlayX(grid.grille);
                Display.printGrid(grid.grille);
                Display.chooseWherePlayO(grid.grille);
            }
        }
    }
}
