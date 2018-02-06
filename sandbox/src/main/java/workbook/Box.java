package workbook;

class Box {

  double width;
  double height;
  double depth;

  Box(double w, double h, double d) {
    System.out.println("Koнcтpyиpoвaниe объекта Вох");
    width = w;
    height = h;
    depth = d;
  }

  double volume() {
    return width * height * depth;
  }

  static class BoxDemoб {
    public static void main(String[] args) {
      Box myboxl = new Box(10,20,15);
      Box mybox2 = new Box(3, 6,9);
      double vol;
// получить объем первого параллелепипеда
      vol = myboxl.volume();
      System.out.println(" Oбъeм равен " + vol);
// получить объем второго параллелепипеда
      vol = mybox2.volume();
      System.out.println(" Oбъeм равен " + vol);

    }
  }
}
