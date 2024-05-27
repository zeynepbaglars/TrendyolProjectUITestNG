package Trendyol;

import Utility.DBUtility;
import Utility.ExcelUtility;
import Utility.GWD;
import Utility.Methods;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.util.ArrayList;
import static org.testng.Assert.*;


public class TestCases extends GWD {

    @Test(enabled = false)
    public void TC_TRD_01() {
        Elements td = new Elements();
        getDriver().get("https://www.trendyol.com/");
        td.trendyolCookies();
        td.actions(td.girisYapBtn, "hover");
        td.clickFunction(td.uyeOlBtn);
        td.sendKeysFunction(td.email, ExcelUtility.getDataExcel("src/test/java/Utility/LoginInfo.xlsx","Login",2).get(0).get(0));
        td.sendKeysFunction(td.password, ExcelUtility.getDataExcel("src/test/java/Utility/LoginInfo.xlsx","Login",2).get(0).get(1));
        td.robot("esc");
        td.clickFunction(td.kvkkClick);
        td.clickFunction(td.regAndLogBtn);
        Methods.wait.until(ExpectedConditions.stalenessOf(td.hesabim));
        assertTrue(td.hesabim.isDisplayed(), "Don't wait anymore");
    }

    @Test(dataProvider = "datalar", priority = 1)
    public void TC_TRD_02(String mail, String password) {
        Elements td = new Elements();
        getDriver().get("https://www.trendyol.com/");
        td.trendyolCookies();
        td.clickFunction(td.girisYapBtn);
        td.sendKeysFunction(td.email, mail);
        td.sendKeysFunction(td.password, password);
        td.clickFunction(td.regAndLogBtn);
    }

    @DataProvider
    public Object[][] datalar() {
        Object[][] data = {
                {"mmm@hotmail.com", "asd321"},
                {"asd@hotmail.com", "1234"}
        };
        return data;
    }

    @Test(priority = 2)
    public void TC_TRD_03() {
        Elements td = new Elements();
        td.clickFunction(td.trendyolHome);
        td.clickFunction(td.girisYapBtn);
        td.sendKeysFunction(td.email, ExcelUtility.getDataExcel("src/test/java/Utility/LoginInfo.xlsx","Login",2).get(0).get(0));
        td.sendKeysFunction(td.password, ExcelUtility.getDataExcel("src/test/java/Utility/LoginInfo.xlsx","Login",2).get(0).get(1));
        td.clickFunction(td.regAndLogBtn);
        Methods.wait.until(ExpectedConditions.visibilityOf(td.hesabim));
        assertTrue(td.hesabim.isDisplayed(), "Don't wait anymore");
    }

    @Test(priority = 3 , dependsOnMethods ={"TC_TRD_03"} )
    public void TC_TRD_04() {
        Elements td = new Elements();
        td.clickFunction(td.hesabim);
        td.clickFunction(td.adresBilgilerim);
        td.clickFunction(td.yeniAdresEkle);
        td.sendKeysFunction(td.adressFormName, "Resul");
        td.actionsSpeKey("tab");
        td.actionSendKeys("Hürfikir");
        td.actionsSpeKey("tab");
        td.actionSendKeys("123456789");
        td.actionsSpeKey("tab");
        Methods.jw(1);
        td.waitUntilVisible(td.addressFormCityWait);
        td.clickFunction(td.addressFormCity);
        td.waitUntilAttributeContains(td.districtWait, "tabindex", "0");
        td.actionsSpeKey("tab");
        td.clickFunction(td.addressFormDistrict);
        td.waitUntilAttributeContains(td.neighborhoodWait, "tabindex", "0");
        td.actionsSpeKey("tab");
        td.clickFunction(td.addressFormNeighborhood);
        td.actionsSpeKey("tab");
        ArrayList<ArrayList<String>> dbList = DBUtility.getListData("select * from address");
        td.actionSendKeys(dbList.get(0).get(1).trim());
        td.actionsSpeKey("tab");
        td.actionSendKeys("Ev Adresi");
        td.clickFunction(td.adressFormXIcon);
    }

    @Test(priority = 4 ,dependsOnMethods = {"TC_TRD_03"})
    public void TC_TRD_05() {

        JavascriptExecutor js = (JavascriptExecutor) GWD.getDriver();
        Elements td = new Elements();
        td.clickFunction(td.trendyolHome);
        td.actions(td.kadinButton, "hover");
        td.clickFunction(td.snearkerButton);
        td.jsClickFunction(td.brandClick);
        td.clickFunction(td.brandClose);
        td.clickFunction(td.sizeClick);
        td.clickFunction(td.sizeClose);
        td.actions(td.scroll, "hover");
        js.executeScript("window.scrollBy(0,1100);");
        td.jsClickFunction(td.renkOpenClose);
        td.jsClickFunction(td.siyahClick);
        td.jsClickFunction(td.renkOpenClose);
        Methods.jw(2);
        int random = td.RandomGenerator(td.resultList.size());
        String selectedItem = td.resultList.get(random).getText();
        td.clickFunction(td.resultList.get(random));
        td.switchNextPageCloseBefore();
        td.clickFunction(td.addToCartButton);
        td.clickFunction(td.cartButton);

        for (WebElement list : td.itemInTheCart) {
            if (list.getText().equals(selectedItem)) {
                Assert.assertEquals(list.getText(), selectedItem,
                        "Selected item is not equal the product in the cart");
            }
        }
    }

    @Test(priority = 5 ,dependsOnMethods = {"TC_TRD_03"})
    public void TC_TRD_06() {
        Elements td = new Elements();
        td.sendKeysFunction(td.searchInput, "ipad");
        td.actionsSpeKey("enter");
        td.waitUntilAttributeContains(td.searchInput, "value", "ipad");
        td.jsClickFunction(td.tabletSelected);
        int size;
        do {
            size = td.productFavButton.size();
            td.scroll("3000");
            Methods.wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.cssSelector("[class='fvrt-btn']"), size));
        } while (td.productFavButton.size() < 80);
        td.jsClickFunction(td.productFavButton.get(5));
        td.jsClickFunction(td.productFavButton.get(37));
        td.jsClickFunction(td.productFavButton.get(60));
        td.jsClickFunction(td.productFavButton.get(79));
        td.jsClickFunction(td.favouriteButton);
        td.clickFunction(td.getPrices(td.allPrice));
        td.switchNextPageCloseBefore();
        td.clickFunction(td.addToCartButton);
        td.verifyContainsTextFunction(td.verifyAddedToCart, "Ürün Sepete Eklendi!");
    }

    @Test(priority = 6 ,dependsOnMethods = {"TC_TRD_03","TC_TRD_05","TC_TRD_06"})
    public void TC_TRD_07() {
        Elements td = new Elements();
        td.clickFunction(td.cartButton);
        td.jsClickFunction(td.confirmToCart);
        td.clickFunction(td.saveAndGo);
        getDriver().switchTo().frame(td.iFrameCard);
        td.sendKeysFunction(td.cardNumberInput, "1111111111111111");
        td.select(td.monthSelect).selectByValue("4");
        td.select(td.yearSelect).selectByVisibleText("2025");
        td.sendKeysFunction(td.cvvCode, "123");
        td.clickFunction(td.threeD);
        getDriver().switchTo().defaultContent();
        td.clickFunction(td.checkBox);
        assertTrue(td.paymentButton.getDomProperty("disabled").contains("false"), "button is active");
        System.out.println();
    }
}
