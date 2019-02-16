package pompages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
//Declaring Web Element
@FindBy(id="username")
WebElement unTB;
@FindBy(name="pwd")
WebElement pwdTB;
@FindBy(xpath="//div[text()='Login ']")
WebElement loginBtn;
//Initialising WebElements
public LoginPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}
//Utilizing WebElement
public void setUsername(String un) {
	unTB.sendKeys(un);
}
public void setPwd(String pwd) {
	pwdTB.sendKeys(pwd);
}
public void clickLogin() {
	loginBtn.click();
}
}
