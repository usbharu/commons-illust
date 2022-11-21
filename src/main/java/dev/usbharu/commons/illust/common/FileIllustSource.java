package dev.usbharu.commons.illust.common;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import org.jetbrains.annotations.NotNull;

public class FileIllustSource extends IllustSource {

  private final File illust;

  public FileIllustSource(@NotNull File illust) {
    super(illust.getName());
    this.illust = illust;
  }

  @Override
  public InputStream getInputStream() throws IOException {
    return new BufferedInputStream(Files.newInputStream(illust.toPath()));
  }
}
