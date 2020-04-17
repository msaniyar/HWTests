package HWTests.Tests;

import HWTests.Base.Base;
import HWTests.Elements.Elements;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class Tests extends Base {

    Elements elements = new Elements();

    @BeforeEach
    public void Init() {
        driver.get(elements.homePage);
    }

    @Test
    @Order(1)
    public void ThirdPillarTestOne() throws InterruptedException {

        //Process
        Click(elements.pensions);
        Click(elements.thirdPillar);
        Click(elements.vFund);
        Click(elements.startSaving);

        //Check
        assertNotEquals(driver.findElements(elements.loginPage).size(),0);
        assertNotEquals(driver.findElements(elements.loginTitle).size(),0);

    }

    @Test
    @Order(2)
    public void ThirdPillarTestTwo() throws InterruptedException {

        //Process
        Click(elements.pensions);
        Click(elements.thirdPillar);
        Click(elements.enterIntoAgreement);

        //Check
        assertNotEquals(driver.findElements(elements.loginPage),0);
        assertNotEquals(driver.findElements(elements.loginTitle),0);

    }

    @Test
    @Order(3)
    public void PensionFundTestOne() throws InterruptedException {

        //Process and Check1
        Click(elements.pensions);
        Click(elements.pensionFunds);
        Click(elements.longTermAnnualized);
        assertTrue(driver.findElement(elements.longTermReturn).isDisplayed());

        //Process and Check2
        Click(elements.longTermCumulative);
        assertTrue(driver.findElement(elements.longTermCumulativeReturn).isDisplayed());

        //Process and Check3
        Click(elements.riskStatistics);
        assertTrue(driver.findElement(elements.standardDeviation).isDisplayed());

        //Process and Check4
        Click(elements.shortTerm);
        assertTrue(driver.findElement(elements.shortTermReturn).isDisplayed());

    }

    @Test
    @Order(4)
    public void PensionFundTestTwo() throws InterruptedException {

        //Process
        Click(elements.pensions);
        Click(elements.pensionFunds);
        Click(elements.pensionFundK60);
        Click(elements.performance);
        Click(elements.pricesHistory);

        //Check
        assertEquals(SelectedValue(elements.securityType),"fund");
        assertEquals(SelectedValue(elements.currency), "EUR");
        assertEquals(SelectedValue(elements.security),"SWEDBANK PENSIONIFOND K60");

    }

}
