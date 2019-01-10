package Lev16.Task1631ready;

import Lev16.Task1631ready.common.*;

public class ImageReaderFactory {

  public static ImageReader getImageReader(Enum<ImageTypes> imageTypes) {
    String s = String.valueOf(imageTypes);
    switch (s) {
      case "JPG":
        ImageReader reader = new JpgReader();
        return reader;
      case "BMP":
        ImageReader reader1 = new BmpReader();
        return reader1;
      case "PNG":
        ImageReader reader2 = new PngReader();
        return reader2;
      default:
        throw new IllegalArgumentException();
    }

  }

}
