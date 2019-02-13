package Lev16.Task1631ready;

import Lev16.Task1631ready.common.ImageReader;
import Lev16.Task1631ready.common.ImageTypes;

/*
Factory method pattern
1. Внимательно посмотри, какие классы у тебя есть.
2. В отдельных файлах в пакете common создай классы JpgReader, PngReader, BmpReader, которые реализуют интерфейс ImageReader.
3. В отдельном файле в основном пакете создай класс ImageReaderFactory с одним методом.
3.1. Подумай, как он должен называться.
3.2. Подумай, какие модификаторы должны быть у этого метода.
4. Этот метод должен:
4.1. Для каждого значения из ImageTypes возвращать соответствующий Reader, например, для ImageTypes.JPG - JpgReader;
4.2. Если передан неправильный параметр, то выбрасывать исключение IllegalArgumentException("Неизвестный тип картинки").


Требования:
1. Создай в пакете common класс JpgReader, реализующий интерфейс ImageReader.
2. Создай в пакете common класс PngReader, реализующий интерфейс ImageReader.
3. Создай в пакете common класс BmpReader, реализующий интерфейс ImageReader.
4. Создай публичный класс ImageReaderFactory.
5. Добавь в класс ImageReaderFactory открытый статический метод getImageReader с параметром ImageTypes.
6. Метод getImageReader должен создавать и возвращать подходящий Reader.
7. Метод getImageReader должен кидать исключение IllegalArgumentException, если передан неправильный параметр.

 переделать на ифы

 */
public class Task1631ready {
  public static void main(String[] args) {
    ImageReader reader = ImageReaderFactory.getImageReader(null);
    ImageReader reader1 = ImageReaderFactory.getImageReader(ImageTypes.JPG);
    ImageReader reader2 = ImageReaderFactory.getImageReader(ImageTypes.BMP);
  }

}
