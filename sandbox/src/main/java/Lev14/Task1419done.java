package Lev14;

import java.io.CharConversionException;
import java.io.FileInputStream;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

/*
Нашествие исключений
Заполни список exceptions десятью(10) различными исключениями.
Первое исключение уже реализовано в методе initExceptions.


Требования:
1. Список exceptions должен содержать 10 элементов.
2. Все элементы списка exceptions должны быть исключениями(потомками класса Throwable).
3. Все элементы списка exceptions должны быть уникальны.
4. Метод initExceptions должен быть статическим.

 */
public class Task1419done {
  public static List<Exception> exceptions = new ArrayList<Exception>();

  public static void main(String[] args) {
    initExceptions();

    for (Exception exception : exceptions) {
      System.out.println(exception);
    }
  }

  private static void initExceptions() {   //it's first exception
    try {                                // 1
      float i = 1 / 0;

    } catch (Exception e) {
      exceptions.add(e);
    }
    try {                                // 2
      FileInputStream fis = new FileInputStream("C2:\badFileName.txt");
    } catch (Exception e) {
      exceptions.add(e);
    }
    try {                                // 3
      String s = null;
      String m = s.toLowerCase();
    } catch (Exception e) {
      exceptions.add(e);
    }
    try {                               // 4
      int[] m = new int[2];
      m[8] = 5;
    } catch (Exception e) {
      exceptions.add(e);
    }
    try {                              // 5
      ArrayList<String> list = new ArrayList<String>();
      String s = list.get(18);
    } catch (Exception e) {
      exceptions.add(e);
    }
    try {                              // 6
      int num = Integer.parseInt("XYZ");
      System.out.println(num);
    }  catch (Exception e) {
      exceptions.add(e);
    }
    try {                              // 7
      throw new CharConversionException();
    } catch  (Exception e) {
      exceptions.add(e);
    }
    try {                             // 8
      throw new IOException();
    } catch  (Exception e) {
      exceptions.add(e);
    }
    try {                             // 9
      throw new RemoteException();
    } catch  (Exception e) {
      exceptions.add(e);
    }
    try {                             // 10
      throw new NoSuchFieldException();
    } catch  (Exception e) {
      exceptions.add(e);
    }



  }
}