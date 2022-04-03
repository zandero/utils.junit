package com.zandero.utils.junit;

import java.lang.reflect.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 *
 */
public final class AssertFinalClass {

    private AssertFinalClass() {
        // hide
    }

    public static <T> void isWellDefined(Class<T> clazz) {

        try {
            Constructor<?>[] constructors = clazz.getDeclaredConstructors();

            for (Constructor<?> constructor : constructors) {
                assertTrue(Modifier.isFinal(clazz.getModifiers()),
                           String.format("Class '%s' not final!", clazz));

				assertTrue(Modifier.isPrivate(constructor.getModifiers()),
						   String.format("Constructor of '%s' must be private!", clazz));

				assertEquals(1, clazz.getDeclaredConstructors().length,
                             String.format("Class '%s' must have only one constructor!", clazz));


                constructor.setAccessible(true);
                constructor.newInstance();
                constructor.setAccessible(false);

                checkMethodsAreStatic(clazz);
            }
        } catch (IllegalAccessException | InvocationTargetException | InstantiationException e) {

            throw new AssertionError(String.format("Constructor of '%s' is not private!", clazz), e);
        }
    }

    private static <T> void checkMethodsAreStatic(Class<T> clazz) {

        Method[] methods = clazz.getMethods();

        for (Method method : methods) {

            assertTrue(Modifier.isStatic(method.getModifiers()) || !method.getDeclaringClass().equals(clazz),
                       String.format("Method '%s' in '%s' is not static!", method, clazz));
        }
    }
}
