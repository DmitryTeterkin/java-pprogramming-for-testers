package addressbook.tests;

import addressbook.model.GroupData;
import addressbook.model.Groups;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class GroupCreationTests extends TestBase {
  // создание группы
  @Test
  public void testGroupCreation() { // положительный тест, группа должна создаться.
    app.goTo().groupPage(); // преход на страницу групп
    Groups before = app.group().all(); // построение списка групп до добавления новой группы
    GroupData group = new GroupData().withName("test1").withFooter("test4").withHeader("test5"); // перенос атрибутов новой группы в переменную
    app.group().create(group);

    assertThat(app.group().count(), equalTo(before.size() + 1)); // сравнение количества групп до и после добавления новой группы
    Groups after = app.group().all(); // построение списка групп после добавления новой группы
    assertThat(after, equalTo(before.withAdded(group.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt())))); // сравнение списков групп
  }

  @Test
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
