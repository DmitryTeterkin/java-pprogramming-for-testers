package Lev13;

import java.io.*;
import java.util.ArrayList;

/*
Чтение файла
1. Считать с консоли имя файла.
2. Вывести в консоль(на экран) содержимое файла.
3. Не забыть освободить ресурсы. Закрыть поток чтения с файла и поток ввода с клавиатуры.


Требования:
1. Программа должна считывать c консоли имя файла.
2. Программа должна выводить на экран содержимое файла.
3. Поток чтения из файла (FileInputStream) должен быть закрыт.
4. BufferedReader также должен быть закрыт.
 */
public class Task1318done {
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    String filepath = reader.readLine();
    reader.close();
    InputStream inStream = new FileInputStream(filepath);
    while (inStream.available() > 0) {
      int data = inStream.read(); //читаем один байт из потока для чтения
      char lit = (char) data; // преобразуем его в char (прокатывает только для английских букв)
      CharFromFile.write(lit); //записываем в лист
    }
    inStream.close();
     while(CharFromFile.available() > 0){
       System.out.print(CharFromFile.read());
     }

  }

  public static class CharFromFile
    {
      private static ArrayList<Character> list = new ArrayList<>();
      public static void write(char lit)
      {
        list.add(lit);
      }
    public static char read()
      {
        char first = list.get(0);
        list.remove(0);
        return first;
      }

      public static int available()
      {
        return list.size();
      }
  }
}

