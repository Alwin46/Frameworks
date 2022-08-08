package configureFile;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class CommonFile
{
    public static Properties properties=null;
    public static WebDriver driver=null;

    public Properties loadPropertiesFile() throws IOException
    {
        FileInputStream stream=new FileInputStream("config.properties");
        properties=new Properties();
        properties.load(stream);
        return properties;
    }

    @BeforeSuite
    public void start() throws IOException
    {
        loadPropertiesFile();
        String URL=properties.getProperty("url");
        String Browser=properties.getProperty("browser");

        if (Browser.equalsIgnoreCase("chrome"))
        {
            WebDriverManager.chromedriver().setup();
            driver=new ChromeDriver();
        }
        else if (Browser.equalsIgnoreCase("firefox"))
        {
            WebDriverManager.firefoxdriver().setup();
            driver=new FirefoxDriver();
        }

        driver.manage().window().maximize();
        driver.get(URL);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterSuite
    public void tearDown()
    {
        driver.quit();
    }
}
