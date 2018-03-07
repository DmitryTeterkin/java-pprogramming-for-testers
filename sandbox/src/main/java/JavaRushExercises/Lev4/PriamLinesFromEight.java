package JavaRushExercises.Lev4;
/*
Рисуем линии
Используя цикл for вывести на экран:
- горизонтальную линию из 10 восьмёрок
- вертикальную линию из 10 восьмёрок.


Требования:
1. Программа не должна считывать числа c клавиатуры.
2. Программа должна выводить числа на экран.
3. Программа должна выводить горизонтальную линию из 10 восьмёрок.
4. Программа должна выводить вертикальную линию из 10 восьмёрок.
5. В программе должен использоваться цикл for.
 */
public class PriamLinesFromEight {
  public static void main(String[] args) {
    for (int i = 0; i < 9; i++){
      System.out.print("8 ");
    }
    for (int j = 0; j < 10; j++){
      System.out.println("8");
    }
  }
}
