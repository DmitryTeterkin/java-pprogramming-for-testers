package Lev8;
/*
Переставь один модификатор static, чтобы пример скомпилировался.


Требования:
1. Программа не должна считывать данные с клавиатуры.
2. В классе Task0925 должна быть переменная A.
3. В классе Task0925 должна быть переменная B.
4. В классе Task0925 должна быть переменная C.
5. В классе Task0925 должна быть переменная D.
6. Класс Task0925 должен содержать только три метода.
7. В классе должно быть 4 статика (переменные и методы).

Сделано!!!

 */

public class Task0825done {
  public static int A = 5;
  public static int B = 2;

  public int C = A * B;
  public static int D = B * A;

  public static void main(String[] args) {
  }

  public int getValue() {
    return D;
  }

  public int getValue2() {
    return C;
  }

}
