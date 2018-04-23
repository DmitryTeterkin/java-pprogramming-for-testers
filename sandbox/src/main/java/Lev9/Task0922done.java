package Lev9;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/*
Ввести с клавиатуры дату в формате "08/18/2013"
Вывести на экран эту дату в виде "AUG 18, 2013".
Воспользоваться объектом Date и SimpleDateFormat.

Задача в 4 строчки.
1)Разумеется. создаем объект BufferedReader br.
2)Потом создаете объект Date с параметром br.readLine().
Так у нас уже готовая дата, которая отлично читается. но не в подходящем для нас формате.

3)Потом создаем объект SimpleDateForman со строчкой "MMM d, yyyy" в качестве параметра.
Обратите внимание на буквы МММ. Если их сделать 4, то будет писаться полное название месяца, а так только три буквы.
Плюс запятая должна быть.

4) Ну и последний шаг - вывод на экран. Форматирование осуществляем прямо в методе println().
Просто вызываем метод format() для объекта SimpleDateFormat, а в качестве параметра для метода берем ранее созданный объект date.

Обратите внимание, что методом format мы не присваиваем какое-либо значение объекту SimpleDateFormat, или Date...
Мы просто выводим на экран объект Date в удобном для нас виде, не изменяя его

Требования:
1. Программа должна считывать данные с клавиатуры.
2. В программе должна быть объявлена переменная типа SimpleDateFormat.
3. В программе должна быть объявлена переменная типа Date.
4. Программа должна выводить данные на экран.
5. Вывод должен соответствовать заданию.
 */
public class Task0922done {
  public static void main(String[] args) throws Exception {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");//задаю формат даты
    String s = reader.readLine();;//создаю строку по заданному формату
    Date date = formatter.parse(s);//создаю дату через
    SimpleDateFormat format = new SimpleDateFormat("MMM dd, yyyy", Locale.US);
    System.out.println(format.format(date).toUpperCase());

  }
}
