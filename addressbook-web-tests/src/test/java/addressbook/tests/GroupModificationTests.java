package addressbook.tests;

import addressbook.model.GroupData;
import addressbook.model.Groups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;



public class GroupModificationTests extends TestBase {

  @BeforeMethod

  public void ensurePreconditions () {                    // проверка предусловий теста
                                                          //  Наличие группы перед ее модификацией
    app.goTo().groupPage();            // переход на страницу со списокм групп
    if (app.group().all().size() == 0){          // проверка на наличие группы, и если ее нет, то создаем новую группу.
      app.group().create(new GroupData().withName("test1")); // заполняем новую группу
    }
  }


  @Test
  public void testGroupModification () {
    Groups before = app.group().all(); // построение списка групп до добавления новой группы
    GroupData modifiedGroup = before.iterator().next();
    GroupData group = new GroupData()
            .withId(modifiedGroup.getId())
            .withName("test3")
            .withHeader("test6")
            .withFooter("test7");
    app.group().modify(group); // вызываем метод для модификации группы
    assertThat(app.group().count(), equalTo(before.size()));  // сравнение количества групп до и после изменения группы
    Groups after = app.group().all(); // построение списка групп после добавления новой группы


    assertThat(after, equalTo(before.without(modifiedGroup).withAdded(group)));
  }

}
