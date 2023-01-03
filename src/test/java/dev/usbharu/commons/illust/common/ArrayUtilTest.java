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
  void constructor_new_throwIllegalStateException() throws ClassNotFoundException {
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
  void equals_indexesInRangeAndTheSameValue_returnTrue(byte[] a, int aFromIndex, int aToIndex,
      byte[] b, int bFromIndex, int bToIndex) {
    assertTrue(ArrayUtil.equals(a, aFromIndex, aToIndex, b, bFromIndex, bToIndex));
  }


  static Stream<Arguments> equals_indexes_InRangeAndTheSameValue_returnTrue_Source() {
    return Stream.of(arguments(createByteArrayFromIntArray(808, 800, 890, 238, 913, 749), 0, 3,
            createByteArrayFromIntArray(808, 800, 890, 691, 581, 444), 0, 3),
        arguments(createByteArrayFromIntArray(659, 427, 953, 863, 310, 490, 309, 952), 3, 6,
            createByteArrayFromIntArray(478, 652, 863, 310, 490), 2, 5));
  }

  @ParameterizedTest
  @MethodSource
  void equals_indexesInRangeAndTheDifferentValue_returnFalse(byte[] a, int aFromIndex, int aToIndex,
      byte[] b, int bFromIndex, int bToIndex) {
    assertFalse(ArrayUtil.equals(a, aFromIndex, aToIndex, b, bFromIndex, bToIndex));
  }

  public static Stream<Arguments> equals_indexesInRangeAndTheDifferentValue_returnFalse() {
    return Stream.of(arguments(createByteArrayFromIntArray(59, 463, 457, 408, 991, 955, 422), 2, 6,
            createByteArrayFromIntArray(667, 784, 178, 987, 500, 433, 736, 359), 1, 5),
        arguments(createByteArrayFromIntArray(393, 620, 859, 882, 713, 574, 620), 1, 4,
            createByteArrayFromIntArray(268, 378, 526, 430, 436, 390, 818, 118, 472), 3, 6));
  }

  @ParameterizedTest
  @MethodSource
  void equals_indexesOutRange_throwArrayIndexOutOfBoundsException(byte[] a, int aFromIndex,
      int aToIndex, byte[] b, int bFromIndex, int bToIndex) {
    assertThrows(ArrayIndexOutOfBoundsException.class,
        () -> ArrayUtil.equals(a, aFromIndex, aToIndex, b, bFromIndex, bToIndex));
  }

  public static Stream<Arguments> equals_indexesOutRange_throwArrayIndexOutOfBoundsException() {
    return Stream.of(arguments(createByteArrayFromIntArray(792, 744, 652), -1, 1,
            createByteArrayFromIntArray(254, 716, 770), 1, 2),
        arguments(createByteArrayFromIntArray(152, 374, 837), 100, 2,
            createByteArrayFromIntArray(706, 814, 811), 1, 2),
        arguments(createByteArrayFromIntArray(759, 60), 0, -2,
            createByteArrayFromIntArray(755, 233, 437, 791), 1, 3),
        arguments(createByteArrayFromIntArray(448, 89), 0, 100,
            createByteArrayFromIntArray(406, 822), 0, 2),
        arguments(createByteArrayFromIntArray(620, 610, 670, 225), 0, 3,
            createByteArrayFromIntArray(903, 812, 484), -4, 9),
        arguments(createByteArrayFromIntArray(295, 41, 403, 567), 0, 3,
            createByteArrayFromIntArray(232, 330, 958, 537), 200, 3),
        arguments(createByteArrayFromIntArray(852, 515, 157, 439, 993), 1, 3,
            createByteArrayFromIntArray(829, 9, 591, 269, 210), 0, -5),
        arguments(createByteArrayFromIntArray(888, 704, 946, 697, 60), 1, 2,
            createByteArrayFromIntArray(479, 808, 75, 595, 350, 561), 0, 400));
  }

  private static byte[] createByteArrayFromIntArray(int... array) {
    byte[] bytes = new byte[array.length];
    for (int i = 0; i < array.length; i++) {
      bytes[i] = (byte) array[i];
    }
    return bytes;
  }

  @ParameterizedTest
  @MethodSource
  void startWith_startWith_returnTrue(byte[] a, byte[] b) {
    assertTrue(ArrayUtil.startWith(a, b));
  }

  public static Stream<Arguments> startWith_startWith_returnTrue() {
    return Stream.of(
        arguments(createByteArrayFromIntArray(490, 277, 561, 182, 411),
            createByteArrayFromIntArray(490, 277, 561, 182, 411, 26, 569, 130, 707, 555)),
        arguments(createByteArrayFromIntArray(60, 363, 281, 165, 468, 971),
            createByteArrayFromIntArray(60, 363, 281, 165, 468, 971)),
        arguments(createByteArrayFromIntArray(), createByteArrayFromIntArray())
    );
  }
}
