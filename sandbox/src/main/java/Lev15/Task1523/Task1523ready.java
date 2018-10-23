package Lev15.Task1523;
/*
Перегрузка конструкторов
1. В классе Solution создай 4 конструктора с разными модификаторами доступа.
2. В отдельном файле создай класс SubSolution и сделай его потомком класса Solution.
3. Внутри класса SubSolution создай конструкторы командой Alt+Insert -> Constructors.
4. Исправь модификаторы доступа конструкторов в SubSolution так, чтобы получилось 3 конструктора с различными
модификаторами доступа(все кроме private).


Требования:
1. В классе SubSolution должно содержаться 3 различных конструктора.
2. В классе Solution должно содержаться 4 различных конструктора.
3. В классе Solution должны быть объявлены конструкторы со всеми возможными модификаторами доступа.
4. В классе SubSolution должны быть объявлены конструкторы со всеми возможными модификаторами доступа кроме private.
5. Класс Solution должен быть родителем класса SubSolution.
 */
public class Task1523ready {
  public Task1523ready(){
    System.out.println("public");
   }

  private Task1523ready(int i){
    System.out.println("private " + i);
  }

  Task1523ready(String s){
    System.out.println("usual "+ s);
  }

  protected Task1523ready(Boolean b){
    System.out.println("protected " + b);
  }


  public static void main(String[] args) {
    new SubTask1523Ready();
    new SubTask1523Ready("dfdf");
    new SubTask1523Ready(true);
  }
}
