
public class App {
    public static void main(String[] args) throws Exception {      
        Grid grid = new Grid(3);
        while(!Verify.Win()) {
            Display.printGrid(grid.grille);
            Display.chooseWherePlayX(grid.grille);
            Display.printGrid(grid.grille);
            Display.chooseWherePlayV(grid.grille);
            Display.printGrid(grid.grille);
            Display.chooseWherePlayO(grid.grille);
        }   
    }
}
