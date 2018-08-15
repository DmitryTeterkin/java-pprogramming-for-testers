package Lev13;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;

/*
Сортировка четных чисел из файла
1. Ввести имя файла с консоли.
2. Прочитать из него набор чисел.
3. Вывести на консоль только четные, отсортированные по возрастанию.

Пример ввода:
5
8
-2
11
3
-5
2
10

Пример вывода:
-2
2
8
10


Требования:
1. Программа должна считывать данные с консоли.
2. Программа должна создавать FileInputStream для введенной с консоли строки.
3. Программа должна выводить данные на экран.
4. Программа должна вывести на экран все четные числа считанные из файла отсортированные по возрастанию.
5. Программа должна закрывать поток чтения из файла(FileInputStream).
 */
public class Task1326ready {
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    String filepath = reader.readLine(); // читаем имя файла из строки в консоли.
   // reader.close(); // закрываем поток чтения имени файла

    FileInputStream inStream = new FileInputStream(filepath); // открываем поток для чтения из файла
    // создаем BufferedReader для построчного чтения из файла
    BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filepath), StandardCharsets.UTF_8));
    ArrayList<Integer> list = new ArrayList<>();// объявляем ArrayList с типом Integer для хранения четных чисел.
    try {
      String line; // объявляем String, для записи строк из файла
      while ((line = br.readLine()) != null) { // считываем строку из файла в String, и проверяем на конец файла.
        int data = Integer.decode(line);  // декодируем String в Integer.
        if (data % 2 == 0) { // проверяем, четный ли Integer.
          list.add(data); // добавляем четный в list.
        }
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    inStream.close(); // закрываем поток чтения.

    Collections.sort(list); // сортируем получившийся list по возрастанию. Обратная сортировка Collection.reverse(list)

    for (int i = 0; i < list.size(); i++) {
      System.out.println(list.get(i)); // выводим list на печать.
    }
  }
}
