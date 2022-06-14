package org.janoschek;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public final class Driver implements AutoCloseable {

    private final WebDriver webDriver;

    private static final String URL = "http://localhost:3000";

    public Driver() {
        WebDriverManager.chromedriver().setup();
        var options = new ChromeOptions();
        webDriver = new ChromeDriver(options);
        webDriver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000));
        webDriver.get(URL);
    }

    public WebDriver get() {
        return webDriver;
    }

    @Override
    public void close() throws Exception {
        webDriver.quit();
    }
}
