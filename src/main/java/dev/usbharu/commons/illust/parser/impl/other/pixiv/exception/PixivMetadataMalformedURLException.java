package dev.usbharu.commons.illust.parser.impl.other.pixiv.exception;

public class PixivMetadataMalformedURLException extends PixivMetadataParseException {

  public PixivMetadataMalformedURLException() {
  }

  public PixivMetadataMalformedURLException(String message) {
    super(message);
  }

  public PixivMetadataMalformedURLException(String message, Throwable cause) {
    super(message, cause);
  }

  public PixivMetadataMalformedURLException(Throwable cause) {
    super(cause);
  }

  protected PixivMetadataMalformedURLException(String message, Throwable cause,
      boolean enableSuppression, boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }
}
