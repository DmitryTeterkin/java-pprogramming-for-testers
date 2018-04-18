package Lev9;
/*
Расставь модификаторы static так, чтобы пример скомпилировался.


Требования:
1. В классе должна быть переменная A.
2. В классе должна быть переменная B.
3. В классе должна быть переменная C.
4. Метод main не изменять.
5. Метод getA не изменять.
6. В классе должно быть 3 статических поля.
 */
public class Task0925 {
  public int A = 5;
  public int B = 2 * A;
  public int C = A * B;
  public int D = A * B;

  public static void main(String[] args) {
    Task0925 room = new Task0925();
    room.A = 5;

    Task0925.D = 5;
  }

  public int getA() {
    return A;
  }
}
