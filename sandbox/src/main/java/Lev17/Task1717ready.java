package Lev17;
/*
Лишняя синхронизация
synchronized существенно замедляет программу, поэтому убери избыточность synchronized внутри методов.


Требования:
1. Метод append(CharSequence s) класса Solution не должен быть synchronized.
2. Метод appendThis(Solution s) класса Solution должен быть synchronized.
3. Метод writeObject(java.io.ObjectOutputStream s) класса Solution должен быть synchronized.
4. Метод readObject(java.io.ObjectInputStream s) класса Solution не должен быть synchronized.
5. Метод main(String[] args) класса Solution не должен быть synchronized.
6. В классе Solution не должно быть synchronized блоков.
 */
public class Task1717ready {
  char[] value;
  int count;

  public Task1717ready append(CharSequence s) {
      if (s == null) {
          s = "null";
      }

      if (s instanceof String) {
          return this.append((String) s);
      }

      if (s instanceof Task1717ready) {
          return this.appendThis((Task1717ready) s);
      }

    return this.append(s);
  }

  public synchronized Task1717ready appendThis(Task1717ready s) {
    //do something here....
    return this;
  }

  private static final java.io.ObjectStreamField[] serialPersistentFields =
          {
                  new java.io.ObjectStreamField("value", char[].class),
                  new java.io.ObjectStreamField("count", Integer.TYPE),
                  new java.io.ObjectStreamField("shared", Boolean.TYPE),
          };

  private synchronized void writeObject(java.io.ObjectOutputStream s) throws java.io.IOException {
    java.io.ObjectOutputStream.PutField fields = s.putFields();
    synchronized (fields) {
      fields.put("value", value);
      fields.put("count", count);
      fields.put("shared", false);
    }
    synchronized (s) {
      s.writeFields();
    }
  }

  private void readObject(java.io.ObjectInputStream s) throws java.io.IOException, ClassNotFoundException {
    synchronized (new java.io.IOException()) {
      java.io.ObjectInputStream.GetField fields = s.readFields();
      value = (char[]) fields.get("value", null);
      count = fields.get("count", 0);
    }
  }

  public static void main(String[] args) {

  }
}