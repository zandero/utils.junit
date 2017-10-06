package com.zandero.utils.junit;

import com.zandero.utils.test.MethodNotStatic;
import com.zandero.utils.test.MultipleContructors;
import com.zandero.utils.test.NotFinal;
import com.zandero.utils.test.NotPrivate;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

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
		}
		catch (AssertionError e) {
			assertEquals("Constructor of 'class com.zandero.utils.test.NotPrivate' is not private!", e.getMessage());
		}
	}

	@Test
	public void testNotFinal() {

		try {
			AssertFinalClass.isWellDefined(NotFinal.class);
			fail();
		}
		catch (AssertionError e) {
			assertEquals("Class 'class com.zandero.utils.test.NotFinal' not final!", e.getMessage());
		}
	}

	@Test
	public void testMultipleContructors() {

		try {
			AssertFinalClass.isWellDefined(MultipleContructors.class);
			fail();
		}
		catch (AssertionError e) {
			assertEquals("Class 'class com.zandero.utils.test.MultipleContructors' must have only one constructor!", e.getMessage());
		}
	}

	@Test
	public void testMethodNotStatic() {

		try {
			AssertFinalClass.isWellDefined(MethodNotStatic.class);
			fail();
		}
		catch (AssertionError e) {
			assertEquals("Method 'public int com.zandero.utils.test.MethodNotStatic.test()' in " +
					"'class com.zandero.utils.test.MethodNotStatic' is not static!", e.getMessage());
		}
	}
}