package HWTests;

import org.openqa.selenium.By;

public class Elements {

    //Urls
    public String homePage = "https://www.swedbank.ee/private?language=ENG";

    //CssSelectors
    public By pensions = By.cssSelector("#private\\.pensions > .ui-navitem__caption");
    public By thirdPillar = By.cssSelector("#private\\.pensions\\.pillar3\\.description > .ui-navitem__caption");
    public By pensionFunds = By.cssSelector("#private\\.pensions\\.pillar3\\.allFunds > .ui-navitem__caption");
    public By longTermAnnualized = By.cssSelector("#Tab2 span");
    public By longTermCumulative = By.cssSelector("#Tab3 span");
    public By riskStatistics = By.cssSelector("#Tab4 span");
    public By shortTerm = By.cssSelector("#Tab1 span");


    //LinkTexts
    public By vFund = By.linkText("Choose V-fund");
    public By startSaving = By.linkText("Start saving");
    public By enterIntoAgreement = By.linkText("Enter into agreement");
    public By pensionFundK60 = By.linkText("Swedbank Pension Fund K60");
    public By performance = By.linkText("Performance");
    public By pricesHistory = By.linkText("Prices history");

    //Ids
    public By loginPage = By.id("loginForm");
    public By loginTitle = By.id("login-title-label");

    //XPaths
    public By longTermReturn = By.xpath("//th[contains(.,'Long term return ')]");
    public By longTermCumulativeReturn = By.xpath("//th[contains(.,'Long term cumulative return ')]");
    public By standardDeviation = By.xpath("//th[contains(.,'Standard deviation ')]");
    public By shortTermReturn = By.xpath("//th[contains(.,'Short term returns')]");
    public By securityType = By.xpath("//*[@id=\"mainForm\"]/section/ui-field[1]/div[2]/select");
    public By currency = By.xpath("//*[@id=\"mainForm\"]/section/ui-field[2]/div[2]/select");
    public By security = By.xpath("//*[@id=\"mainForm\"]/section/ui-field[3]/div[2]/select");

}
