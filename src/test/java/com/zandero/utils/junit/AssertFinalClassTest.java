package com.zandero.utils.junit;

import com.zandero.utils.test.*;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 *
 */
public class AssertFinalClassTest {

    @Test
    public void testItSelf() {

        AssertFinalClass.isWellDefined(AssertFinalClass.class);
    }

    @Test
    public void testNotPrivate() {

        try {
            AssertFinalClass.isWellDefined(NotPrivate.class);
            fail();
        } catch (AssertionError e) {
            assertEquals("Constructor of 'class com.zandero.utils.test.NotPrivate' must be private! " +
                             "==> expected: <true> but was: <false>", e.getMessage());
        }
    }

    @Test
    public void testNotPrivateTwo() {

        try {
            AssertFinalClass.isWellDefined(NotPrivateTwo.class);
            fail();
        } catch (AssertionError e) {
            assertEquals("Constructor of 'class com.zandero.utils.test.NotPrivateTwo' must be private! " +
                             "==> expected: <true> but was: <false>", e.getMessage());
        }
    }

    @Test
    public void testNotFinal() {

        try {
            AssertFinalClass.isWellDefined(NotFinal.class);
            fail();
        } catch (AssertionError e) {
            assertEquals("Class 'class com.zandero.utils.test.NotFinal' not final! " +
                             "==> expected: <true> but was: <false>", e.getMessage());
        }
    }

    @Test
    public void testMultipleConstructors() {

        try {
            AssertFinalClass.isWellDefined(MultipleContructors.class);
            fail();
        } catch (AssertionError e) {
            assertEquals("Class 'class com.zandero.utils.test.MultipleContructors' must have only one constructor! " +
                             "==> expected: <1> but was: <2>", e.getMessage());
        }
    }

    @Test
    public void testMethodNotStatic() {

        try {
            AssertFinalClass.isWellDefined(MethodNotStatic.class);
            fail();
        } catch (AssertionError e) {
            assertEquals("Method 'public int com.zandero.utils.test.MethodNotStatic.test()' in " +
                             "'class com.zandero.utils.test.MethodNotStatic' is not static! " +
                             "==> expected: <true> but was: <false>", e.getMessage());
        }
    }
}