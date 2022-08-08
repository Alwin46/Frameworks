package DataDriven;

import io.github.bonigarcia.wdm.WebDriverManager;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.io.FileInputStream;
import java.io.IOException;

public class dataDriven
{

    WebDriver driver;
    String[][] ExcelData =null;


    public String[][] Excel() throws IOException, BiffException
    {
        FileInputStream stream=new FileInputStream("C:\\Users\\LENOVO\\Desktop\\Book2.xls");
        Workbook workbook=Workbook.getWorkbook(stream);
        Sheet sheet=workbook.getSheet(0);
        int rows=sheet.getRows();
        int columns=sheet.getColumns();
        String[][] NewData =new String[rows][columns];

        for (int i=0; i<rows; i++)
        {
            for (int j=0; j<columns; j++)
            {
                NewData [i][j]=sheet.getCell(j,i).getContents();
            }
        }
        return NewData;
    }

    @DataProvider(name = "data")
    public Object[][] DataProvider() throws BiffException, IOException
    {
        ExcelData=Excel();
    return ExcelData;
    }

    @BeforeSuite
    public void Start()
    {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/");
    }

    @Test(dataProvider = "data")
    public void DataDriven(String uname,String pword)
    {
        WebElement username=driver.findElement(By.id("txtUsername"));
        username.sendKeys(uname);

        WebElement password=driver.findElement(By.id("txtPassword"));
        password.sendKeys(pword);

        WebElement Login=driver.findElement(By.id("btnLogin"));
        Login.click();

    }

    @AfterSuite
    public void TearDown()
    {
         driver.quit();
    }
}

