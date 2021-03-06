import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class SolverTest extends BaseTest {

    @Test
    void testTrivialSolver() {
        checkTrivialBoard(TRIVIAL_ONE);
        checkTrivialBoard(TRIVIAL_TWO);
        checkTrivialBoard(TRIVIAL_THREE);
        checkTrivialBoard(TRIVIAL_FOUR);
    }

    @Test
    void testIsSolvable() {
        Solver solver = new Solver(getBoard(THREE, 1, 2, 3, 4, 5, 6, 7, 0, 8));
        assertTrue(solver.isSolvable());
        assertEquals(1, solver.moves());

        solver = new Solver(getBoard(THREE, 0, 1, 3, 4, 2, 5, 7, 8, 6));
        assertTrue(solver.isSolvable());
        assertEquals(4, solver.moves());
        for (Board board : solver.solution()) {
            System.out.println(board);
        }
    }

    @Test
    void testIsNotSolvable() {
        Solver solver = new Solver(getBoard(THREE, 1, 2, 3, 4, 5, 6, 8, 7, 0));
        assertFalse(solver.isSolvable());
        assertEquals(-1, solver.moves());
    }

    //C:\Dropbox\Sources\algorithmsPartI\Week04\src\test\resources\8puzzle\puzzle17.txt

    private void checkTrivialBoard(Board trivialBoard) {
        Solver solver = new Solver(trivialBoard);
        assertTrue(solver.isSolvable());
        assertEquals(0, solver.moves());
        assertEquals(trivialBoard, solver.solution().iterator().next());
    }
}