package Lev16;
/*
Рекурсивное создание нитей
1. Измени класс GenerateThread так, чтобы он стал нитью.
2. Создай конструктор GenerateThread, который должен:
2.1. Вызвать конструктор суперкласса с параметром String - номером созданной нити. Используй createdThreadCount.
2.2. Запустить текущую нить.
2.3. Номер первой нити должен начинается с 1.
3. Переопредели метод toString, для этого внутри GenerateThread нажми Alt+Insert -> Override Methods. Начни печатать
toString.
3.1. Метод toString должен возвращать № текущей нити и слово " created". Используй getName().

Пример:
8 created

4. Пока количество созданных нитей меньше Solution.count метод run должен:
4.1. Создавать новую нить типа GenerateThread.
4.2. Выводить в консоль созданную в пункте 4.1 нить.
5. В итоге должно быть выведено в консоль 15 строк.


Требования:
1. Класс GenerateThread должен быть унаследован от Thread.
2. В классе GenerateThread должен быть открытый конструктор без параметров.
3. Конструктор класса GenerateThread должен увеличивать значение createdThreadCount и передавать его в виде строки в
конструктор суперкласса.
4. Конструктор класса GenerateThread должен запускать нить.
5. Метод toString класса GenerateThread должен возвращать имя нити и слово " created". Пример: "8 created".
6. Если количество созданных нитей меньше Solution.count, метод run должен создать новую нить типа GenerateThread.
7. Если количество созданных нитей меньше Solution.count, метод run должен вывести созданную нить в консоль.
8. Вывод программы должен соответствовать заданию, показывать, что все 15 нитей были созданы.
 */
public class Task1623 {
  static int count = 15;
  static volatile int createdThreadCount = 0;

  public static void main(String[] args) throws InterruptedException {
    Thread t = new GenerateThread();
//    System.out.println(t);
//    Thread.currentThread().join();
//    Thread.currentThread().interrupt();
  }

  public static class GenerateThread extends Thread {

    public GenerateThread(String name) {
      super(name);
    }

    public GenerateThread() {
      createdThreadCount = createdThreadCount + 1;
      String S = String.valueOf(createdThreadCount);
      Thread t = new GenerateThread(S);
      System.out.println(t);
      t.start();
//      createdThreadCount = createdThreadCount + 1;
      try{
        t.join();
      }catch (InterruptedException e){}
      //t.interrupt();
    }
    public void run() {
     while (createdThreadCount < count){
       Thread t = new GenerateThread();
       try {
         t.join();
       }catch (InterruptedException e){
         e.printStackTrace();
       }
     //  createdThreadCount = createdThreadCount + 1;
     }
    }

    @Override
    public String toString() {
      String s = currentThread().getName() + " created";
      return s;
    }
  }
}
