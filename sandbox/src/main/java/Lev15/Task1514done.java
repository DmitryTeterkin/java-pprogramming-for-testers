package Lev15;

import java.util.HashMap;
import java.util.Map;

/*
Статики-1
В статическом блоке инициализировать labels 5 различными парами ключ-значение.


Требования:
1. В классе Solution должен быть только один метод (main).
2. В классе Solution должно быть объявлено статическое поле labels типа Map.
3. Поле labels должно быть заполнено 5 различными парами ключ-значение в статическом блоке.
4. Метод main должен выводить содержимое labels на экран.
 */
public class Task1514done {
  public static Map<Double, String> labels = new HashMap<Double, String>();

  static {
    for (int i = 0; i < 5; i++) {
      labels.put(i * 0.03, " че, проблемы?");
    }
  }

  public static void main(String[] args) {
    System.out.println(labels);
  }
}

