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
public class Task0925done {
  public static int A = 5;
  public static int B = 2 * A;
  public int C = A * B;
  public static int D = A * B;

  public static void main(String[] args) {
    Task0925done room = new Task0925done();
    room.A = 5;

    Task0925done.D = 5;
  }

  public int getA() {
    return A;
  }
}
