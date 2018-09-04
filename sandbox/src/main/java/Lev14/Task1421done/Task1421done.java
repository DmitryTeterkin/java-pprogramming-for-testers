package Lev14.Task1421done;

/*
Singleton
Класс является синглтоном (реализует паттерн Singleton), если позволяет создать всего один объект своего типа.

Реализовать Singleton pattern:
1. Создай класс Singleton в отдельном файле.
2. Добавь в него статический метод getInstance().
3. Метод getInstance должен возвращать один и тот же объект класса Singleton при любом вызове метода getInstance.
4. Подумай, каким образом можно запретить создание других объектов этого класса.
5. Сделай все конструкторы в классе Singleton приватными (private).
6. В итоге должна быть возможность создать объект (экземпляр класса) ТОЛЬКО используя метод getInstance.


Требования:
1. Класс Singleton должен быть создан в отдельном файле.
2. Класс Singleton не должен позволять создавать объекты своего типа извне класса.
3. Класс Singleton должен содержать приватное статическое поле instance типа Singleton.
4. В классе Singleton должен быть реализован публичный статический метод getInstance возвращающий значение поля instance.
5. Метод getInstance должен ВСЕГДА возвращать один и тот же объект.
 */
public class Task1421done {
  public static void main(String[] args) {
    System.out.println("If you see the same value, then singleton was reused (yay!)" + "\n" +
            "If you see different values, then 2 singletons were created (booo!!)" + "\n\n" +
            "RESULT:" + "\n");
    Thread threadFoo = new Thread(new ThreadFoo());
    Thread threadBar = new Thread(new ThreadBar());
    threadFoo.start();
    threadBar.start();
  }

  static class ThreadFoo implements Runnable {
    @Override
    public void run() {
      Singleton singleton = Singleton.getInstance();
      System.out.println(singleton);
    }
  }

  static class ThreadBar implements Runnable {
    @Override
    public void run() {
      Singleton singleton = Singleton.getInstance();
      System.out.println(singleton);
    }
  }

}

