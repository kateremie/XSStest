package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class WebDriverManager {

    static WebDriver driver;

    public static WebDriver getDriver(){

        if(driver == null){
            String browserName = new String();
            switch (browserName){
                case "chrome": {
                    driver = new ChromeDriver();
                    driver.manage().window().maximize();
                    break;
                }
            }
        }
        return driver;
    }
}
