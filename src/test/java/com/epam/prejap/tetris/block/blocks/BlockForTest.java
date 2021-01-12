package com.epam.prejap.tetris.block.blocks;

import java.util.ArrayList;
import java.util.List;

public class BlockForTest {
    final Object[] dotsInIBlock;
    final Object[] emptySpacesInIBlock;
    final byte[][] image;

    public BlockForTest(byte[][] image) {
        this.image = image;
        dotsInIBlock = getArrayWithDotsOrEmptySpaces(1, image);
        emptySpacesInIBlock = getArrayWithDotsOrEmptySpaces(0, image);
    }

    private Object[] getArrayWithDotsOrEmptySpaces(int value, byte[][] image) {
        List<Object[]> listOfFoundValueRepetitions = new ArrayList<>();
        for (int i = 0; i < image.length; i++) {
            for (int j = 0; j < image[i].length; j++) {
                if (image[i][j] == value)
                    listOfFoundValueRepetitions.add(new Object[]{i, j});
            }
        }
        return listOfFoundValueRepetitions.toArray(new Object[listOfFoundValueRepetitions.size()][]);
    }

    public Object[] dots() {
        return dotsInIBlock;
    }

    public Object[] emptySpaces() {
        return emptySpacesInIBlock;
    }

    public byte[][] getImage () {
        return image;
    }
}

