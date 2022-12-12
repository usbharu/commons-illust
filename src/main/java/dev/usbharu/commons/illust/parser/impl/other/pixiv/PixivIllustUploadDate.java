package dev.usbharu.commons.illust.parser.impl.other.pixiv;

import dev.usbharu.commons.illust.metadata.Date;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import org.jetbrains.annotations.NotNull;

public class PixivIllustUploadDate implements Date {

  public static final DateTimeFormatter FORMATTER = DateTimeFormatter.ISO_OFFSET_DATE_TIME;
  private final ZonedDateTime zonedDateTime;

  public PixivIllustUploadDate(ZonedDateTime zonedDateTime) {
    this.zonedDateTime = zonedDateTime;
  }

  public PixivIllustUploadDate(String date) {
    this.zonedDateTime = ZonedDateTime.parse(date, FORMATTER);
  }

  @Override
  public @NotNull ZonedDateTime getValue() {
    return zonedDateTime;
  }

  @Override
  public @NotNull ZonedDateTime getDateValue() {
    return zonedDateTime;
  }
}
