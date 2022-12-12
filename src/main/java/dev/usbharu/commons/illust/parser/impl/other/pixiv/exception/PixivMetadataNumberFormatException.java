package dev.usbharu.commons.illust.parser.impl.other.pixiv.exception;

public class PixivMetadataNumberFormatException
    extends PixivMetadataParseException {

  public PixivMetadataNumberFormatException() {
  }

  public PixivMetadataNumberFormatException(String message) {
    super(message);
  }

  public PixivMetadataNumberFormatException(String message, Throwable cause) {
    super(message, cause);
  }

  public PixivMetadataNumberFormatException(Throwable cause) {
    super(cause);
  }

  protected PixivMetadataNumberFormatException(String message, Throwable cause,
      boolean enableSuppression, boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }
}
