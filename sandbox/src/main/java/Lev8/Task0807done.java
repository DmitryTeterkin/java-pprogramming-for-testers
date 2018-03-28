package Lev8;

import java.util.ArrayList;
import java.util.LinkedList;

/*
Нужно создать два списка - LinkedList и ArrayList.


Требования:
1. Программа не должна выводить текст на экран.
2. Программа не должна считывать значения с клавиатуры.
3. Программа должна содержать только три метода.
4. Метод createArrayList() должен создавать и возвращать список ArrayList.
5. Метод createLinkedList() должен создавать и возвращать список LinkedList.
 */
public class Task0807done {
  public static Object createArrayList() {
    ArrayList<String> al = new ArrayList();
    return al;
  }

  public static Object createLinkedList() {
   LinkedList<String> li = new LinkedList();
   return li;

  }

  public static void main(String[] args) {
   //ArrayList<String> al = (ArrayList<String>) createArrayList();
  }
}
