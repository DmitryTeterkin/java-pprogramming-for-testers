package Lev9;
/*
Реализовать метод log.
Он должен выводить на экран имя класса и имя метода (в котором вызывается метод log), а также переданное сообщение.
Имя класса, имя метода и сообщение разделить двоеточием с пробелом.

Пример вывода:
com.javarush.task.task09.task0906.Task0925done: main: In main method


Требования:
1. Метод log должен выводить сообщение на экран.
2. Выведенное сообщение должно содержать имя класса, метод которого вызвал метод log.
3. Выведенное сообщение должно содержать имя метода, который вызвал метод log.
4. Выведенное сообщение должно содержать переданное сообщение.
5. Вывод должен соответствовать примеру из задания.

Класс Thread = хранит  всю информацию обо всех потоках, его метод  currentThread()
- возвращает текущий поток, вызывая Thread.currentThread().getStackTrace() - получаем массив (стэк) (историю) вызовов,
где каждый элемент имеет тип StackTraceElement в котором хранится его имя - имя метода.

Thread.currentThread().getStackTrace() [0] - самый последний положенный в стек элемент.

нулевая позиция в стеке - вызов самого метода getStackTrace(),
первая - текущий метод
а вторая  - вызвавший метод - он нам и нужен

 getMethodName - дает нам имя метода.

Т.О в конце каждого метода пишем   return Thread.currentThread().getStackTrace()[2].getMethodName();  и задача решена.

 */
public class Task0906done {
  public static void main(String[] args) {
    log("In main method");
  }

  public static void log(String s) {
    System.out.println(Thread.currentThread().getStackTrace()[1].getClassName()+": "+ Thread.currentThread().getStackTrace()[2].getMethodName() + ": " + s);
  }
}
