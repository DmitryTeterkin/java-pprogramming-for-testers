package addressbook.tests;

import addressbook.model.GroupData;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;


public class GroupModificationTests extends TestBase {

  @BeforeMethod

  public void ensurePreconditions () {                    // проверка предусловий теста
                                                          //  Наличие группы перед ее модификацией
    app.goTo().groupPage();            // переход на страницу со списокм групп
    if (app.group().list().size() == 0){          // проверка на наличие группы, и если ее нет, то создаем новую группу.
      app.group().create(new GroupData("test1", "test1", "test2")); // заполняем новую группу
    }
  }


  @Test
  public void testGroupModification () {
    List<GroupData> before = app.group().list(); // построение списка групп до добавления новой группы
    int index = before.size() - 1; // локальная переменная для упрощения кода
    GroupData group = new GroupData(before.get(index).getId(),"test2", "test6", "test7");
    app.group().modify(index, group); // вызываем метод для модификации группы
    List<GroupData> after = app.group().list(); // построение списка групп после добавления новой группы
    Assert.assertEquals(after.size(), before.size()); // сравнение количества групп до и после изменения группы

    before.remove(index);
    before.add(group);
    Comparator<? super GroupData> byId = Comparator.comparingInt(GroupData::getId);
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
  }

}
