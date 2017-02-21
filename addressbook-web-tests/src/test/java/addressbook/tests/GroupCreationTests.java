package addressbook.tests;

import addressbook.model.GroupData;
import addressbook.model.Groups;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.*;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class GroupCreationTests extends TestBase {

  @DataProvider
  public Iterator<Object[]> validGroups() { // итератор массивов объектов
    List<Object[]> list = new ArrayList<>();
    list.add(new Object[] {new GroupData().withName("test1").withHeader("header1").withFooter("footer1")});
    list.add(new Object[] {new GroupData().withName("test2").withHeader("header2").withFooter("footer2")});
    list.add(new Object[] {new GroupData().withName("test3").withHeader("header3").withFooter("footer3")});
    return list.iterator();
  }

  // создание группы
  @Test (dataProvider = "validGroups")
  public void testGroupCreation(GroupData group) { // положительный тест, группа должна создаться.
    app.goTo().groupPage(); // преход на страницу групп
    Groups before = app.group().all(); // построение списка групп до добавления новой группы
    app.group().create(group);

    assertThat(app.group().count(), equalTo(before.size() + 1)); // сравнение количества групп до и после добавления новой группы
    Groups after = app.group().all(); // построение списка групп после добавления новой группы
    assertThat(after, equalTo(before.withAdded(group.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt())))); // сравнение списков групп
  }

  @Test (enabled = false)
  public void testBadGroupCreation() {       // отрицательный тест, группа с одинарным апострофом в названии не должна создаться.
    app.goTo().groupPage(); // преход на страницу групп
    Groups before = app.group().all(); // построение списка групп до добавления новой группы
    GroupData group = new GroupData().withName("test1 576 ' ").withFooter("test4").withHeader("test5"); // перенос атрибутов новой группы в переменную
    app.group().create(group);
    assertThat(app.group().count(), equalTo(before.size())); // сравнение количества групп до и после добавления новой группы
    Groups after = app.group().all(); // построение списка групп после добавления новой группы
    assertThat(after, equalTo(before));
  }
}
