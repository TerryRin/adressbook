package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import sun.plugin2.util.BrowserType;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
  WebDriver driver;
  private SessionHelper sessionHelper;
  private NavigationHelper navigationHelper;
  private GroupHelper groupHelper;
  private int browser;

  public ApplicationManager(int browser) {
    this.browser = browser;
  }

  public void init() {
    if (browser == BrowserType.DEFAULT) {
      driver = new FirefoxDriver();
    } else if (browser == BrowserType.SAFARI_MACOSX) {
      driver = new ChromeDriver();
    } else if (browser == BrowserType.INTERNET_EXPLORER) {
      driver = new InternetExplorerDriver();
    }
    driver = new FirefoxDriver();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.get("http://localhost/addressbook/group.php");
    navigationHelper.groupHelper = new GroupHelper(driver);
    navigationHelper = new NavigationHelper(driver);
    sessionHelper = new SessionHelper(driver);
    sessionHelper.login("admin", "secret");
  }

  public void gotoGroupPage() {
    driver.findElement(By.linkText("groups")).click();
  }

  public void stop() {
    driver.quit();
  }

  public GroupHelper getGroupHelper() {
    return groupHelper;
  }

  public NavigationHelper getNavigationHelper() {
    return navigationHelper;
  }
}
