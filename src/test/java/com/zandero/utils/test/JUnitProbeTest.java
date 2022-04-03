package com.zandero.utils.test;

import com.zandero.utils.junit.*;
import org.junit.jupiter.api.*;

import static com.zandero.utils.junit.AssertFinalClass.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

class JUnitProbeTest {

    @Test
    void testDefinition() {
        isWellDefined(JUnitProbe.class);
    }

    @Test
    void isRunningTest() {
        assertTrue(JUnitProbe.isUnitTest());
    }
}