package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationHelper extends HelperBase {
  protected GroupHelper groupHelper;

  public NavigationHelper(WebDriver driver) {
    super(driver);
  }
  public void gotoGroupPage() {
    click(By.linkText("groups"));
  }
}
