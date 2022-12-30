package dev.usbharu.commons.illust.util;

import java.awt.Dimension;
import java.awt.Image;

public class ImageScalar {

  private ImageScalar() {
  }


  /**
   * アスペクト比を保持したまま縮小します。
   *
   * @param dimension1 縮小する前のサイズ
   * @param dimension2 縮小するサイズ
   * @return 縮小されたサイズ
   */
  public static Dimension aspectRatioKeepScale(Dimension dimension1, Dimension dimension2) {
    int originalWidth = dimension1.width;
    int originalHeight = dimension1.height;
    int boundWidth = dimension2.width;
    int boundHeight = dimension2.height;
    int newWidth = originalWidth;
    int newHeight = originalHeight;

    if (originalWidth > boundWidth) {
      newWidth = boundWidth;
      newHeight = (newWidth * originalHeight) / originalWidth;
    }

    if (newHeight > boundHeight) {
      newHeight = boundHeight;
      newWidth = (newHeight * originalWidth) / originalHeight;
    }

    return new Dimension(newWidth, newHeight);
  }

  /**
   * アスペクト比を維持したまま画像を縮小します。
   *
   * @param image  縮小する{@code Image}
   * @param bounds 最大サイズ
   * @return 縮小された <code>Image</code>
   */
  public static Image aspectRatioKeepScaledImage(Image image, Dimension bounds) {
    Dimension dimension =
        aspectRatioKeepScale(new Dimension(image.getWidth(null), image.getHeight(null)), bounds);
    return image.getScaledInstance(dimension.width, dimension.height, Image.SCALE_SMOOTH);
  }
}
