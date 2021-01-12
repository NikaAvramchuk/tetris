package com.epam.prejap.tetris.block;

import org.testng.annotations.Factory;

/**
 * In order to avoid duplications, this class provides {@link BlockTest} with concrete subclasses of the {@link Block} class.
 * This means that each method in {@link BlockTest} will check each of the {@link Block} subclasses.
 *
 * In order to add tests for another implementation of {@link Block}, you need to add new instance
 * of BlockTest to {@link #factoryMethod()} as in example below:
 *      {@code new BlockTest(<new_block_subclass>)}
 *
 * @author Nika Avramchuk
 * @see BlockTest
 */
public class BlockTestFactory {

    @Factory()
    public Object[] factoryMethod() {
        return new Object[]{
                new BlockTest(new OBlock()),
                new BlockTest(new IBlock()),
                new BlockTest(new LBlock()),
                new BlockTest(new ZBlock()),
                new BlockTest(new JBlock())
        };
    }




}

