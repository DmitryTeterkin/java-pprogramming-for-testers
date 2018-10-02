package Lev15;
/*
Порядок загрузки переменных
Разберись, что и в какой последовательности инициализируется. Поставь брейкпойнты и используй дебаггер.

Исправить порядок инициализации данных так, чтобы результат был следующим:
static void init()
Static block
public static void main
non-static block
static void printAllFields
0
null
Solution constructor
static void printAllFields
6
First name


Требования:
1. Программа должна выводить данные на экран.
2. Вывод на экран должен соответствовать условию задачи.
3. Результатом работы статического инициализатора класса Solution должен быть вывод на экран строк "static void init()" и "Static block".
4. Программа не должна считывать данные с клавиатуры.
 */
public class Task1524ready {

  static {
    init();
  }

  public static void init() {
    System.out.println("static void init()");
  }

  static {
    System.out.println("Static block");
  }

  {
    System.out.println("non-static block");
    printAllFields(this);
  }

  public int i = 6;



  public Task1524ready() {
    System.out.println("Solution constructor");
    printAllFields(this);
  }



  public static void main(String[] args) {
    System.out.println("public static void main");
    Task1524ready s = new Task1524ready();
  }

  public static void printAllFields(Task1524ready obj) {
    System.out.println("static void printAllFields");
    System.out.println(obj.i);
    System.out.println(obj.name);

  }
  public String name = "First name";
}
