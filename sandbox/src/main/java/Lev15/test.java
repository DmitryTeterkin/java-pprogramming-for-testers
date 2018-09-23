package Lev15;

public class test {
  public static void main(String[] args) {

    byte b = 12;
    short someShort;
    int someInt = 3221;
    long myLongValue = 999_999_999L;
    someShort = (short) someInt;
    char h = (char) someShort;
    someInt = (int) myLongValue;
    float f = 23.56f;
    System.out.println(f);
      double d = f;
    System.out.println(d);
    d = myLongValue;
    System.out.println(d);
    f = myLongValue;
    System.out.println(f);
 /*   System.out.println(b);
    System.out.println(someInt);
    System.out.println(myLongValue);
    System.out.println(h);*/

  }


}
