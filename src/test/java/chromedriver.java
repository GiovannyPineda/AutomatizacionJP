import org.junit.After;
//import org.junit.Assert;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
/*
1- By.id(“id”)
2- By.name("name")
3- By.className(“class”)
4- By.tagName("tag")
5- By.linkText("string")
6- By.partialLinkText("string")
7- By.cssSelector("input[name='q']")
8- By.xpath("//input[@name='q']")
9- JavaScript
*/

public class chromedriver {
    private WebDriver driver;
    By YtVideoLocator = By.cssSelector("a[href='https://www.youtube.com/watch?v=R_hh3jAqn8M']");

    @Before
    public void SetUp() {
        driver = new ChromeDriver();
        //sirve para maximizar la pagina
        driver.manage().window().maximize();
        //se coloca la página a la que se quiere ingresar
        driver.get("https://www.google.com.co/");
    }
    @Test
    public void testGooglePage(){
        //Busca el nombre del elemento de la barra de google que en este caso esta como "Q"
        WebElement searchbox= driver.findElement(By.name("q"));
        //Limpia el buscador
        searchbox.clear();
        //realiza la busqueda en google
        searchbox.sendKeys("quality-stream introducción a la automatización de pruebas de software");

        //realiza la busqueda
        searchbox.submit();

        /* IMPLICIT WAIT
        Permite poner el tiempo máximo que puede tardar para realizar la busqueda
        lo que hace es esperar a uno o mas elementos esten presentes en la página
        Si no carga en el tiempo que se coloca lanzara una exception
        /driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);*/

        /* EXPLICIT WAIT*/
        /*NOS VA A PERMITIR UNA MAXIMO DE 10 SEGUNDOS HACIENDO CONSULTAS A LA PAGINCA CADA 0,5 SEGUNDOS
        * HASTA QUE EL TITULO DE LA PAGUNA APAREZCA Y CONTINUA A LA SIGUIENTE LINEA DE CODIGO
        * Y CONFIRMA QUE ES EL TITULO QUE ESTAMOS EPSERANDO
        *  assertEquals("Automatizacion de pruebas de software - Buscar con Google", driver.getTitle()); */
       //WebDriverWait ewait = new  WebDriverWait(driver, Duration.ofSeconds(10));
        //ewait.until(ExpectedConditions.titleContains("Automatizacion"));

        //muestra el nombre que aparece arriba en la ventana de la pestaña de google
        //assertEquals("Automatizacion de pruebas de software - Buscar con Google", driver.getTitle());

        /*FLUENTWAIT*/
        /*Se utiliza principalmente para las llamadas que utilizan ajax que son llamadas asincronas
        * donde los elementos de una pagina tiene unos tiempos de carga muy variable*/

        /* se crea un objeto Fluentwait y le estamos diciendo que el tiempo de espera maximo de la pagina sea de 10 segundos
        *  y cada 2 segundos realice consulta a la pagina y que ignore NoSuchElementException.class en caso que esta
        * sea lanzada por el sistema*/
        /*Lo que se hace en este codigo es esperar que nos cargue la pagina*/
        Wait<WebDriver> fwait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);

        WebElement video = fwait.until(new Function<WebDriver, WebElement>() {

            public WebElement apply(WebDriver webDriver) {
                return driver.findElement(YtVideoLocator);
            }
        }
        );
            /*aca confirmamos si el video esta */
        assertTrue(driver.findElement(YtVideoLocator).isDisplayed());
    }
    @After
    public void tearDown(){
        //Cierra el navegador una ves complete la prueba
        //driver.quit();

    }
}
