package com.epam.prejap.tetris.block;

import org.testng.annotations.Factory;

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

        static final Object [][] emptySpacesInOBlock = new Object[][]{
                {-1, -1}
        };
    }

    private static class ZBlockTest {
        static final Object [][] dotsInZBlock = new Object[][]{
                {0, 0},
                {0, 1},
                {1, 1},
                {1, 2},
        };

        static final Object [][] emptySpacesInZBlock = new Object[][]{
                {0, 2},
                {1, 0},
        };

    }

    private static class LBlockTest {
        static final Object [][] dotsInLBlock = new Object[][]{
                {0, 0},
                {1, 0},
                {2, 0},
                {2, 1},
        };

        static final Object [][] emptySpacesInLBlock = new Object[][]{
                {0, 1},
                {1, 1},
        };

    }

    private static class IBlockTest {
        static final Object [][] dotsInIBlock = new Object[][]{
                {0, 0},
                {1, 0},
                {2, 0},
                {3, 0},
        };

        static final Object [][] emptySpacesInIBlock = new Object[][]{
                {-1, -1}
        };

    }


}

