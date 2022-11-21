package dev.usbharu.commons.illust.parser;

import dev.usbharu.commons.illust.common.IllustSource;

public abstract class IllustParserFactory {

  public abstract IllustParser from(IllustSource illustSource);
}
