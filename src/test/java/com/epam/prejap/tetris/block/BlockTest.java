package com.epam.prejap.tetris.block;

import com.epam.prejap.tetris.block.blocks.BlockForTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * Each test from this class will be performed for each Block type provided in the {@link BlockTestFactory}.
 *
 * @author Nika Avramchuk
 * @see BlockTestFactory
 */
@Test(groups = "Block")
public class BlockTest {
    private final Block childBlock;
    private final BlockForTest blockForTest;


    public BlockTest(Block childBlock, BlockForTest blockForTest) {
        this.childBlock = childBlock;
        this.blockForTest = blockForTest;
    }

    @Test
    public void shouldCreateBlockWithProperDimensions() {
        //given
        int expectedRows = blockForTest.rows();
        int expectedColumns = blockForTest.cols();

        //when
        int actualRows = childBlock.rows;
        int actualColumns = childBlock.cols;

        //then
        assertEquals(actualRows, expectedRows, String.format("The expected number of rows for %s should be %d, but was %d%n", childBlock.getClass().getSimpleName(), expectedRows, actualRows));
        assertEquals(actualColumns, expectedColumns, String.format("The expected number of columns for %s should be %d, but was %d", childBlock.getClass().getSimpleName(), expectedColumns, actualColumns));
    }

    @Test(dataProvider = "blockPoints", dependsOnMethods = "testDataProviders")
    public void shouldCreateBlockWithProperDots(int row, int col, int expectedValue) {
        //when
        byte actualValue = childBlock.dotAt(row, col);

        //then
        assertEquals(actualValue, expectedValue, String.format("Should created %s with correct shaped dots, but did not", childBlock.getClass().getSimpleName()));
    }


    @DataProvider()
    public Object[] blockPoints() {
        return blockForTest.getCoordinates();
    }

    @Test()
    public void testDataProviders() {
        //given
        int expectedValue = blockForTest.cols()*blockForTest.rows();

        //when
        int actualValue = blockForTest.getCoordinates().length;

        //then
        assertEquals(actualValue, expectedValue, String.format("Should created %s with correct array of points, but did not", blockForTest.getClass().getSimpleName()));
    }



}
