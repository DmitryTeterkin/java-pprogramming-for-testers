package Lev13;

import java.io.*;
import java.util.ArrayList;

/*
Писатель в файл с консоли
1. Прочесть с консоли имя файла.
2. Считывать строки с консоли, пока пользователь не введет строку "exit".
3. Вывести абсолютно все введенные строки в файл, каждую строчку с новой строки.


Требования:
1. Программа должна считывать c консоли имя файла.
2. Создай и используй объект типа BufferedWriter.
3. Программа не должна ничего читать из файловой системы.
4. Программа должна считывать строки с консоли, пока пользователь не введет строку "exit".
5. Программа должна записать абсолютно все введенные строки (включая "exit") в файл, каждую строчку с новой строки.
6. Метод main должен закрывать объект типа BufferedWriter после использования.

нужно іспользовать Buffered Writer
 прімер іспользованія
 private static void writeUsingBufferedWriter(String data, int noOfLines) {
        File file = new File("/Users/prologistic/BufferedWriter.txt");
        FileWriter fr = null;
        BufferedWriter br = null;
        String dataWithNewLine = data + System.getProperty("line.separator");
        try{
            fr = new FileWriter(file);
            br = new BufferedWriter(fr);
            for(int i = noOfLines; i>0; i--){
                br.write(dataWithNewLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            try {
                br.close();
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
 */
public class Task1319done {
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    String filepath = reader.readLine();
    BufferedReader readerStrok = new BufferedReader(new InputStreamReader(System.in));
    ArrayList<String> list = new ArrayList<String>();
    while (true) {
      String s = readerStrok.readLine();
      list.add(s);
      if (s.equals("exit")) {
        break;
      }
    }
    reader.close();
    readerStrok.close();

    BufferedWriter br = null;
    FileWriter fr = null;
    String dataWithNewLine = "";
    fr = new FileWriter(filepath);
    br = new BufferedWriter(fr);
    for (int i = 0; i < list.size(); i++) {
      dataWithNewLine = list.get(i) + System.getProperty("line.separator");
      if (i == (list.size() - 1)){
        dataWithNewLine = list.get(i);
      }
      try {
        br.write(dataWithNewLine);
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    try {
      br.close();
      fr.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
/*
    OutputStream outStream = new FileOutputStream(filepath);
    for (int i = 0; i < list.size(); i++) {
      String stroka = list.get(i);
      if (stroka.equals("exit")) {
        outStream.write(stroka.getBytes());
      }else  { stroka = stroka + "\n";
        outStream.write(stroka.getBytes());
      }
    }
    outStream.close();
*/
}