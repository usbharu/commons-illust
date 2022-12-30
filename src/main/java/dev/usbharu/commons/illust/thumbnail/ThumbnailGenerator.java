package dev.usbharu.commons.illust.thumbnail;

import dev.usbharu.commons.illust.common.IllustSource;
import dev.usbharu.commons.illust.util.ImageScalar;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Iterator;
import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;

public class ThumbnailGenerator {

  public BufferedImage generate(IllustSource illustSource, int width, int height) {
    String fileName = illustSource.getFileName();
    Iterator<ImageReader> imageReaders =
        ImageIO.getImageReadersByFormatName(fileName.substring(fileName.lastIndexOf(".") + 1));
    while (imageReaders.hasNext()) {
      ImageReader imageReader = imageReaders.next();

      try {
        try (ImageInputStream inputStream = ImageIO.createImageInputStream(
            illustSource.getInputStream())) {
          imageReader.setInput(inputStream, false, true);
          ImageReadParam defaultReadParam = imageReader.getDefaultReadParam();

          int originalWidth = imageReader.getWidth(0);
          int originalHeight = imageReader.getHeight(0);

          Dimension dimension2 = new Dimension(width, height);
          Dimension aspectRatioKeepScale =
              ImageScalar.aspectRatioKeepScale(new Dimension(originalWidth, originalHeight),
                  dimension2);
          int xSubSampling = originalWidth / aspectRatioKeepScale.width;
          int ySubSampling = originalHeight / aspectRatioKeepScale.height;

          defaultReadParam.setSourceSubsampling(xSubSampling, ySubSampling, xSubSampling >> 1,
              ySubSampling >> 1);

          BufferedImage read = imageReader.read(0, defaultReadParam);
          BufferedImage thumbnailImage =
              new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
          Graphics graphics = thumbnailImage.getGraphics();
          graphics.drawImage(read, (width - aspectRatioKeepScale.width) / 2,
              (height - aspectRatioKeepScale.height) / 2, null);
          graphics.dispose();
          return thumbnailImage;
        } catch (IOException e) {
          e.printStackTrace();
        }
      } finally {
        imageReader.dispose();
      }
    }
    return null;
  }

}
