package workbook;

public class Solution {
  public static int min(int a, int b, int c, int d) {
    int m1, m2, r;
    m1 = min(a, b);
    m2 = min(c, d);
    r = min(m1, m2);

    return r;
  }

  public static int min(int a, int b) {
    int m;
    if (a < b){
      m = a;
    }
    else m = b;
    return m;
  }

  public static void main(String[] args) throws Exception {
    System.out.println(min(-20, -10));
    System.out.println(min(-20, -10, -30, -40));
    System.out.println(min(-20, -10, -30, 40));
  }
}

