package dev.usbharu.commons.illust.parser.impl.other.pixiv;

import dev.usbharu.commons.illust.metadata.Source;
import java.net.MalformedURLException;
import java.net.URL;
import org.jetbrains.annotations.NotNull;

public class PixivIllustUrl implements Source {

  private final URL url;

  public PixivIllustUrl(URL url) {
    this.url = url;
  }

  public PixivIllustUrl(String urlStr) throws MalformedURLException {
    this.url = new URL(urlStr);
  }

  @Override
  public @NotNull URL getValue() {
    return url;
  }

  @Override
  public @NotNull String getStringValue() {
    return url.toString();
  }
}
