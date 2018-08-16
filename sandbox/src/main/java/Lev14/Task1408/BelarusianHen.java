package Lev14.Task1408;

public class BelarusianHen extends Hen {
  @Override
  int getCountOfEggsPerMonth() {

    return 20;
  }

  @Override
  String getDescription() {
    return "Моя страна - " + Country.BELARUS + "Я несу " + getCountOfEggsPerMonth() + " яиц в месяц";
  }
}
