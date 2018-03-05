package workbook;

class Stack {
  int stck[] = new int[10];
  int tos;

  // вершина стека, инициализация
  Stack() {
    tos = -1;
  }

  // размещение элементов в стеке
  void push(int item) {
    if (tos == 9)
      System.out.println("стек заполнен. ");
    else
      stck[++tos] = item;
  }

  //извлечение объекта из стека
  int pop() {
    if (tos < 0) {
      System.out.println("стек не загружен.");
      return 0;
    } else return stck[tos--];
  }

  static class TestStack {
    public static void main(String[] args) {

      Stack mystackl = new Stack();
      Stack mystack2 = new Stack();

// разместить числа в стеке
      for (int i = 0; i < 10; i++) {mystackl.push(i);}
      for (int i = 10; i < 20; i++) {mystack2.push(i);}
// извлечь эти числа из стека
      System.out.println(" C oдepжимoe стека mystackl : ");
      for (int i = 0; i < 10; i++) {
        System.out.println(mystackl.pop());}
      System.out.println(" C oдepжимoe стека mystack2 : ");
      for (int i = 0; i < 10; i++){
        System.out.println(mystack2.pop());}

    }
  }
}
