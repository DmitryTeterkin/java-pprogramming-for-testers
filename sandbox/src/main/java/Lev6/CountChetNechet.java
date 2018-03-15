package Lev6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CountChetNechet {
  public static int even;
  public static int odd;

  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    int numIn = Integer.parseInt(reader.readLine()); /* задача требует ввода числа
                                                     (это важно, сначала объявляем переменную типа int)*/
    String numText = String.valueOf(numIn); /*затем объявляем переменную типа String и присваиваем ей
                                            // значение вышеидущей переменной типа int,, естественно переводя в тип
                                            String)*/
    char[] numChar = numText.toCharArray(); /*чтобы получить каждое число по отдельности
                                               нужно создать МАССИВ (объявляем квадратными скобками) в который положим
                                               переведенные из текста numText символы. У  массива каждое число получит
                                               порядковый номер начиная с нуля. То есть если мы ввели с клавиатуры
                                               числа 1, 2 и 3, то в массив они запишутся под такими порядковыми
                                               числами 0, 1 и 2 соответственно.*/

    for (int i = 0; i < numText.length(); i++) { /*объявляем цикл с переменной i, которая  начинается с 0 и меньше чем
                                                 numText.length() (так мы переводим количество символов переменной
                                                 типа String в числовое значение, то есть при введенном числе 123,
                                                 символов 3 и цикл будет длиться 3 раза)*/
      if (numChar[i] % 2 == 0) { /*условие если массив с порядковым номером равным i (что справедливо для каждого из
                                   трех циклов) целое (при делении с остатком на 2 равен 0), то значение переменной
                                   even увеличивается на единицу.*/
        even++;
      } else // иначе увеличивается  переменная odd.
        odd++;
    }
    System.out.println("Even: " + even + " " + "Odd: " + odd);
  }
}