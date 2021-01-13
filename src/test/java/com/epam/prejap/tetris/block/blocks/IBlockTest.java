package com.epam.prejap.tetris.block.blocks;

import com.epam.prejap.tetris.block.Block;

/**
 * I-shaped block implementation of the {@link BlockForTest} abstraction class.

 * @implNote This class implements static 2d array which stores information about IBlock coordinates (1 and 2 columns) and
 * the required value of the variable at these coordinates (3 column).
 *
 * @author Nika Avramchuk
 * @see BlockForTest
 */
public class IBlockTest extends BlockForTest {
    private static final int rows = 4;
    private static final int cols = 1;

    private static final Object[][] blockCoordinates = {
            {0, 0, 1},
            {1, 0, 1},
            {2, 0, 1},
            {3, 0, 1},
    };

    public IBlockTest() {
        super(blockCoordinates, rows, cols);
    }

}
