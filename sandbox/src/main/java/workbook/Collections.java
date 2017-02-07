package workbook;

import java.util.ArrayList;
import java.util.List;

// Коллекции, массивы элементов лекция 4.2
public class Collections {
  public static void main(String[] args){
    String [] langs = {"Java", "C#", "Python", "PHP"}; // создаем массив строк из 4 элементов и заполняем его значениями

    List<String> languages = new ArrayList<>();
    languages.add("Java");
    languages.add("C#");
    languages.add("Python");


    for (int i = 0; i < langs.length; i++){    // цикл, который выводит последоватиельно я хочу выучить...
      System.out.println("Я хочу выучить "+ langs[i]);
    }
    // этот цикл может выглядеть совсем по-другому:
    for (String l : langs){ // специальная конструкция for для коллекций
      System.out.println("Я хочу выучить "+ l);
    }
    for (String l : languages){ // специальная конструкция for для коллекций
      System.out.println("Я хочу выучить "+ l);
    }

  }

}
