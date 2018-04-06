package Lev9;
/*
Напиши код, чтобы получить стек-трейс длиной 10 вызовов. Метод main изменять нельзя.


Требования:
1. В классе должно быть 10 методов (метод main не учитывать).
2. Длина стек-трейса в методе method10 должна быть 10.
3. Каждый метод должен вызывать другой метод.
4. Используй метод Thread.currentThread().getStackTrace().
 */
public class Task0904 {
  public static void main(String[] args) throws Exception {
    int stackTraceLength = method1().length - method10().length + 1;
  }

  public static StackTraceElement[] method1() {
    return method2();
  }

  public static StackTraceElement[] method2() {
    //напишите тут ваш код
  }

  public static StackTraceElement[] method3() {
    //напишите тут ваш код
  }

  public static StackTraceElement[] method4() {
    //напишите тут ваш код
  }

  public static StackTraceElement[] method5() {
    //напишите тут ваш код
  }

  public static StackTraceElement[] method6() {
    //напишите тут ваш код
  }

  public static StackTraceElement[] method7() {
    //напишите тут ваш код
  }

  public static StackTraceElement[] method8() {
    //напишите тут ваш код
  }

  public static StackTraceElement[] method9() {
    return method10();
  }

  public static StackTraceElement[] method10() {
    return Thread.currentThread().getStackTrace();
  }
}
