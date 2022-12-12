package dev.usbharu.commons.illust.parser.impl.other.pixiv.exception;

import dev.usbharu.commons.illust.common.exception.ParseMetadataException;

public class PixivMetadataParseException extends ParseMetadataException {

  private static final String FAILED_PARSE_MESSAGE = "Pixiv Metafileの解析に失敗しました。";

  public PixivMetadataParseException() {
    super();
  }

  public PixivMetadataParseException(String message) {
    super(FAILED_PARSE_MESSAGE + message);
  }

  public PixivMetadataParseException(String message, Throwable cause) {
    super(FAILED_PARSE_MESSAGE + message, cause);
  }

  public PixivMetadataParseException(Throwable cause) {
    super(cause);
  }

  protected PixivMetadataParseException(String message, Throwable cause, boolean enableSuppression,
      boolean writableStackTrace) {
    super(FAILED_PARSE_MESSAGE + message, cause, enableSuppression, writableStackTrace);
  }
}
