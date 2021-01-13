package com.epam.prejap.tetris.block;

import com.epam.prejap.tetris.block.blocks.*;
import com.epam.prejap.tetris.block.blocks.SBlockTest;
import org.testng.annotations.Factory;

/**
 * In order to avoid duplications, this class provides {@link BlockTest} with concrete subclasses of the {@link Block} class.
 * This means that each method in {@link BlockTest} will check each of the {@link Block} subclasses.
 *
 * In order to add tests for another implementation of {@link Block}, you need to
 * 1) create YourBlockTest that extends {@link BlockForTest} in com.epam.prejap.tetris.block/
 * 2) add new instance of BlockTest to {@link #factoryMethod()} as in example below:
 *      {@code new BlockTest(<new_block_subclass>, <new_block_test_subclass>)}
 *
 * @author Nika Avramchuk
 * @see BlockTest
 */
public class BlockTestFactory {

    @Factory()
    public Object[] factoryMethod() {
        return new Object[]{
                new BlockTest(new OBlock(), new OBlockTest()),
                new BlockTest(new IBlock(), new IBlockTest()),
                new BlockTest(new LBlock(), new LBlockTest()),
                new BlockTest(new ZBlock(), new ZBlockTest()),
                new BlockTest(new JBlock(), new JBlockTest()),
                new BlockTest(new SBlock(), new SBlockTest())
        };
    }







}

