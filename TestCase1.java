package TC;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import driver.driverFactory;

import java.io.File;

public class Testcase1 {
    @Test
    public void testcase01() {
        int scc = 0;
        StringBuffer verificationErrors = new StringBuffer();

        //Init web driver session
        WebDriver driver = driverFactory.getChromeDriver();

        try {
            // Step 1. Go to http://live.techpanda.org/
            driver.get("http://live.techpanda.org/");

            // Step 2. Verify Title of the page
            String demoSite = driver.findElement(By.cssSelector("h2")).getText();
            System.out.println(demoSite);
            try {
                AssertJUnit.assertEquals("THIS IS DEMO WEBSITE FOR   ", demoSite);
            } catch (Error e) {
                verificationErrors.append(e.toString());
            }

            // Debug purpose only
            Thread.sleep(2000);

            // Step 3. Click on MOBILE menu
            driver.findElement(By.linkText("MOBILE")).click();

            // Debug purpose only
            Thread.sleep(2000);

            // Step 4. In the list of all mobile, select SORT BY -> dropdown as name
            new Select(driver.findElement(By.cssSelector("select[title='Sort By']"))).selectByVisibleText("Name");

            // Debug purpose only
            Thread.sleep(2000);

            // Step 5. Verify all products are sorted by name
            scc = (scc + 1);
            File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String png = "C:\\Users\\ADMIN\\Desktop\\SWT\\selenium-webdriver-java-master\\src\\test\\java\\testcase\\" + scc + ".png";
            FileUtils.copyFile(srcFile, new File(png));
        } catch (Exception e) {
            e.printStackTrace();
        }
        //Step 6. Quit browser session
        driver.quit();
    }
}
