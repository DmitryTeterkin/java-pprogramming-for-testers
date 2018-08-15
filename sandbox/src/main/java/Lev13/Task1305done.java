package Lev13;
/*
Четыре ошибки
Исправь 4 ошибки в программе, чтобы она компилировалась.


Требования:
1. Переменные объявленные в интерфейсе могут иметь только самый широкий уровень доступа(public).
2. Унаследоваться(extends) можно только от класса, для реализации интерфейсов используется ключевое слово implements.
3. Класс Hobbie должен быть объявлен с модификатором доступа static.
4. Для доступа к переменной HOBBIE нет необходимости создавать объект Dream.
5. Объявления интерфейсов не изменять.
*/
public class Task1305done {
  public static void main(String[] args) throws Exception {

    System.out.println(Dream.HOBBIE.toString());
    System.out.println(new Hobbie().toString());

  }

  interface Desire {
  }

  interface Dream {
    public static Hobbie HOBBIE = new Hobbie();
  }

 static class Hobbie implements Desire, Dream {
    static int INDEX = 1;

    @Override
    public String toString() {
      INDEX++;
      return "" + INDEX;
    }
  }
}
