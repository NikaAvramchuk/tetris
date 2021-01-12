package com.epam.prejap.tetris.block;

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
    private final Object[][] dotsInBlock;
    private Object[][] emptySpacesInBlock;


    public BlockTest(Block childBlock, Object[][] dotsInBlock, Object[][] emptySpacesInBlock) {
        this.childBlock = childBlock;
        this.dotsInBlock = dotsInBlock;
        this.emptySpacesInBlock = emptySpacesInBlock;
    }

    @Test
    public void shouldCreateBlockWithProperDimensions() {
        //given
        byte[][] expectedImage = childBlock.image;

        //when
        int actualRows = childBlock.rows;
        int actualColumns = childBlock.cols;

        //then
        assertEquals(actualRows, expectedImage.length, String.format("The expected number of rows for %s should be %d, but was %d%n", childBlock.getClass().getSimpleName(), expectedImage.length, actualRows));
        assertEquals(actualColumns, expectedImage[0].length, String.format("The expected number of columns for %s should be %d, but was %d", childBlock.getClass().getSimpleName(), expectedImage[0].length, actualColumns));
    }

    @Test(dataProvider = "dotsInBlock")
    public void shouldCreateBlockWithProperDots(int row, int col) {
        //given
        byte expectedValue = 1;

        //when
        byte actualValue = childBlock.dotAt(row, col);

        //then
        assertEquals(actualValue, expectedValue, String.format("Should created %s with correct shaped dots, but did not", childBlock.getClass().getSimpleName()));
    }

    @Test(dataProvider = "emptySpacesInBlock")
    public void shallCreateLBlockWithCorrectEmptySpaces(int row, int col) {
        if(!(row==-1 && col==-1)) {
            //given
            int emptyMark = 0;

            //when
            byte actualEmptySpace = childBlock.dotAt(row, col);

            //then
            assertEquals(actualEmptySpace, emptyMark, String.format("Should created %s with correct empty spaces, but did not", childBlock.getClass().getSimpleName()));
        }
    }


    @DataProvider()
    public Object[] dotsInBlock() {
        return dotsInBlock;
    }

    @DataProvider()
    public Object[] emptySpacesInBlock() {
        return emptySpacesInBlock;
    }

}
