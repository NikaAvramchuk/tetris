package com.epam.prejap.tetris.block;

import org.testng.annotations.Factory;

/**
 * In order to avoid duplication, this class provides {@link BlockTest} with concrete subclasses of the {@link Block} class.
 * This means that each method in {@link BlockTest} will check each of the {@link Block} subclasses.
 *
 * @implNote {@link OBlock} and {@link IBlock} don`t have any empty point in theirs IMAGEs, to which the value 0 is assigned, so values -1 were added to emptySpacesInThisBlock variable.
 *
 * In order to add tests for another implementation of {@link Block}, you need to:
 * 1) create inner class inside {@link BlockTestFactory};
 * 2) create variable dotsInThisBlock ("This" replace with the name of your Block) that will refer to a two-dimensional table.
 * This table should store the coordinates of each point of the corresponding block's IMAGE, which the value 1 is assigned;
 * 3) create variable emptySpacesInThisBlock ("This" replace with the name of your Block) that will also refer to a two-dimensional table.
 * This table will store the coordinates of each point of the corresponding block's IMAGE, to which the value 0 is assigned;
 * 4) add new instance of BlockTest to {@link #factoryMethod()} as in example below:
 *      {@code new BlockTest(<new_block_subclass>, <ThisBlockTest.dotsInBlock>, <ThisBlockTest.emptySpacesInBlock>)}
 *
 * @author Nika Avramchuk
 * @see BlockTest
 *
 */
public class BlockTestFactory {

    @Factory()
    public Object[] factoryMethod() {
        return new Object[]{
                new BlockTest(new OBlock(), OBlockTest.dotsInOBlock, OBlockTest.emptySpacesInOBlock),
                new BlockTest(new IBlock(), IBlockTest.dotsInIBlock, IBlockTest.emptySpacesInIBlock),
                new BlockTest(new LBlock(), LBlockTest.dotsInLBlock, LBlockTest.emptySpacesInLBlock),
                new BlockTest(new ZBlock(), ZBlockTest.dotsInZBlock, ZBlockTest.emptySpacesInZBlock),
        };
    }

    private static class OBlockTest {
        private static final Object [][] dotsInOBlock = new Object[][] {
                {0, 0},
                {0, 1},
                {1, 0},
                {1, 1},
        };

        private static final Object [][] emptySpacesInOBlock = new Object[][]{
                {-1, -1}
        };
    }

    private static class ZBlockTest {
        private static final Object [][] dotsInZBlock = new Object[][]{
                {0, 0},
                {0, 1},
                {1, 1},
                {1, 2},
        };

        private static final Object [][] emptySpacesInZBlock = new Object[][]{
                {0, 2},
                {1, 0},
        };

    }

    private static class LBlockTest {
        private static final Object [][] dotsInLBlock = new Object[][]{
                {0, 0},
                {1, 0},
                {2, 0},
                {2, 1},
        };

        private static final Object [][] emptySpacesInLBlock = new Object[][]{
                {0, 1},
                {1, 1},
        };

    }

    private static class IBlockTest {
        private static final Object [][] dotsInIBlock = new Object[][]{
                {0, 0},
                {1, 0},
                {2, 0},
                {3, 0},
        };

        private static final Object [][] emptySpacesInIBlock = new Object[][]{
                {-1, -1}
        };

    }


}

