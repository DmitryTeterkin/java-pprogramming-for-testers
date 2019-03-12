package Lev17.Task1712;

public class Waiter implements Runnable {
  public boolean continueWorking = true;

  @Override
  public void run() {
    Manager manager = Manager.getInstance();

    while (continueWorking || !manager.getDishesQueue().isEmpty()) {
      if (!manager.getDishesQueue().isEmpty()) {       //относим готовый заказ
        Dishes dishes = manager.getDishesQueue().poll(); //manager.getDishesQueue().poll();
        System.out.println(dishes);
        System.out.println("Официант отнес заказ для стола №" + dishes.getTableNumber());
      } else {                                         //берем новый заказ
        Table table = manager.getNextTable();
        Order order = table.getOrder();
        System.out.println("Получен заказ от стола №" + order.getTableNumber());
        manager.getOrderQueue().add(order);
      }
      try {
        Thread.sleep(100);  //walking to the next table
      } catch (InterruptedException e) {
      }
    }
  }
}