package dev.usbharu.commons.illust.common;

public class ArrayUtil {

  private ArrayUtil() {
    throw new IllegalStateException();
  }

  public static boolean equals(byte[] a,
      int aFromIndex,
      int aToIndex,
      byte[] b,
      int bFromIndex,
      int bToIndex) {
    if (aFromIndex < 0 || aFromIndex > a.length) {
      throw new ArrayIndexOutOfBoundsException("aFromIndex");
    }
    if (aToIndex > a.length || aToIndex < 0) {
      throw new ArrayIndexOutOfBoundsException("aToIndex");
    }
    if (bFromIndex < 0 || bFromIndex > a.length) {
      throw new ArrayIndexOutOfBoundsException("bFromIndex");
    }
    if (bToIndex > b.length || bToIndex < 0) {
      throw new ArrayIndexOutOfBoundsException("bToIndex");
    }
    int aLength = aToIndex - aFromIndex;
    int bLength = bToIndex - bFromIndex;
    if (aLength != bLength) {
      return false;
    }
    for (int i = 0; i < aLength; i++) {
      if (a[i + aFromIndex] != b[i + bFromIndex]) {
        return false;
      }
    }
    return true;
  }

  public static boolean startWith(byte[] a, byte[] b) {
    return equals(a, 0, a.length, b, 0, a.length);
  }

}
