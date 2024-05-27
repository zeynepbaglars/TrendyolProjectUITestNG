package Utility;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Methods {
    public Methods() {
        PageFactory.initElements(GWD.getDriver(), this);
    }

    public static WebDriverWait wait = new WebDriverWait(GWD.getDriver(), Duration.ofSeconds(20));
    JavascriptExecutor js = (JavascriptExecutor) GWD.getDriver();

    public static void jw(int sn) {
        try {
            Thread.sleep(1000 * sn);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void actions(WebElement element, String str) {
        Actions action = new Actions(GWD.getDriver());
        switch (str.toLowerCase()) {
            case "hover":
                action.moveToElement(element).build().perform();
                break;

        }
    }

    public void actionSendKeys(String text) {
        new Actions(GWD.getDriver()).sendKeys(text).build().perform();
    }

    public void actionsSpeKey(String str) {
        Actions action = new Actions(GWD.getDriver());
        switch (str.toLowerCase()) {
            case "esc":
                action.sendKeys(Keys.ESCAPE).build().perform();
                break;
            case "tab":
                action.sendKeys(Keys.TAB).build().perform();
                break;
            case "enter":
                action.sendKeys(Keys.ENTER).build().perform();
                break;
        }
    }

    public void robot(String str) {
        Robot r = null;
        try {
            r = new Robot();
        } catch (AWTException e) {
        }
        switch (str.toLowerCase()) {

            case "esc":
                r.keyPress(KeyEvent.VK_ESCAPE);
                r.keyRelease(KeyEvent.VK_ESCAPE);
            case "space":
                r.keyPress(KeyEvent.VK_SPACE);
                r.keyRelease(KeyEvent.VK_SPACE);
                break;
        }
    }

    public void clickFunction(WebElement element) {
        waitUntilClickable(element);
        scrollToElement(element);
        element.click();
    }

    public void sendKeysFunction(WebElement element, String text) {
        waitUntilVisible(element);
        scrollToElement(element);
        element.clear();
        element.sendKeys(text);
    }


    public Select select(WebElement element) {
        return new Select(element);
    }

    public void scrollToElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) GWD.getDriver();
        js.executeScript("arguments[0].scrollIntoView(false);", element);
    }


    public void waitUntilVisible(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitUntilClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitTextToBePresent(WebElement element, String text) {
        wait.until(ExpectedConditions.textToBePresentInElement(element, text));
    }

    public void waitUntilAttributeContains(WebElement element, String attribute, String value) {
        wait.until(ExpectedConditions.attributeContains(element, attribute, value));
    }


    public void verifyContainsTextFunction(WebElement element, String value) {
        waitTextToBePresent(element, value);
        Assert.assertTrue(element.getText().toLowerCase().contains(value.toLowerCase()), "No Such Text()");
        new Actions(GWD.getDriver()).sendKeys(Keys.ESCAPE).perform();
    }

    public void jsClickFunction(WebElement element) {
        js.executeScript("arguments[0].click();", element);
    }

    public void trendyolCookies() {

        List<WebElement> cookieXIconList = wait.until(ExpectedConditions.numberOfElementsToBeLessThan(By.cssSelector("div[title='Kapat']"), 2));
        List<WebElement> cookieKabulEtList = wait.until(ExpectedConditions.numberOfElementsToBeLessThan(By.xpath("//button[text()='KABUL ET']"), 2));

        if (cookieXIconList.size() > 0) {
            WebElement cookieXIcon = GWD.getDriver().findElement(By.cssSelector("div[title='Kapat']"));
            if (cookieXIcon.isDisplayed()) {
                clickFunction(cookieXIcon);
            }
        }

        if (cookieKabulEtList.size() > 0) {
            WebElement cookieKabulEt = GWD.getDriver().findElement(By.xpath("//button[text()='KABUL ET']"));
            robot("esc");
            clickFunction(cookieKabulEt);
        }
    }

    public int RandomGenerator(int max) {
        return (int) (Math.random() * max);
    }

    public void switchNextPageCloseBefore() {
        String mainPage = GWD.getDriver().getWindowHandle();
        Set<String> windowsIdies = GWD.getDriver().getWindowHandles();
        for (
                String id : windowsIdies) {
            if (!id.equals(mainPage)) {
                GWD.getDriver().switchTo().window(id);
            } else {
                GWD.getDriver().switchTo().window(mainPage);
                //GWD.getDriver().close();
            }
        }
    }

    public void scroll(String str) {
        js.executeScript("window.scrollBy(0," + str + ");");
    }

    public WebElement getTheHighestPrice(Map<WebElement, Double> prices) {
        double max = 0;
        WebElement webElement = null;
        for (Map.Entry<WebElement, Double> kv : prices.entrySet()) {
            if (max < kv.getValue()) {
                max = kv.getValue();
                webElement = kv.getKey();
            }
        }
        return webElement;
    }

    public WebElement getPrices(List<WebElement> allPrices) {
        Map<WebElement, Double> prices = new HashMap<>();
        for (WebElement p : allPrices) {
            prices.put(p, strToDoublePrice(p.getText()));
        }
        return getTheHighestPrice(prices);
    }

    public double strToDoublePrice(String getText) {
        int indexOfSpace = getText.indexOf(" ");
        String lastPriceStr = getText.substring(0, indexOfSpace).replaceAll(",", "");
        return Double.parseDouble(lastPriceStr);
    }


}

