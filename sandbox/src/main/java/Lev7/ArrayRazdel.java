package Lev7;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
1. Создать массив на 20 чисел.
2. Ввести в него значения с клавиатуры.
3. Создать два массива на 10 чисел каждый.
4. Скопировать большой массив в два маленьких: половину чисел в первый маленький, вторую половину во второй маленький.
5. Вывести второй маленький массив на экран, каждое значение выводить с новой строки.


Требования:
1. Программа должна создавать большой массив на 20 целых чисел.
2. Программа должна считывать с клавиатуры 20 чисел для большого массива.
3. Программа должна создавать два маленьких массива на 10 чисел каждый.
4. Программа должна скопировать одну половину большого массива в первый маленький,
 а вторую - во второй и вывести его на экран.
 */

public class ArrayRazdel {
  public static void main(String[] args) throws Exception {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    int[] mas1 = new int[20];
    int[] mas2 = new int[10];
    int[] mas3 = new int[10];
    int d = mas1.length / 2;
    for (int i = 0; i < mas1.length; i++){
      String s = reader.readLine();
      mas1[i] = Integer.parseInt(s);
      if (i < d){
        mas2[i] = mas1[i];
      } else{mas3[i-10] = mas1[i];}
    }
    for (int i = 0; i < mas3.length; i++){
      System.out.println(mas3[i]);
    }
    //напишите тут ваш код
  }
}
