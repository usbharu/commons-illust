package dev.usbharu.commons.illust;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import dev.usbharu.commons.illust.metadata.Illust;
import dev.usbharu.commons.illust.metadata.Metadata;
import dev.usbharu.commons.illust.metadata.MetadataValue;
import dev.usbharu.commons.illust.metadata.Tag;
import java.io.File;
import java.util.Collections;
import java.util.stream.Stream;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class IllustOperationTest {

  @ParameterizedTest
  @ValueSource(strings = {"metadata/123456_p1.png", "metadata/987654321_p1.jpg",
      "metadata/Konako.jpg"})
  void getIllustWithStringPath_correctFullPath_returnIllust(String path) {
    Illust illust = IllustOperation.getIllust(getFile(path).getPath());
    assertNotNull(illust);
  }

  @ParameterizedTest
  @ValueSource(strings = {"V2v7", "wreck", "bell", "behavior"})
  void getIllustWithStringPath_invalidFullPath_throwIllegalArgumentException(String invalidPath) {
    assertThrows(IllegalArgumentException.class, () -> IllustOperation.getIllust(invalidPath));
  }

  @ParameterizedTest
  @ValueSource(strings = {"metadata/123456_p1.png", "metadata/987654321_p1.jpg"})
  void getIllustWithStringPath_correctResourcePath_returnIllust(String path) {
    Illust illust = IllustOperation.getIllust(path);
    assertNotNull(illust);
  }

  @ParameterizedTest
  @ValueSource(strings = {"V2v7", "wreck", "bell", "behavior"})
  void getIllustWithStringPath_invalidResourcePath_throwIllegalArgumentException(
      String invalidPath) {
    assertThrows(IllegalArgumentException.class, () -> IllustOperation.getIllust(invalidPath));
  }

  @ParameterizedTest
  @ValueSource(strings = {"metadata/123456_p1.png", "metadata/987654321_p1.jpg",
      "metadata/Konako.jpg"})
  void getIllustWithFile_correctPath_returnIllust(String filePath) {
    Illust illust = IllustOperation.getIllust(getFile(filePath));
    assertNotNull(illust);
  }

  @ParameterizedTest
  @ValueSource(strings = {"turn", "struggle", "bone", "educator"})
  void getIllustWithFile_invalidPath_throwIllegalArgumentException(String invalidPath) {
    assertThrows(IllegalArgumentException.class,
        () -> IllustOperation.getIllust(new File(invalidPath)));
  }

  @ParameterizedTest
  @MethodSource("getMetadataByTypeWithIllust_type_returnMetadata_Source")
  void getMetadataByTypeWithIllust_type_returnMetadata(Illust illust,
      Class<? extends MetadataValue> type, int expectedCount) {
    int metadataByType = IllustOperation.getMetadataByType(illust, type).size();
    assertEquals(expectedCount, metadataByType);
  }

  private static Stream<Arguments> getMetadataByTypeWithIllust_type_returnMetadata_Source() {
    return Stream.of(
        arguments((Illust) () -> (Metadata) () -> Collections.singletonList(new Tag() {
          @Override
          public @NotNull String getStringValue() {
            return "english";
          }

          @Override
          public @NotNull String getValue() {
            return "english";
          }
        }), Tag.class, 1)
    );
  }

  @ParameterizedTest
  @MethodSource("getMetadataByTypeWithMetadata_type_returnMetadata_Source")
  void getMetadataByTypeWithMetadata_type_returnMetadata(Metadata metadata,
      Class<? extends MetadataValue> type, int expectedCount) {
    int size = IllustOperation.getMetadataByType(metadata, type).size();
    assertEquals(expectedCount, size);
  }

  private static Stream<Arguments> getMetadataByTypeWithMetadata_type_returnMetadata_Source() {
    return Stream.of(
        arguments((Metadata) () -> Collections.singletonList(new Tag() {
          @Override
          public @NotNull String getStringValue() {
            return "english";
          }

          @Override
          public @NotNull String getValue() {
            return "english";
          }
        }), Tag.class, 1)
    );
  }

  private File getFile(String resourcePath) {
    return new File(IllustOperation.class.getClassLoader().getResource(resourcePath).getFile());
  }
}
