package Lev8;

import java.io.IOException;
import java.util.List;

/*
1. Ввести с клавиатуры число N.
2. Считать N целых чисел и заполнить ими список - метод getIntegerList.
3. Найти минимальное число среди элементов списка - метод getMinimum.


Требования:
1. Программа должна выводить текст на экран.
2. Программа должна считывать значения с клавиатуры.
3. Класс Solution должен содержать только три метода.
4. Метод getIntegerList() должен считать с клавиатуры число N, потом вернуть список размером N элементов, заполненный числами с клавиатуры.
5. Метод getMinimum() должен вернуть минимальное число среди элементов списка.
6. Метод main() должен вызывать метод getIntegerList().
7. Метод main() должен вызывать метод getMinimum().
 */
public class Task0822 {
  public static void main(String[] args) throws Exception {
    List<Integer> integerList = getIntegerList();
    System.out.println(getMinimum(integerList));
  }

  public static int getMinimum(List<Integer> array) {
    // find minimum here — найти минимум тут
    return 0;
  }

  public static List<Integer> getIntegerList() throws IOException {
    //create and initialize a list here - создать и заполнить список тут
    return null;
  }
}
