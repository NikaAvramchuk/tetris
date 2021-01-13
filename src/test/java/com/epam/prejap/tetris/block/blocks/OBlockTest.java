package com.epam.prejap.tetris.block.blocks;

/**
 * O-shaped block implementation of the {@link BlockForTest} abstraction class.

 * @implNote This class implements static 2d array which stores information about OBlock coordinates (1 and 2 columns) and
 * the required value of the variable at these coordinates (3 column).
 *
 * @author Nika Avramchuk
 * @see BlockForTest
 */
public class OBlockTest extends BlockForTest {
    private static final int rows = 2;
    private static final int cols = 2;

    private static final Object[][] blockCoordinates = {
            {0, 0, 1},
            {0, 1, 1},
            {1, 0, 1},
            {1, 1, 1},
    };

    public OBlockTest() {
        super(blockCoordinates, rows, cols);
    }
}
