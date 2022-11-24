package dev.usbharu.commons.illust.parser.impl.other.pixiv;

import dev.usbharu.commons.illust.common.IllustSource;
import dev.usbharu.commons.illust.metadata.AbstractIllust;
import dev.usbharu.commons.illust.metadata.Illust;
import dev.usbharu.commons.illust.metadata.Metadata;
import dev.usbharu.commons.illust.metadata.MetadataValue;
import dev.usbharu.commons.illust.parser.IllustParser;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UncheckedIOException;
import java.util.ArrayList;
import java.util.List;
import org.jetbrains.annotations.NotNull;

public class PowerfulPixivDownloaderMetafileParser extends IllustParser {

  @Override
  public @NotNull Illust parse(IllustSource illustSource) {
    try (BufferedReader bufferedReader = new BufferedReader(
        new InputStreamReader(illustSource.getInputStream()))) {
      String line;
      List<MetadataValue> metadataValues = new ArrayList<>();
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
    return new OnlyMetadataIllust(null);
  }

  protected List<? extends MetadataValue> switchType(PowerfulPixivDownloaderMetadataType type,
      BufferedReader bufferedReader) {
    try {
      switch (type) {
        case ID:
          return id(bufferedReader);
        case TITLE:
          break;
        case USER:
          break;
        case USER_ID:
          break;
        case URL:
          break;
        case TAGS:
          break;
        case Date:
          break;
        case DESCRIPTION:
          break;
      }
    } catch (IOException e) {
      throw new UncheckedIOException(e);
    }
    throw new IllegalArgumentException(type.type);
  }

  private List<PixivIllustId> id(BufferedReader bufferedReader) throws IOException {

    String line = bufferedReader.readLine();
    ArrayList<PixivIllustId> result = new ArrayList<>();

    result.add(new PixivIllustId(Integer.parseInt(line)));
    return result;
  }

  private enum PowerfulPixivDownloaderMetadataType {
    ID("ID"),
    TITLE("Title"),
    USER("User"),
    USER_ID("UserId"),
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
