package dev.usbharu.commons.illust.common.exception;

public class ParseMetadataException extends RuntimeException {

  public ParseMetadataException() {
    super();
  }

  public ParseMetadataException(String message) {
    super(message);
  }

  public ParseMetadataException(String message, Throwable cause) {
    super(message, cause);
  }

  public ParseMetadataException(Throwable cause) {
    super(cause);
  }

  protected ParseMetadataException(String message, Throwable cause, boolean enableSuppression,
      boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }
}
