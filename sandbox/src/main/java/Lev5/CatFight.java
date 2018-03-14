package Lev5;
// битва котов
public class CatFight {
  public static void main(String[] args) {
    Cat cat1 = new Cat("name1", 10, 23, 100);
    Cat cat2 = new Cat("name2", 5, 10, 50);
    Cat cat3 = new Cat("name3", 7, 15, 60);
    System.out.println(cat1.fight(cat2));
    System.out.println(cat2.fight(cat3));
    System.out.println(cat3.fight(cat1));
  }

  public static class Cat {
    protected String name;
    protected int age;
    protected int weight;
    protected int strength;

    public Cat(String name, int age, int weight, int strength) {
      this.name = name;
      this.age = age;
      this.weight = weight;
      this.strength = strength;
    }

    public boolean fight(Cat anotherCat) {
      int agePlus = this.age > anotherCat.age ? 1 : 0;
      int weightPlus = this.weight > anotherCat.weight ? 1 : 0;
      int strengthPlus = this.strength > anotherCat.strength ? 1 : 0;

      int score = agePlus + weightPlus + strengthPlus;
      return score > 2; // return score > 2 ? true : false;
    }
  }
}
