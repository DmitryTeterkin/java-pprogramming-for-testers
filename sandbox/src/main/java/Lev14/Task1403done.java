package Lev14;
/*
Building и School
1. Расставь правильно наследование между Building(здание) и School(здание школы).
2. Подумай, объект какого класса должен возвращать методы getSchool и getBuilding.
3. Измени null на объект класса Building или School.


Требования:
1. Класс School должен наследоваться от класса Building.
2. Метод getSchool должен возвращать новую школу(School).
3. Метод getBuilding должен возвращать новое здание(Building).
4. Класс School должен быть статическим.
5. Класс Building должен быть статическим.
 */
public class Task1403done {
  public static void main(String[] args) {
    Building school = getSchool();
    Building shop = getBuilding();

    System.out.println(school);
    System.out.println(shop);
  }

  public static Building getSchool() {
    School school = new School();//измените null на объект класса Building или School
    return school;
  }

  public static Building getBuilding() {
    Building building = new Building();//измените null на объект класса Building или School
    return building;
  }

  static class School extends Building/*Добавьте сюда ваш код*/ {
    @Override
    public String toString() {
      return "School";
    }
  }

  static class Building /*Добавьте сюда ваш код*/ {
    @Override
    public String toString() {
      return "Building";
    }
  }

}
