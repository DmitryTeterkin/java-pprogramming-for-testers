package Lev15.Task1522;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
Закрепляем паттерн Singleton
1. Найти пример реализации паттерна Singleton с ленивой реализацией(lazy initialization). Используй свой любимый поисковик(например google).
2. По образу и подобию в отдельных файлах создай три класса синглтона Sun, Moon, Earth.
3. Реализуй интерфейс Planet в классах Sun, Moon, Earth.
4. В статическом блоке класса Solution вызови метод readKeyFromConsoleAndInitPlanet.
5. Реализуй функционал метода readKeyFromConsoleAndInitPlanet:
5.1. С консоли считай один параметр типа String.
5.2. Если параметр равен одной из констант интерфейса Planet, создай соответствующий объект и присвой его Planet thePlanet, иначе обнулить Planet thePlanet.


Требования:
1. Класс Sun не должен позволять создавать объекты своего типа извне класса.
2. Класс Sun должен содержать приватное статическое поле instance типа Sun.
3. В классе Sun должен быть реализован публичный статический метод getInstance возвращающий значение поля instance.
4. Метод getInstance в классе Sun должен ВСЕГДА возвращать один и тот же объект.
5. Поле instance должно быть инициализировано после первого обращения к методу getInstance, но не раньше.
6. Класс Moon не должен позволять создавать объекты своего типа извне класса.
7. Класс Moon должен содержать приватное статическое поле instance типа Moon.
8. В классе Moon должен быть реализован публичный статический метод getInstance возвращающий значение поля instance.
9. Метод getInstance в классе Moon должен ВСЕГДА возвращать один и тот же объект.
10. Поле instance должно быть инициализировано после первого обращения к методу getInstance, но не раньше.
11. Класс Earth не должен позволять создавать объекты своего типа извне класса.
12. Класс Earth должен содержать приватное статическое поле instance типа Earth.
13. В классе Earth должен быть реализован публичный статический метод getInstance возвращающий значение поля instance.
14. Метод getInstance в классе Earth должен ВСЕГДА возвращать один и тот же объект.
15. Поле instance должно быть инициализировано после первого обращения к методу getInstance, но не раньше.
16. Метод readKeyFromConsoleAndInitPlanet должен быть вызван в статическом блоке класса Solution.
17. Метод readKeyFromConsoleAndInitPlanet должен считывать одну строку с клавиатуры.
18. Метод readKeyFromConsoleAndInitPlanet должен корректно обновлять значение переменной thePlanet в соответствии с условием задачи.
19. Классы Sun, Moon и Earth должны быть созданы в отдельных файлах.
 */
public class Task1522  {
  private static String s;

  public static void main(String[] args) {

  }
  public static Planet thePlanet;
  static {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    try {
      s = reader.readLine();
    } catch (IOException e) {
      e.printStackTrace();
    }
    try {
      readKeyFromConsoleAndInitPlanet();
    } catch (IOException e) {


    }

  }   //add static block here - добавьте статический блок тут

  public static void readKeyFromConsoleAndInitPlanet() throws IOException {

    switch (s) {
      case "earth":
        Earth earth = Earth.getInstance();

      case "moon":
        Moon moon = Moon.getInstance();

      case "sun":
       Sun sun = Sun.getInstance();

      default:
        throw new IllegalArgumentException();
    }

  } // implement step #5 here - реализуйте задание №5 тут

}
