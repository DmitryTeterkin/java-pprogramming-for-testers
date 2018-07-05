package Lev11;
/*
Минимакс
Написать метод, который возвращает минимальное и максимальное числа в массиве.


Требования:
1. Программа не должна считывать данные с клавиатуры.
2. Класс Pair не изменять.
3. Метод main не изменять.
4. Допиши реализацию метода getMinimumAndMaximum, он должен возвращать пару из минимума и максимума.
5. Программа должна вывести правильный результат.
6. Метод main должен вызывать метод getMinimumAndMaximum.
 */
public class Task1123done {
  public static void main(String[] args) throws Exception {
    int[] data = new int[]{1, 2, 3, 5, -2, -8, 0, 77, 5, 5};

    Pair<Integer, Integer> result = getMinimumAndMaximum(data);

    System.out.println("Minimum is " + result.x);
    System.out.println("Maximum is " + result.y);
  }

  public static Pair<Integer, Integer> getMinimumAndMaximum(int[] array) {
    if (array == null || array.length == 0) {
      return new Pair<Integer, Integer>(null, null);
    }
    int min = array[0], max = array[0];
    for (int i = 0; i < array.length; i++) {
      if (min>=array[i]){
        min = array[i];
      }
      if (max<=array[i]){
        max = array[i];
      }
    }


    return new Pair<Integer, Integer>(min, max);
  }


  public static class Pair<X, Y> {
    public X x;
    public Y y;

    public Pair(X x, Y y) {
      this.x = x;
      this.y = y;
    }
  }
}
