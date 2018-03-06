package workbook;

public class Exc0 {
  public static void main(String[] args) {
  /*  int a = 0;
    int b = 0;
    int c = 0;
    Random r = new Random();
    for (int i = 0; i < 32000; i++) {
    */
    try {
      int a = args.length;
      System.out.println("a = " + a);
      int b = 42 / a;
      int c[] = {1};
      c[42] = 99;
    } catch (ArithmeticException e) {
      System.out.println("исключение: " + e);
    } catch (ArrayIndexOutOfBoundsException e) {
      System.out.println("ошибка индексации за пределами массива: " + e);
    }
    System.out.println("После блока операторов.");
  }
}