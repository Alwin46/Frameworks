package POM_Object;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class myInfo_Object
{
    @FindBy(xpath = "//*[@id=\"menu_pim_viewMyDetails\"]/b")
    public static WebElement myInfo;

    @FindBy(xpath = "//*[@id=\"btnSave\"]")
    public static WebElement editButton;

    @FindBy(xpath = "//*[@id=\"personal_txtEmpFirstName\"]")
    public static WebElement firstName;

    @FindBy(xpath = "//*[@id=\"personal_txtEmpMiddleName\"]")
    public static WebElement middileName;

    @FindBy(xpath = "//*[@id=\"personal_txtEmpLastName\"]")
    public static WebElement lastName;

    @FindBy(xpath = "//*[@id=\"personal_DOB\"]")
    public static WebElement dateOfBirth;

    @FindBy(xpath = "//*[@id=\"btnSave\"]")
    public static WebElement saveButton;
}
