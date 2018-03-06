package JavaRushExercises.Lev4;

import java.util.Scanner;

/*
Три числа
Ввод с клавиатуры, сравнение чисел и вывод на экран - у студентов 4 уровня секретного центра JavaRush эти навыки
оттачиваются до автоматизма.
Давайте напишем программу, в которой пользователь вводит три числа с клавиатуры. Затем происходит сравнение,
и если мы находим число, которое отличается от двух других, выводим на экран его порядковый номер.


Требования:
1. Программа должна считывать числа c клавиатуры.
2. Программа должна использовать команды System.out.println() или System.out.print().
3. Программа должна выводить на экран порядковый номер числа, отличного от остальных.
4. Если все числа разные, ничего не выводить.
 */
public class ThreeNumbersComparing {
  public static void main(String[] args) throws Exception {
    Scanner scanner = new Scanner(System.in);
    int[] mas = new int[3]; // объявляем массив 3-х чисел и заполняем его
    mas[0] = scanner.nextInt();
    mas[1] = scanner.nextInt();
    mas[2] = scanner.nextInt();

    //сравниваем числа
    if (mas[0] == mas[1] && mas[0]!=mas[2]) {
      System.out.println("3");
    } else if (mas[1] == mas[2] && mas[1]!= mas[0]){
      System.out.println("1");
    } else if (mas[2] == mas[0] && mas[2]!= mas[1]){
      System.out.println("2");
    }
  }


}
