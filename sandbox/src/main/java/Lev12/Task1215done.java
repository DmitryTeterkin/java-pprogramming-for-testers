package Lev12;
/*
Кошки не должны быть абстрактными!
Унаследуй классы Cat и Dog от Pet.
Реализуй недостающие методы.
Классы Cat и Dog не должны быть абстрактными.


Требования:
1. Класс Pet должен быть абстрактным.
2. Класс Dog не должен быть абстрактным.
3. Класс Cat не должен быть абстрактным.
4. Класс Dog должен реализовать абстрактные методы из класса Pet.
5. Класс Cat должен реализовать абстрактные методы из класса Pet.
 */
public class Task1215done {
  public static void main(String[] args) {

  }

  public static abstract class Pet {
    public abstract String getName();

    public abstract Pet getChild();
  }

  public static class Cat extends Pet{

    public String getName() {
      return "name";
    }

    public Cat getChild() {
      return this;
    }
  }

  public static class Dog extends Pet{
    public String getName() {
      return "name";
    }

    public Dog getChild() {
      return this;
    }
  }

}