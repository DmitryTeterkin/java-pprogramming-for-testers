package JavaRushExercises.Lev4;

import java.util.Scanner;

/*Минимум двух чисел
        Ввести с клавиатуры два целых числа, и вывести на экран минимальное из них.
        Если два числа равны между собой, необходимо вывести любое.


        Требования:
        1. Программа должна считывать числа c клавиатуры.
        2. Программа должна выводить число на экран.
        3. Программа должна выводить на экран минимальное из двух целых чисел.
        4. Если два числа равны между собой, необходимо вывести любое.
*/
public class MinOfTwoNumbers {
  public static void main(String[] args) throws Exception {
    Scanner scanner = new Scanner(System.in);
    int a = scanner.nextInt();
    int b = scanner.nextInt(); //напишите тут ваш код
    if (a>=b){
     System.out.println(b);
    } else System.out.println(a);
  }

}
