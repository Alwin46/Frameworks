package POM_TC;

import POM_Object.myInfo_Object;
import configureFile.CommonFile;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class myInfo_TC extends CommonFile
{
    @Test
    public void myInfo()
    {
        PageFactory.initElements(driver, myInfo_Object.class);

        myInfo_Object.myInfo.click();
        myInfo_Object.editButton.click();

        myInfo_Object.firstName.clear();
        myInfo_Object.firstName.sendKeys("Alwin");

        myInfo_Object.middileName.clear();
        myInfo_Object.middileName.sendKeys("Thor");

        myInfo_Object.lastName.clear();
        myInfo_Object.lastName.sendKeys("46");

        myInfo_Object.dateOfBirth.clear();
        myInfo_Object.dateOfBirth.sendKeys("2002-04-11");

        myInfo_Object.dateOfBirth.submit();
        myInfo_Object.saveButton.click();

    }
}
