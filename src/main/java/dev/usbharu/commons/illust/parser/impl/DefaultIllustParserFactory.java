package dev.usbharu.commons.illust.parser.impl;

import dev.usbharu.commons.illust.common.ArrayUtil;
import dev.usbharu.commons.illust.common.FileIllustSource;
import dev.usbharu.commons.illust.common.IllustSource;
import dev.usbharu.commons.illust.metadata.Illust;
import dev.usbharu.commons.illust.metadata.Metadata;
import dev.usbharu.commons.illust.parser.IllustParser;
import dev.usbharu.commons.illust.parser.IllustParserFactory;
import dev.usbharu.commons.illust.parser.impl.jpeg.JpegIllustParser;
import dev.usbharu.commons.illust.parser.impl.jpeg.xmp.XmpParser;
import dev.usbharu.commons.illust.parser.impl.other.multi.MultiParser;
import dev.usbharu.commons.illust.parser.impl.other.pixiv.PowerfulPixivDownloaderMetafileParser;
import dev.usbharu.commons.illust.util.PixivUtil;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.jetbrains.annotations.NotNull;

public class DefaultIllustParserFactory extends IllustParserFactory {

  public static final byte[] JPEG = {(byte) 0xff, (byte) 0xd8};


  @Override
  public IllustParser from(IllustSource illustSource) {
    if (hasOtherFile(illustSource)) {
      IllustParser illustParser = otherCheck(illustSource);
      if (illustParser != null) {
        return new MultiParser(new PowerfulPixivDownloaderMetafileParser(), illustParser);
      } else {
        return new PowerfulPixivDownloaderMetafileParser();
      }
    }
    throw new IllegalArgumentException();
  }

  private IllustParser otherCheck(IllustSource illustSource) {
    try {
      if (jpegCheck(illustSource)) {
        return new JpegIllustParser();
      }
    } catch (IOException e) {
      return null;
    }
    return null;
  }

  private boolean hasOtherFile(IllustSource illustSource) {
    if (illustSource instanceof FileIllustSource) {
      File file = ((FileIllustSource) illustSource).getFile().getParentFile().getAbsoluteFile();
      Path resolve = file.toPath()
          .resolve(PixivUtil.getPixivIllustId(illustSource.getFileName()) + "-meta.txt");
      return Files.exists(resolve);
    }
    return false;
  }

  private boolean jpegCheck(IllustSource illustSource) throws IOException {
    InputStream inputStream = illustSource.getInputStream();
    byte[] formatCHeck = new byte[4];
    inputStream.read(formatCHeck);
    boolean result = ArrayUtil.startWith(JPEG, formatCHeck);
    inputStream.reset();
    return result;
  }
}
