package Lev15;

public class test {
  public static void main(String[] args) {
    for (int i = 0; i < 8; i++) {
      System.out.println(soatoCreate(i));
    }

  }

  private static String soatoCreate(int i) {
    long value = 6236834016L + (i*5);
    String soato = String.valueOf(value);
    return soato;
  }
}
