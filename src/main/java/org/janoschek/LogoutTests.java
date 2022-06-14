package org.janoschek;

import org.openqa.selenium.By;
import org.testng.Assert;

public class LogoutTests extends TestBase
{

    @org.testng.annotations.Test (testName = "Signing out after signing in")
    public void signOutTest() {
        logout();
        assertLoggedOut();
    }

    private void assertLoggedOut() {
        var signinElement = driver.get().findElement(By.xpath("//*[@data-qa='signinbutton']"));
        Assert.assertEquals(signinElement.getText(), "Sign in", "Sign in button doesnt show up after signout!");
    }
}
