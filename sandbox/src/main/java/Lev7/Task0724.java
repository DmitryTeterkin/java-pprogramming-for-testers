package Lev7;
/*
Семейная перепись
Создай класс Human с полями имя(String), пол(boolean), возраст(int), отец(Human), мать(Human). Создай объекты и заполни их так, чтобы получилось: Два дедушки, две бабушки, отец, мать, трое детей. Вывести объекты на экран.

Примечание:
Если написать свой метод String toString() в классе Human, то именно он будет использоваться при выводе объекта на экран.

Пример вывода:
Имя: Аня, пол: женский, возраст: 21, отец: Павел, мать: Катя
Имя: Катя, пол: женский, возраст: 55
Имя: Игорь, пол: мужской, возраст: 2, отец: Михаил, мать: Аня
...


Требования:
1. Программа не должна считывать данные с клавиатуры.
2. Добавить в класс Human поля: имя(String), пол(boolean), возраст(int), отец(Human), мать(Human).
3. Добавить в класс конструктор public Human(String name, boolean sex, int age).
4. Добавить в класс конструктор public Human(String name, boolean sex, int age, Human father, Human mother).
5. Создай 9 разных объектов типа Human (4 объекта без отца и матери и 5 объектов с ними)).
6. Выведи созданные объекты на экран.
 */
public class Task0724 {
  public static void main(String[] args) {
   Human Alex0 = new Human("Alex0", true, 21);
   Human Alex1 = new Human("Alex1", true, 22);
   Human Alexa2 = new Human("Alexa2", false, 23);
   Human Alexa3 = new Human("Alexa3", false, 24);
   Human Ira = new Human("Ira", false, 24, Alex0,Alexa2);
    Human Ira1 = new Human("Ira1", false, 24, Alex1,Ira);
    Human Ira2 = new Human("Ira3", false, 24, Alex0,Alexa3);
    System.out.println(Alex0);
    System.out.println(Alex1);
    System.out.println(Alexa2);
    System.out.println(Alexa3);
  }

  public static class Human {
    String name;
    Human father, mother;
    boolean sex;
    int age;

    public Human(String name, boolean sex, int age) {
      this.name = name;
      this.sex = sex;
      this.age = age;
    }

    public Human(String name, boolean sex, int age, Human father, Human mother) {
      this.name = name;
      this.father = father;
      this.mother = mother;
      this.sex = sex;
      this.age = age;
    }

    public String toString() {
      String text = "";
      text += "Имя: " + this.name;
      text += ", пол: " + (this.sex ? "мужской" : "женский");
      text += ", возраст: " + this.age;

      if (this.father != null)
        text += ", отец: " + this.father.name;

      if (this.mother != null)
        text += ", мать: " + this.mother.name;

      return text;
    }
  }

}
