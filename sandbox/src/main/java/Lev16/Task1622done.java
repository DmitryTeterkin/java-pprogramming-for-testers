package Lev16;
/*
Последовательные выполнения нитей
1. В методе run после всех действий поставь задержку в 10 миллисекунд. Выведи "Нить прервана", если нить будет прервана.
2. Сделай так, чтобы все нити выполнялись последовательно: сначала для нити №1 отсчет с COUNT до 1, потом для нити №2 с COUNT до 1 и т.д.

Пример:
#1: 4
#1: 3
...
#1: 1
#2: 4
...


Требования:
1. Программа должна создавать 4 объекта типа SleepingThread.
2. Метод main должен вызвать join у каждой создаваемой SleepingThread нити.
3. Метод run должен использовать Thread.sleep(10).
4. Вывод программы должен соответствовать условию.
5. Если нить SleepingThread прерывается, она должна вывести сообщение "Нить прервана".
 */
public class Task1622done {

  public volatile static int COUNT = 100;

  public static void main(String[] args) throws InterruptedException {
    for (int i = 0; i < COUNT; i++) {
      SleepingThread r = new SleepingThread();
      r.join();//напишите тут ваш код
    }
  }

  public static class SleepingThread extends Thread {
    private static volatile int threadCount = 0;
    private volatile int countdownIndex = COUNT;

    public SleepingThread() {
      super(String.valueOf(++threadCount));
      start();
    }

    public void run() {
      Thread t = Thread.currentThread();
      while (true) {
        System.out.println(this);
        if (--countdownIndex == 0) return;
       try{
         t.sleep(10);
       } catch (InterruptedException e){
         System.out.println("Нить прервана");
       }//напишите тут ваш код
      }
    }

    public String toString() {
      return "#" + getName() + ": " + countdownIndex;
    }
  }
}
