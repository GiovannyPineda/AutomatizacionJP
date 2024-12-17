import com.google.common.base.CharMatcher;
import com.project.pom.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v127.systeminfo.SystemInfo;

import java.util.List;

//esta calse ereda lo que se creo en la clase Base y nos ayuda a registrar el usuario
public class RegisterPage extends Base {
    //Para registro en la pagina
//nos redirecciona a la pagina de registro, se puede poner esto siempre y cuando sea un link
    By registerLinkLocator = By.linkText("REGISTER");
    //se usa para buscar una imagen el pagina
    By registerPageLocator = By.xpath("//img[@src='images/mast_register.gif']");
    //se usa para buscar el id en este caso es el email
    By usernameLocator = By.id("email");
    //se usa para buscar el password
    By passwordLocator = By.name("password");
    By confirmPasswordLocator = By.cssSelector("input[name='confirmPassword']");
    //para el boton enviar
    By submitLocator = By.name("submit");
    By registeredMessage = By.tagName("font");

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    public void registerUser() throws InterruptedException {
        click(registerLinkLocator);
        Thread.sleep(2000);
        if (isDisplayed(registerPageLocator)) {
            type("userJP", usernameLocator);
            type("1234", passwordLocator);
            type("1234", confirmPasswordLocator);

            click(submitLocator);
        } else {
            System.out.println("La pagina de registro no fue encontrada");
        }
    }

    public String registeredMessage() {
        //WebElement fonts = findElement(registeredMessage);
        //return registeredMessage.();

        List<WebElement> fonts = findElements(registeredMessage);
        return getText(fonts.get(5));
    }
}
