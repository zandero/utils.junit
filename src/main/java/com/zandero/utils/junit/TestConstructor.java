package com.zandero.utils.junit;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

/**
 *
 */
public final class TestConstructor {

	private TestConstructor() {
		// hide
	}

	public static <T> void isPrivate(Class<T> clazz) {

		try {
			Constructor<T> constructor = clazz.getDeclaredConstructor();
			//constructor.

			assertTrue(Modifier.isPrivate(constructor.getModifiers()));
			constructor.setAccessible(true);
			constructor.newInstance();
		}
		catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException | InstantiationException e) {
			throw new AssertionError(e.getMessage());
		}
	}
}
