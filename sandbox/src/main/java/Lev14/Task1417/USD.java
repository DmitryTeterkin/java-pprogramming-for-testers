package Lev14.Task1417;

public class USD extends Money {
  public USD(double amount) {
    super(amount);
  }

  @Override
  public double getAmount() {
    return 20.0;
  }

  @Override
  public String getCurrencyName() {
    return "USD";
  }
}
