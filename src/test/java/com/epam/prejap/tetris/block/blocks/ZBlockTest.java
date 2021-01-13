package com.epam.prejap.tetris.block.blocks;

/**
 * Z-shaped block implementation of the {@link BlockForTest} abstraction class.

 * @implNote This class implements static 2d array which stores information about ZBlock coordinates (1 and 2 columns) and
 * the required value of the variable in these coordinates (3 column).
 *
 * @author Nika Avramchuk
 * @see BlockForTest
 */
public class ZBlockTest extends BlockForTest {
    private static final int rows = 2;
    private static final int cols = 3;

    private static final Object[][] blockCoordinates = {
            {0, 0, 1},
            {0, 1, 1},
            {0, 2, 0},
            {1, 0, 0},
            {1, 1, 1},
            {1, 2, 1},
    };

    public ZBlockTest() {
        super(blockCoordinates, rows, cols);
    }

}
