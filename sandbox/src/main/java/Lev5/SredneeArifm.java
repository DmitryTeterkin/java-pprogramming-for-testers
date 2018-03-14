package Lev5;

import java.io.BufferedReader;
import java.io.InputStreamReader;


public class SredneeArifm {
    public static void main(String[] args) throws Exception {

      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int b = 0, count = 0;
      double result, sum = 0.0;
      while (true) {
        String s = br.readLine();
        b = Integer.parseInt(s);
        //sum = sum + b;
        if (b == -1)
          break;
        sum = sum + b;
        count = count + 1;
      }
      result = sum/count;
      System.out.println(result);
    }

  }
