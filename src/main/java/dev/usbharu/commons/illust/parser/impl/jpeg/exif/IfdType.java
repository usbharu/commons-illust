package dev.usbharu.commons.illust.parser.impl.jpeg.exif;

public enum IfdType {
  BYTE("BYTE", 0x01, 1),
  ASCII("ASCII", 0x02, 1),
  SHORT("SHORT", 0x03, 2),
  LONG("LONG", 0x04, 3),
  RATIONAL("RATIONAL", 0x05, 8),
  SBYTE("SBYTE", 0x06, 1),
  UNDEFINED("UNDEFINED", 0x07, 1),
  SSHORT("SSHORT", 0x08, 2),
  SLONG("SLONG", 0x09, 4),
  SRATIONAL("SRATIONAL", 0x0a, 8),
  FLOAT("FLOAT", 0x0b, 4),
  DFLOAT("DFLOAT", 0x0c, 8);

  final String typeName;
  final int type;
  final int length;

  IfdType(String typeName, int type, int length) {
    this.typeName = typeName;
    this.type = type;
    this.length = length;
  }

  public static IfdType typeOf(int type) {
    for (IfdType value : values()) {
      if (value.type == type) {
        return value;
      }
    }
    throw new IllegalArgumentException("Invalid Type: " + type);
  }

  public String getTypeName() {
    return typeName;
  }

  public int getType() {
    return type;
  }

  public int getLength() {
    return length;
  }
}
