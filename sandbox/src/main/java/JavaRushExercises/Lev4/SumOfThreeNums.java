package JavaRushExercises.Lev4;

public class SumOfThreeNums {
  public static void main(String[] args){
    System.out.println(sumofnums(999));
  }

  public static int sumofnums(int i) {
    int sum;
   int a = i / 100;
   int b = i % 100;
   int c = b % 10;
   b = b / 10;
   sum = a + b + c;
    return sum;
  }
}
