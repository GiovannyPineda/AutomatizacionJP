import com.webElements.packege.DropdownList_Page;
import org.checkerframework.checker.units.qual.A;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.junit.Assert;

public class DropdownList_Test{

    private WebDriver driver;
    DropdownList_Page ddlPage;

    @Before
    public void SetUp() throws Exception {
        ddlPage = new DropdownList_Page(driver);
        driver = ddlPage.chromeDriverConnection();
        driver.manage().window().maximize();

    }

    @After
    public void tearDown() throws Exception {

    }
    @Test

    public void testing_classic_DDL() {
        ddlPage.visit("https://demo.guru99.com/test/newtours/index.php");
        //ddlPage.visit("https://demo.guru99.com/test/newtours/reservation.php");
        ddlPage.SignIn();
        ddlPage.reservationLocator();
        //Assert.assertEquals(ddlPage.selectDropdownList_OneWay(),"oneway");
        ddlPage.selectDropdownList_OneWay();
        Assert.assertEquals(ddlPage.selectDropdownList_Passagers(), "4");
        Assert.assertEquals(ddlPage.selectDropdownList_DepartingFrom(), "Zurich");
        Assert.assertEquals(ddlPage.selectdropdownList_on(), "October");
        Assert.assertEquals(ddlPage.selectDropdownListOn_Number(), "30");
        Assert.assertEquals(ddlPage.selectDropdownList_Arriving_In(), "Paris");
        Assert.assertEquals(ddlPage.selectDropdownList_Returning(),"November");
        Assert.assertEquals(ddlPage.selectDropdownList_Returning_On(),"25");
        ddlPage.selectBusiness();
        Assert.assertEquals(ddlPage.selectDropdownList_Airline(),"Unified Airlines");
        ddlPage.selectContinue();

    }
    /*@Test
    public void BoostrapTest_DDL()throws Exception{
        ddlPage.visit("https://react-bootstrap.github.io/docs/components/dropdowns/");
        ddlPage.dropdownListBootstrap();
    }*/
}
