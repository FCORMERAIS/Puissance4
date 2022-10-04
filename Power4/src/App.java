
public class App {
    public static void main(String[] args) throws Exception {      
        Grid grid = new Grid();
        while(true) {
            Display.printGrid(grid.grille);
            Display.chooseWherePlayX(grid.grille);
            Display.printGrid(grid.grille);
            Display.chooseWherePlayV(grid.grille);
            Display.printGrid(grid.grille);
            Display.chooseWherePlayO(grid.grille);
        }   
    }
}
