package com.epam.prejap.tetris.block;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

/**
 * Each test from this class will be performed for each Block type provided in the {@link BlockTestFactory}.
 *
 * @author Nika Avramchuk
 * @see BlockTestFactory
 */
@Test(groups = "Block")
public class BlockTest {
    private final Block childBlock;
    private final Block newInstanceOfChildBlockClass;

    private final int emptyMark = 0;
    private final int dot = 1;

    public BlockTest(Block childBlock) {
        this.childBlock = childBlock;
        newInstanceOfChildBlockClass=createNewInstance();
    }

    @Test
    public void shouldCreateBlockWithProperDimensions() {
        //given
        byte[][] expectedImage = newInstanceOfChildBlockClass.image;

        //when
        int actualRows = childBlock.rows;
        int actualColumns = childBlock.cols;

        //then
        assertEquals(actualRows, expectedImage.length, String.format("The expected number of rows for %s should be %d, but was %d%n", childBlock.getClass().getSimpleName(), expectedImage.length, actualRows));
        assertEquals(actualColumns, expectedImage[0].length, String.format("The expected number of columns for %s should be %d, but was %d", childBlock.getClass().getSimpleName(), expectedImage[0].length, actualColumns));
    }

    @Test()
    public void testBlockShape() {
        //given
        byte[][] expectedImage = newInstanceOfChildBlockClass.image;
        //when
        byte[][] actualImage = childBlock.image;;
        //then
        assertEquals(actualImage, expectedImage, String.format("Should created %s with the correct shape, but did not", childBlock.getClass().getSimpleName()));
    }

    @Test(dataProvider = "dotsInBlock")
    public void shouldCreateBlockWithProperDots(int row, int col) {
        //when
        byte actualValue = childBlock.dotAt(row, col);

        //then
        assertEquals(actualValue, dot, String.format("Should created %s with correct shaped dots, but did not", childBlock.getClass().getSimpleName()));
    }

    @Test(dataProvider = "emptySpacesInBlock")
    public void shallCreateLBlockWithCorrectEmptySpaces(int row, int col) {
        //when
        byte actualEmptySpace = childBlock.dotAt(row, col);

        //then
        assertEquals(actualEmptySpace, emptyMark, String.format("Should created %s with correct empty spaces, but did not", childBlock.getClass().getSimpleName()));
    }


    @DataProvider()
    public Object[] dotsInBlock() {
        return getArrayWithDotsOrEmptySpaces(dot);
    }

    @DataProvider()
    public Object[] emptySpacesInBlock() {
        return getArrayWithDotsOrEmptySpaces(emptyMark);
    }


    /**
     * This method loops inside {@link Block#image} and looking for dots or empty spaces depends on @param
     * @param value sought value: could be {@link BlockTest#dot} or {@link BlockTest#emptyMark}: 1 or 2
     * @return a two-dimensional table consisting of the coordinates (row and column) of each found value repetitions
     */
    private Object[] getArrayWithDotsOrEmptySpaces(int value) {
        List<Object[]> listOfFoundValueRepetitions = new ArrayList<>();
        for (int i = 0; i < newInstanceOfChildBlockClass.image.length; i++) {
            for (int j = 0; j < newInstanceOfChildBlockClass.image[i].length; j++) {
                if (newInstanceOfChildBlockClass.image[i][j] == value)
                    listOfFoundValueRepetitions.add(new Object[]{i, j});
            }
        }
        return listOfFoundValueRepetitions.toArray(new Object[listOfFoundValueRepetitions.size()][]);
    }

    /**
     * This method creates new instance of Block`s subclasses depends on {@link BlockTest#childBlock} in order
     * to use it in testing blocks.
     *
     * @return new {@link Block subclass}
     */
    private Block createNewInstance () {
        Block newInstance = null;
        try {
            Constructor<? extends Block> declaredConstructor = childBlock.getClass().getDeclaredConstructor();
            newInstance = declaredConstructor.newInstance();
        } catch (NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
            System.err.println(e.getMessage());
        }
        return newInstance;
    }

    @Test (dataProvider = "newInstancesOfGivenClass")
    public void shouldCreateNewInstanceOfGivenClass (Block expected) {
        Block actual = createNewInstance();
        assertNotEquals(actual,expected, String.format("Should created new instance of %s, but did not", childBlock.getClass().getSimpleName()));
    }

    @DataProvider()
    public Object[] newInstancesOfGivenClass() {
        return new Block[]{
                createNewInstance(),
                createNewInstance(),
                createNewInstance()
        };
    }

}
