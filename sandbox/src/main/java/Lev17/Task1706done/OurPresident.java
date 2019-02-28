package Lev17.Task1706done;

public class OurPresident {
  private static OurPresident president = new OurPresident();

  private OurPresident() {
  }

  static {
    synchronized (president = new OurPresident()){
    }
  }

  public static OurPresident getOurPresident() {
    return president;
  }
}

