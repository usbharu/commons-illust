package dev.usbharu.commons.illust.parser.impl.other.pixiv;

import dev.usbharu.commons.illust.common.IllustSource;
import dev.usbharu.commons.illust.metadata.AbstractIllust;
import dev.usbharu.commons.illust.metadata.Illust;
import dev.usbharu.commons.illust.metadata.Metadata;
import dev.usbharu.commons.illust.metadata.MetadataValue;
import dev.usbharu.commons.illust.parser.IllustParser;
import dev.usbharu.commons.illust.parser.impl.other.pixiv.exception.PixivMetadataMalformedURLException;
import dev.usbharu.commons.illust.parser.impl.other.pixiv.exception.PixivMetadataNumberFormatException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UncheckedIOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import org.jetbrains.annotations.NotNull;

public class PowerfulPixivDownloaderMetafileParser extends IllustParser {

  @Override
  public @NotNull Illust parse(IllustSource illustSource) {
    List<MetadataValue> metadataValues = null;
    try (BufferedReader bufferedReader = new BufferedReader(
        new InputStreamReader(illustSource.getInputStream()))) {
      String line;
      metadataValues = new ArrayList<>();
      while ((line = bufferedReader.readLine()) != null) {
        if (PowerfulPixivDownloaderMetadataType.containsType(line)) {
          metadataValues.addAll(
              switchType(PowerfulPixivDownloaderMetadataType.typeOf(line), bufferedReader));
        }
      }
      // TODO: 2022/11/23 while の場所移動、最初から使う
    } catch (IOException e) {
      e.printStackTrace();
    }
    List<MetadataValue> finalMetadataValues = metadataValues;
    return new OnlyMetadataIllust(() -> finalMetadataValues);
  }

  protected List<? extends MetadataValue> switchType(PowerfulPixivDownloaderMetadataType type,
      BufferedReader bufferedReader) {
    try {
      switch (type) {
        case ID:
          return id(bufferedReader);
        case TITLE:
          return title(bufferedReader);
        case USER:
          return user(bufferedReader);
        case URL:
          return url(bufferedReader);
        case TAGS:
          return tag(bufferedReader);
        case Date:
          return date(bufferedReader);
        case DESCRIPTION:
          return description(bufferedReader);
      }
    } catch (IOException e) {
      throw new UncheckedIOException(e);
    }
    throw new IllegalArgumentException(type.type);
  }

  private List<PixivIllustDescription> description(BufferedReader bufferedReader)
      throws IOException {
    String line = "";
    List<PixivIllustDescription> result = new ArrayList<>();
    StringBuilder stringBuilder = new StringBuilder();
    while ((line = bufferedReader.readLine()) != null) {
      stringBuilder.append(line);
    }
    result.add(new PixivIllustDescription(stringBuilder.toString()));
    return result;
  }

  private List<PixivIllustUploadDate> date(BufferedReader bufferedReader) throws IOException {
    String date = bufferedReader.readLine();
    List<PixivIllustUploadDate> result = new ArrayList<>();
    result.add(new PixivIllustUploadDate(date));
    return result;
  }

  private List<PixivIllustUrl> url(BufferedReader bufferedReader) throws IOException {
    List<PixivIllustUrl> result = new ArrayList<>();
    URL url;
    try {
      url = new URL(bufferedReader.readLine());
    } catch (MalformedURLException e) {
      throw new PixivMetadataMalformedURLException("URLが不正です。", e);
    }
    result.add(new PixivIllustUrl(url));
    return result;
  }

  private List<PixivArtist> user(BufferedReader bufferedReader) throws IOException {
    String screenName = bufferedReader.readLine();
    bufferedReader.readLine(); //一行スキップ
    bufferedReader.readLine(); //もう一行スキップ
    long id;
    try {
      id = Long.parseLong(bufferedReader.readLine());
    } catch (NumberFormatException e) {
      throw new PixivMetadataNumberFormatException("UserIdが数字ではありません。", e);
    }
    List<PixivArtist> result = new ArrayList<>();
    result.add(new PixivArtist(screenName, id));
    return result;
  }

  private List<PixivIllustTitle> title(BufferedReader bufferedReader) throws IOException {
    String line = bufferedReader.readLine();
    List<PixivIllustTitle> pixivIllustTitles = new ArrayList<>();
    pixivIllustTitles.add(new PixivIllustTitle(line));
    return pixivIllustTitles;
  }

  private List<PixivIllustId> id(BufferedReader bufferedReader) throws IOException {

    String line = bufferedReader.readLine();
    List<PixivIllustId> result = new ArrayList<>();

    result.add(new PixivIllustId(Integer.parseInt(line)));
    return result;
  }

  private List<PixivIllustTag> tag(BufferedReader bufferedReader) throws IOException {
    String line = "";
    List<PixivIllustTag> list = new ArrayList<>();
    while (!(line = bufferedReader.readLine()).isEmpty()) {
      if (line.startsWith("#")) {
        line = line.substring(1);
      }
      list.add(new PixivIllustTag(line));
    }
    return list;
  }

  private enum PowerfulPixivDownloaderMetadataType {
    ID("ID"),
    TITLE("Title"),
    USER("User"),
    URL("URL"),
    TAGS("Tags"),
    Date("Date"),
    DESCRIPTION("Description");
    private final String type;

    PowerfulPixivDownloaderMetadataType(String type) {
      this.type = type;
    }

    public static boolean containsType(String type) {
      return typeOfOrNull(type) != null;
    }

    public static PowerfulPixivDownloaderMetadataType typeOf(String type) {
      PowerfulPixivDownloaderMetadataType typeOrNull = typeOfOrNull(type);
      if (typeOrNull == null) {
        throw new IllegalArgumentException("Invalid type: " + type);
      }
      return typeOrNull;
    }

    public static PowerfulPixivDownloaderMetadataType typeOfOrNull(String type) {
      for (PowerfulPixivDownloaderMetadataType value : values()) {
        if (value.type.equals(type)) {
          return value;
        }
      }
      return null;
    }
  }

  public static class OnlyMetadataIllust extends AbstractIllust {

    public OnlyMetadataIllust(Metadata metadata) {
      super(metadata);
    }
  }
}
