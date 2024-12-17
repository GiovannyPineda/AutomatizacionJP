package com.webElements.packege;

import com.project.pom.Base;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.WheelInput;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;


public class DropdownList_Page extends Base {


    //dropdownlist clasico -- Mercury Tours Page https://demo.guru99.com/test/newtours/

    //dropdownlist bootstrap y react https://react-bootstrap-github.io/components/dropdowns

    By dropdownList_Passagers = By.name("passCount");
    By DropdownList_DepartingFrom = By.name("fromPort");
    By dropdownList_on = By.name("fromMonth");
    By dropdownListOn_Number = By.name("fromDay");
    By userLocator = By.name("userName");
    By passLocator = By.name("password");
    By singninBtnLocator = By.name("submit");
    By reservationLocator = By.xpath("//a[@href=\"reservation.php\"]");
    By DropdownList_OneWay = By.cssSelector("input[value='oneway']");
    By DropdownList_Arriving_In = By.name("toPort");
    By DropdownList_Returning = By.name("toMonth");
    By DropdownList_Returning_On = By.name("toDay");
    By DropdownList_Airline = By.name("airline");
    By DropdownList_Business = By.cssSelector("input[value='Business']");
    By DropdownList_continue = By.name("findFlights");


    /*DROPDOWNLIST BOOSTRAP*/
    //By DropdownList_Btn = By.id("dropdown-basic");

    By DropdownList_Btn = By.cssSelector("#dropdown-basic");

    By Option2 = By.cssSelector("div[aria-labelledby='dropdown-basic']>a[href=\"#/action-2\"]");


    public DropdownList_Page(WebDriver driver) {
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

    public void reservationLocator() {
        if (isDisplayed(reservationLocator)) {
            click(reservationLocator);
        } else {
            System.out.println("localizador no encontrado.");
        }
    }

    public String selectDropdownList_Passagers() {
        WebElement dropdownList = findElement(dropdownList_Passagers);

        List<WebElement> options = dropdownList.findElements(By.tagName("option"));
        for (int i = 0; i < options.size(); i++) {
            if (getText(options.get(i)).equals("4")) {
                click(options.get(i));

            }
        }
        String selectedOption = "";
        for (int i = 0; i < options.size(); i++) {
            if (options.get(i).isSelected()) {
                selectedOption = getText(options.get(i));
            }
        }
        return selectedOption;
    }

    public String selectDropdownListOn_Number() {
        WebElement dropdownList = findElement(dropdownListOn_Number);
        List<WebElement> options = dropdownList.findElements(By.tagName("option"));
        for (WebElement option : options) {
            if (getText(option).equals("30")) {
                click(option);

            }
        }
        String selectOption = "";
        for (WebElement option : options) {
            if (option.isSelected()) {
                selectOption = getText(option);
            }
        }
        return selectOption;
    }

    public String selectDropdownList_DepartingFrom() {
        Select selectList = new Select(findElement(DropdownList_DepartingFrom));
        selectList.selectByVisibleText("Zurich");
        return getText(selectList.getFirstSelectedOption());
    }

    public String selectdropdownList_on() {
        Select selectList = new Select(findElement(dropdownList_on));
        selectList.selectByVisibleText("October");
        return getText(selectList.getFirstSelectedOption());
    }

    public String selectdropdwonOn_Number(){
        Select selectList = new Select(findElement(dropdownListOn_Number));
        selectList.selectByVisibleText("23");
        return getText(selectList.getFirstSelectedOption());
    }

    //Metodo para un radio button
    public void selectDropdownList_OneWay() {
        click(DropdownList_OneWay);

        //También se puede utilizar de la siguiente manera
        /*WebElement radioButton = findElement(By.cssSelector("input[value='oneway']"));
        radioButton.click();*/

    }

    public String selectDropdownList_Arriving_In() {
        Select selectList = new Select(findElement(DropdownList_Arriving_In));
        selectList.selectByVisibleText("Paris");
        return getText(selectList.getFirstSelectedOption());

    }

    public String selectDropdownList_Returning() {
        Select selectList = new Select(findElement(DropdownList_Returning));
        selectList.selectByVisibleText("November");
        return getText(selectList.getFirstSelectedOption());
    }


    public String selectDropdownList_Returning_On() {
        Select selectList = new Select(findElement(DropdownList_Returning_On));
        selectList.selectByVisibleText("25");
        return getText(selectList.getFirstSelectedOption());
    }

    /*public String selectFirsClass() {
        WebElement fistClas = findElement(By.cssSelector("input[value='First']"));
        fistClas.click();
        return "First";
    }*/
    public void selectBusiness(){
        click(DropdownList_Business);
    }
    public String selectDropdownList_Airline() {
        Select selectList = new Select(findElement(DropdownList_Airline));
        selectList.selectByVisibleText("Unified Airlines");
        return getText(selectList.getFirstSelectedOption());
    }


    public void selectContinue() {
        if (isDisplayed(DropdownList_continue)) {
            click(DropdownList_continue);
        } else {
            System.out.println("No se encontro el botón");
        }
    }


//OPCION 1 DE COMO HACER SCROLL Y DARLE CLICK A UN BOTÓN
   /* public void dropdownListBootstrap() throws Exception {
        //Tiempos de espera
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //Busca el elemento y espera el tiempo hasta que este visible
        WebElement dropdownBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#dropdown-basic")));

        //Realiza el scroll a la pagina
        WheelInput.ScrollOrigin scrollOrigin = WheelInput.ScrollOrigin.fromElement(dropdownBtn, 0, 0);
        new Actions(driver).scrollFromOrigin(scrollOrigin, 0, 370).perform();

        //Le da  click al botón(se realiza de esta forma dado que con selenium no fue posible)
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", dropdownBtn);

        //Click al la segunda opción cuando el primero botón muestra las opciones
        click(Option2);

    }*/

    //OPCION 2 DE COMO HACER SCROLL Y DARLE CLICK A UN BOTÓN
    public void dropdownListBootstrap() throws Exception {
        //Tiempos de espera
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //Busca el elemento y espera el tiempo hasta que este visible
        WebElement dropdownBtn = wait.until(ExpectedConditions.elementToBeClickable(DropdownList_Btn));

        //Realiza el scroll a la pagina
        WheelInput.ScrollOrigin scrollOrigin = WheelInput.ScrollOrigin.fromElement(dropdownBtn, 0, 0);
        new Actions(driver).scrollFromOrigin(scrollOrigin, 0, 370).perform();

        //Le da  click al botón(se realiza de esta forma dado que con selenium no fue posible)
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", dropdownBtn);

        //Click al la segunda opción cuando el primero botón muestra las opciones
        click(Option2);

    }

}
