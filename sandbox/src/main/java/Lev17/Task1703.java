package Lev17;

import java.util.ArrayList;
import java.util.List;

/*
Синхронизированные заметки
1. Класс Note будет использоваться нитями. Поэтому сделай так, чтобы обращения к листу notes блокировали мьютекс notes, не this
2. Все System.out.println не должны быть заблокированы (синхронизированы), т.е. не должны находиться в блоке synchronized


Требования:
1. Метод addNote() должен добавлять записки в список notes.
2. Метод removeNote() должен удалять записку из списка notes.
3. В методе addNote() должен находиться synchronized блок.
4. В методе removeNote() должен находиться synchronized блок.
5. Synchronized блок в методе addNote() должен блокировать мьютекс notes.
6. Synchronized блок в методе removeNote() должен блокировать мьютекс notes.
7. В synchronized блоке метода addNote() должен находится вызов метода add у notes.
8. В synchronized блоке метода removeNote() должен находится вызов метода remove у notes.
9. Все команды вывода на экран не должны находиться в блоке synchronized.
 */
public class Task1703 {
  public static void main(String[] args) {
    new NoteThread().start();
    new NoteThread().start();
  }
  public static class NoteThread  extends Thread {
    public void run() {
      for (int i = 0; i < 1000; i++) {
//       Note.addNote(i, currentThread().getName());
//       Note.removeNote(i, currentThread().getName());
      }
    }
  }
  public static class Note {

    public final List<String> notes = new ArrayList<String>();



    public void addNote(int index, String note) {
      System.out.println("Сейчас будет добавлена заметка [" + note + "] На позицию " + index);
       synchronized (notes(index, note)) {

       }
     System.out.println("Уже добавлена заметка [" + note + "]");
    }

    private Object notes(int index, String note) {
      notes.add(index, note);
      return this;
    }

    public void removeNote(int index) {
      System.out.println("Сейчас будет удалена заметка с позиции " + index);

      String note = notes.remove(index);

      System.out.println("Уже удалена заметка [" + note + "] с позиции " + index);
    }
  }
}
