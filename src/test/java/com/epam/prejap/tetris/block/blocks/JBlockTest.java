package com.epam.prejap.tetris.block.blocks;

/**
 * J-shaped block implementation of the {@link BlockForTest} abstraction class.

 * @implNote This class implements static 2d array which stores information about JBlock coordinates (1 and 2 columns) and
 * the required value of the variable at these coordinates (3 column).
 *
 * @author Nika Avramchuk
 * @see BlockForTest
 */
public class JBlockTest extends BlockForTest{
    private static final int rows = 3;
    private static final int cols = 2;

    private static final Object[][] blockCoordinates = {
            {0, 0, 0},
            {0, 1, 1},
            {1, 0, 0},
            {1, 1, 1},
            {2, 0, 1},
            {2, 1, 1},
    };

    public JBlockTest() {
        super(blockCoordinates, rows, cols);
    }
}
