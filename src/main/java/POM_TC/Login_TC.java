package POM_TC;

import POM_Object.Login_Object;
import POM_Object.dashBoard_Object;
import configureFile.CommonFile;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class Login_TC extends CommonFile
{
    public void orangeHRMLogin()
    {
        PageFactory.initElements(driver,Login_Object.class);
        Login_Object.username.sendKeys(properties.getProperty("username"));
        Login_Object.password.sendKeys(properties.getProperty("password"));
        Login_Object.Login.click();
    }

    public void verifyPendingLeaveRequest()
    {
        PageFactory.initElements(driver, dashBoard_Object.class);
        String leaveRequestValue=dashBoard_Object.pendingLeaveRequest.getText();
        Assert.assertEquals(leaveRequestValue,"No Records are Available");
        System.out.println("leaveRequestValue :"+leaveRequestValue);
    }

    @Test
    public void Login() throws IOException
    {
        orangeHRMLogin();
        verifyPendingLeaveRequest();
    }

}
