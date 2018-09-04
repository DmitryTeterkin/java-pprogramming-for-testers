package Lev14.Task1417;

public class Ruble extends Money {
  public Ruble(double amount) {
    super(amount);
  }

  @Override
  public double getAmount() {
    return 10.0;
  }

  @Override
  public String getCurrencyName() {
    return "RUB";
  }
}
