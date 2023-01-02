package dev.usbharu.commons.illust.common;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;


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
      assertThat(e.getCause()).isInstanceOf(IllegalStateException.class);
    } catch (InstantiationException | IllegalAccessException e) {
      throw new RuntimeException(e);
    }
  }

  @ParameterizedTest
  @MethodSource("equals_indexes_InRangeAndTheSameValue_returnTrue_Source")
  void equals_indexesInRangeAndTheSameValue_returnTrue(byte[] a,
      int aFromIndex,
      int aToIndex,
      byte[] b,
      int bFromIndex,
      int bToIndex) {
    assertTrue(ArrayUtil.equals(a, aFromIndex, aToIndex, b, bFromIndex, bToIndex));
  }


  static Stream<Arguments> equals_indexes_InRangeAndTheSameValue_returnTrue_Source() {
    return Stream.of(
        arguments(
            createByteArrayFromIntArray(808, 800, 890, 238, 913, 749), 0, 3,
            createByteArrayFromIntArray(808, 800, 890, 691, 581, 444), 0, 3),
        arguments(createByteArrayFromIntArray(659, 427, 953, 863, 310, 490, 309, 952), 3, 6,
            createByteArrayFromIntArray(478, 652, 863, 310, 490), 2, 5)
    );
  }

  @ParameterizedTest
  @MethodSource
  void equals_indexesInRangeAndTheDifferentValue_returnFalse(byte[] a,
      int aFromIndex,
      int aToIndex,
      byte[] b,
      int bFromIndex,
      int bToIndex) {
    assertFalse(ArrayUtil.equals(a, aFromIndex, aToIndex, b, bFromIndex, bToIndex));
  }

  private static byte[] createByteArrayFromIntArray(int... array) {
    byte[] bytes = new byte[array.length];
    for (int i = 0; i < array.length; i++) {
      bytes[i] = (byte) array[i];
    }
    return bytes;
  }
}
