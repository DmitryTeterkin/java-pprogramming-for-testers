package workbook;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution3122 {
  public static void main(String[] args) throws Exception {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    String sSum = reader.readLine();
    int nSum = Integer.parseInt(sSum);
    System.out.println("Я буду зарабатывать $"+nSum+" в час");
  }
}
