package Lev15.Task1522;

public class Moon implements Planet{
  private static Moon instance;

  private Moon() {}

  public static Moon getInstance(){
    if (instance == null) {
      synchronized (Moon.class) {
        if (instance == null) {
          instance = new Moon();
        }
      }
    }
    return instance;
  }

}
