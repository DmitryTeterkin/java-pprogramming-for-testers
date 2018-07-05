package Lev12;
/*
Int и Integer
Написать два метода: print(int) и print(Integer).
Написать такой код в методе main, чтобы вызвались они оба.


Требования:
1. Класс Solution должен содержать статический метод main().
2. Класс Solution должен содержать статический void метод print() с параметром типа int.
3. Класс Solution должен содержать статический void метод print() с параметром типа Integer.
4. Метод main() должен вызывать метод print() с параметром типа int.
5. Метод main() должен вызывать метод print() с параметром типа Integer.
 */
public class Task1207done {
  public static void main(String[] args) {
   print(12);
   print(Integer.valueOf(45));
  }

  static void print(int a){
    System.out.println(a);
  }
  static void print (Integer b){
    System.out.println(b);
  }//Напишите тут ваши методы
}
