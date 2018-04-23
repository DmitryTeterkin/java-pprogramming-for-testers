package workbook;

public class Cat{
  public static void main(String[] args) {
  }
}

/*
  Реализовать метод addNewCat
  Реализовать метод addNewCat, чтобы при его вызове (т.е. добавлении нового кота), количество котов увеличивалось на 1.
  За количество котов отвечает переменная catsCount.


  Требования:
          1. Класс Cat должен содержать только одну переменную catsCount.
          2. Переменная catsCount должна быть статической, иметь модификатор доступа private, тип int и проинициализирована нулем.
          3. Класс Cat должен содержать два метода addNewCat и main.
4. Метод addNewCat класса Cat должен увеличивать количество котов на 1.


          package com.javarush.task.task04.task0404;

/*
Реализовать метод addNewCat
*/
/*
  public class Cat {
    private static int catsCount = 0;

    public static void addNewCat() {
      //напишите тут ваш код
    }

    public static void main(String[] args) {

    }
  }


    Реализовать метод setCatsCount
          Реализовать метод setCatsCount так, чтобы с его помощью можно было устанавливать значение переменной catsCount равное переданному параметру.


          Требования:
          1. Класс Cat должен содержать только одну переменную catsCount.
          2. Переменная catsCount должна быть статической, иметь модификатор доступа private, тип int и проинициализирована нулем.
          3. Класс Cat должен содержать два метода setCatsCount и main.
          4. Метод setCatsCount класса Cat должен устанавливать значение переменной catsCount равным переданному параметру.

          package com.javarush.task.task04.task0405;

/*
Реализовать метод setCatsCount
*/
/*
  public class Cat {
    private static int catsCount = 0;

    public static void setCatsCount(int catsCount) {
      //напишите тут ваш код
    }

    public static void main(String[] args) {

    }
  }


    Реализовать метод setName
          Реализовать метод setName, чтобы с его помощью можно было устанавливать значение переменной private String fullName равное значению локальной переменной String fullName.


          Требования:
          1. Класс Cat должен содержать только одну переменную fullName.
          2. Переменная fullName должна иметь модификатор доступа private и тип String.
          3. Класс Cat должен содержать только два метода setName и main.
          4. Метод setName должен иметь локальную переменную fullName.
          5. Метод setName класса Cat должен устанавливать значение глобальной переменной private String fullName равным локальной переменной fullName.

          package com.javarush.task.task04.task0406;

/*
Реализовать метод setName
*/
/*
  public class Cat {
    private String fullName;

    public void setName(String firstName, String lastName) {
      String fullName = firstName + " " + lastName;

      //напишите тут ваш код
    }

    public static void main(String[] args) {

    }
  }
*/
/*
    Кошки во Вселенной
          Написать код, чтобы правильно считалось количество созданных котов (count) и на экран выдавалось правильное их количество.


          Требования:
          1. Программа должна выводить текст на экран.
          2. Нельзя изменять строку отвечающую за вывод в консоль.
          3. Класс Cat должен содержать только одну переменную count.
          4. Переменная count класса Cat должна быть статической, иметь модификатор доступа public, тип int и проинициализирована нулем.
          5. В методе main должно быть только две проинициализированные переменные типа Cat.
          6. Переменная count должна содержать актуальное количество созданных котов.

          package com.javarush.task.task04.task0407;




  public class Task0925done {
    public static void main(String[] args) {
      Cat cat1 = new Cat();
      //напишите тут ваш код

      Cat cat2 = new Cat();
      //напишите тут ваш код

      System.out.println("Cats count is " + Cat.count);
    }

    public static class Cat {
      public static int count = 0;
    }
  }

  */