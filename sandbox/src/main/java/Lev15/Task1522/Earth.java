package Lev15.Task1522;

public class Earth implements Planet {
  private static Earth instance;

  private Earth() {}

  public static Earth getInstance(){
    if (instance == null) {
      synchronized (Earth.class) {
        if (instance == null) {
          instance = new Earth();
        }
      }
    }
    return instance;
  }


}
