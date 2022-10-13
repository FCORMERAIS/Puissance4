package puissance4.project;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class VerifyTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @Test
    public void testEgality() {
        Grid grid = new Grid(3);
        for (int i = 0; i < grid.grille.get(0).size(); i++) {
            grid.grille.get(0).set(i, "X");
        }
        assertTrue(Verify.Egality(grid.grille));
        grid.grille.get(0).set(0, " ");
        assertFalse(Verify.Egality(grid.grille));
    }

    @Test
    public void tesstVerify() {
        Grid grid = new Grid(3);
        grid.grille.get(0).set(0, "X");
        grid.grille.get(0).set(1, "X");
        grid.grille.get(0).set(2, "X");
        grid.grille.get(0).set(3, "X");
        assertTrue(Verify.Win(grid.grille));
    }
    @Test
    public void tesstVerify2() {
        Grid grid = new Grid(3);
        grid.grille.get(0).set(0, "X");
        grid.grille.get(1).set(0, "X");
        grid.grille.get(2).set(0, "X");
        grid.grille.get(3).set(0, "X");
        assertTrue(Verify.Win(grid.grille));
    }
    @Test
    public void tesstVerify3() {
        Grid grid = new Grid(3);
        grid.grille.get(0).set(0, "X");
        grid.grille.get(1).set(1, "X");
        grid.grille.get(2).set(2, "X");
        grid.grille.get(3).set(3, "X");
        assertTrue(Verify.Win(grid.grille));
    }
    @Test
    public void tesstVerify4() {
        Grid grid = new Grid(3);
        assertFalse(Verify.Win(grid.grille));
    }
    @Test
    public void tesstVerify5() {
        Grid grid = new Grid(3);
        grid.grille.get(3).set(0, "X");
        grid.grille.get(2).set(1, "X");
        grid.grille.get(1).set(2, "X");
        grid.grille.get(0).set(3, "X");
        assertTrue(Verify.Win(grid.grille));
    }



}
