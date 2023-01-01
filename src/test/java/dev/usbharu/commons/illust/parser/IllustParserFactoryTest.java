package dev.usbharu.commons.illust.parser;

import static org.junit.jupiter.api.Assertions.*;

abstract class IllustParserFactoryTest {

  abstract void from_IllustSource_returnIllustParser();

  abstract void from_null_returnNull();
}
