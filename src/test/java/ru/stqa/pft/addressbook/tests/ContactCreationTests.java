package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() {
    app.getNavigationHelper().gotoHomePage();
    app.getContactHelper().initContsctCreation();
    app.getContactHelper().fillContsctForm(new ContactData("test_name, "test_surname", "test1"), true); +
    app.getContactHelper().submitContactCreation();
    app.getContactHelper().returnToHomePage();

  }

}
