package dev.usbharu.commons.illust.common;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import org.junit.jupiter.api.Test;


class ArrayUtilTest {

  @Test
  void constructor_new_throwIllegalStateException()
      throws ClassNotFoundException {
    Class<?> arrayUtil = Class.forName("dev.usbharu.commons.illust.common.ArrayUtil");
    Constructor<?>[] declaredConstructors = arrayUtil.getDeclaredConstructors();
    declaredConstructors[0].setAccessible(true);
    try {
      declaredConstructors[0].newInstance();
    } catch (InvocationTargetException e) {
      Throwable cause = e.getCause();
      System.out.println("cause = " + cause);
      assertTrue(cause instanceof IllegalStateException);
    } catch (InstantiationException | IllegalAccessException e) {
      throw new RuntimeException(e);
    }
  }
}
