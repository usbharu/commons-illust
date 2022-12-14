package dev.usbharu.commons.illust.common;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import org.jetbrains.annotations.NotNull;

public class FileIllustSource extends IllustSource {

  private final File illust;
  private final BufferedInputStream inputStream;

  public FileIllustSource(@NotNull File illust) throws IOException {
    super(illust.getName());
    this.illust = illust;
    inputStream = new BufferedInputStream(Files.newInputStream(illust.toPath()));
  }

  @Override
  public InputStream getInputStream() throws IOException {
    return inputStream;
  }

  public File getFile() {
    return illust;
  }
}
