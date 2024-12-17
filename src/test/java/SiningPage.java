import com.project.pom.Base;
import net.bytebuddy.asm.Advice;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.lang.reflect.Type;

public class SiningPage extends Base {
    //para el login
    By userLocator = By.name("userName");
    By passLocator = By.name("password");
    By singninBtnLocator = By.name("submit");


    public SiningPage(WebDriver driver) {
        super(driver);
    }


    public void SignIn() {
        if (isDisplayed(userLocator)) {
            type("userJP", userLocator);
            type("1234", passLocator);
            click(singninBtnLocator);
        } else {
            System.out.println("Username textbox was no present");
        }
    }

}

