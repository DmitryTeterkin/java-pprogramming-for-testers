package Lev12;
/*
Абстрактный класс Pet
Сделать класс Pet абстрактным.


Требования:
1. Программа не должна выводить текст на экран.
2. Класс Pet должен быть статическим.
3. Класс Pet должен быть абстрактным.
4. Класс Pet должен иметь один метод getName().
 */
public class Task1211done {
  public static void main(String[] args) {

  }

  public abstract static class Pet {
    public String getName() {
      return "Я - котенок";
    }
  }

}