package Lev8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/*
1. Ввести с клавиатуры число N.
2. Считать N целых чисел и заполнить ими список - метод getIntegerList.
3. Найти минимальное число среди элементов списка - метод getMinimum.


Требования:
1. Программа должна выводить текст на экран.
2. Программа должна считывать значения с клавиатуры.
3. Класс Task0925done должен содержать только три метода.
4. Метод getIntegerList() должен считать с клавиатуры число N, потом вернуть список размером N элементов,
заполненный числами с клавиатуры.
5. Метод getMinimum() должен вернуть минимальное число среди элементов списка.
6. Метод main() должен вызывать метод getIntegerList().
7. Метод main() должен вызывать метод getMinimum().


 Сделано!!!!

 */
public class Task0822done {
  public static void main(String[] args) throws Exception {
    List<Integer> integerList = getIntegerList();
    System.out.println(getMinimum(integerList));
  }

  public static int getMinimum(List<Integer> array) {
    int min = Integer.MAX_VALUE;// find minimum here — найти минимум тут
    for (int i = 0; i < array.size(); i++) {
      if (array.get(i) < min){
        min = array.get(i);
      }
    }
    return min;
  }

  public static List<Integer> getIntegerList() throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    List<Integer> list = new ArrayList<Integer>();
    int count = Integer.parseInt(reader.readLine());
    if (count>0){
      for (int i = 0; i < count; i++) {
        list.add(i, Integer.parseInt(reader.readLine()));
      }
    }
   return list;
  }
}
