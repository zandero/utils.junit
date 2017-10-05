package com.zandero.utils.junit;

import com.zandero.utils.test.Dummy;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 *
 */
public class TestConstructorTest {

	@Test
	public void testItSelf() {

		TestConstructor.isPrivate(TestConstructor.class);
	}

	@Test
	public void testDummy() {

		TestConstructor.isPrivate(Dummy.class);
	}
}