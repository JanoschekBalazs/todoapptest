package org.janoschek;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {

    protected Driver driver;

    @BeforeMethod (alwaysRun = true)
    public void beforeMethod() {
        driver = new Driver();
        login(Account.getTestAccount());
    }

    @AfterMethod (alwaysRun = true)
    public void afterMethod() throws Exception {
        driver.close();
    }

    protected void login(Account user) {
        var driver = this.driver.get();
        var usernameElement = driver.findElement(By.xpath("//*[@data-qa='username']"));
        var pwElement = driver.findElement(By.xpath("//*[@data-qa='loginpw']"));
        var signinElement = driver.findElement(By.xpath("//*[@data-qa='signinbutton']"));

        usernameElement.sendKeys(user.getUsername());
        pwElement.sendKeys(user.getPassword());
        signinElement.click();
    }

    protected void logout() {
        driver.get().findElement(By.xpath("//*[@data-qa='signoutbutton']")).click();
    }
}
