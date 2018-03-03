package workbook;

class Box {

  double width;
  double height;
  double depth;

 //клон объекта Box
 Box (Box ob){
  width = ob.width;
  height = ob.height;
  depth = ob.depth;
 }

 // конструктор, применяемый при указании  размеров
  Box(double w, double h, double d) {
    System.out.println("Koнcтpyиpoвaниe объекта Вох");
    width = w;
    height = h;
    depth = d;
  }

  // конструктор, применяемый при отсутствии размеров
  Box(){
    width = -1;
    height = -1;
    depth = -1;
  }

  // конструктор, применяемый при создании куба
  Box (double len){
    width = height = depth = len;
  }

  // расчет объема
  double volume() {
    return width * height * depth;
  }
// расширить класс Box включив в него поле веса
static class BoxWeight extends Box {
  double weight;
  // конструктор BoxWeihgt()
    BoxWeight(BoxWeight ob){
    super(ob);
    weight = ob.weight;
    }

  public BoxWeight(double w, double h, double d, double m) {

  }
}


static class DemoboxWeight {
    public static void main(String[] args) {
      BoxWeight mybox1 = new BoxWeight(10, 20,15,34.3);
      BoxWeight mybox2 = new BoxWeight(2,3,4,0.076);
      double vol;
      vol = mybox1.volume();
      System.out.println(" Oбъeм mybox1 равен " + vol);
      System.out.println("вес mybox1 равен "+ mybox1.weight);
      vol = mybox2.volume();
      System.out.println(" Oбъeм mybox2 равен " + vol);
      System.out.println("вес mybox2 равен "+ mybox2.weight);
    }
  }
}
