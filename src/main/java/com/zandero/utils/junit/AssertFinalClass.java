package com.zandero.utils.junit;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import static org.junit.Assert.assertTrue;

/**
 *
 */
public final class AssertFinalClass {

	private AssertFinalClass() {
		// hide
	}

	public static <T> void isWellDefined(Class<T> clazz) {

		try {
			Constructor<T> constructor = clazz.getDeclaredConstructor();

			assertTrue(String.format("Class '%s' not final!", clazz),
			           Modifier.isFinal(clazz.getModifiers()));

			assertTrue(String.format("Class '%s' must have only one constructor!", clazz),
			             1 == clazz.getDeclaredConstructors().length);

			assertTrue(String.format("Constructor of '%s' must be private!", clazz),
			           !constructor.isAccessible() && !Modifier.isPrivate(clazz.getModifiers()));

			constructor.setAccessible(true);
			constructor.newInstance();
			constructor.setAccessible(false);

			checkMethodsAreStatic(clazz);
		}
		catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException | InstantiationException e) {

			throw new AssertionError(String.format("Constructor of '%s' is not private!", clazz), e);
		}
	}

	private static <T> void checkMethodsAreStatic(Class<T> clazz) {

		Method[] methods = clazz.getMethods();

		for (Method method : methods) {

			assertTrue(String.format("Method '%s' in '%s' is not static!", method, clazz),
			           Modifier.isStatic(method.getModifiers()) || !method.getDeclaringClass().equals(clazz));
		}
	}
}
