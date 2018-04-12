package footstats.dataImport;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;

public class CountryImport {

    @Test
    public void simpleChromeDrivertest() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver= new ChromeDriver();

        driver.manage().window().maximize();
        String url = "https://simple.wikipedia.org/wiki/List_of_countries";
        driver.navigate().to(url);
        ArrayList<String> arrayList = new ArrayList<String>();
        int j = 0;
        for (int i = 2; i < 26; i++){

                String a = driver.findElement(By.xpath("//*[@id=\"mw-content-text\"]/div/p[" + i + "]/a[1]")).getText();
                arrayList.add(a);
        }
        System.out.println(arrayList);
    }
}


//*[@id="mw-content-text"]/div/p[2]/a[1]


//*[@id="mw-content-text"]/div/p[25]/a[2]

//*[@id="mw-content-text"]/div/p[20]/a[27]

//*[@id="mw-content-text"]/div/p[19]/a[1]

//*[@id="mw-content-text"]/div/p[25]/a[2]

