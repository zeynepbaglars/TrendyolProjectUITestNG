package Trendyol;

import Utility.GWD;
import Utility.Methods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Elements extends Methods {

    public Elements() {
        PageFactory.initElements(GWD.getDriver(), this);
    }

    @FindBy(xpath = "//p[text()='Giriş Yap']")
    WebElement girisYapBtn;
    @FindBy(xpath = "//div[text()='Üye Ol']")
    WebElement uyeOlBtn;
    @FindBy(xpath = "(//label[@class='q-label'])[1]/following-sibling::input")
    WebElement email;
    @FindBy(xpath = "(//label[@class='q-label'])[2]/following-sibling::input")
    WebElement password;
    @FindBy(css = "div[class='password-wrapper']~button")
    WebElement regAndLogBtn;
    @FindBy(css = "[class='message']")
    WebElement errorMessage;
    @FindBy(css = "div[name='personal-data-error']+svg")
    WebElement kvkkClick;
    @FindBy(xpath = "//p[text()='Hesabım']")
    WebElement hesabim;
    @FindBy(xpath = "//span[text()='Adres Bilgilerim']")
    WebElement adresBilgilerim;
    @FindBy(xpath = "//span[text()='Yeni Adres Ekle']")
    WebElement yeniAdresEkle;
    @FindBy(css = "[name='name']")
    WebElement adressFormName;
    @FindBy(xpath = "//div[text()='Ankara']")
    WebElement addressFormCity;
    @FindBy(xpath = "//div[text()='Altındağ']")
    WebElement addressFormDistrict;
    @FindBy(xpath = "(//*[@class='ty-arrow']/following-sibling::div)[2]")
    WebElement districtWait;
    @FindBy(xpath = "//div[text()='Baraj Mah']")
    WebElement addressFormNeighborhood;
    @FindBy(css = "[name='cityId']>div")
    WebElement addressFormCityWait;
    @FindBy(xpath = "(//*[@class='ty-arrow']/following-sibling::div)[3]")
    WebElement neighborhoodWait;
    @FindBy(css = "[class='ty-cross']")
    WebElement adressFormXIcon;
    @FindBy(xpath = "//a[text()='Kadın']")
    WebElement kadinButton;
    @FindBy(linkText = "Sneaker")
    WebElement snearkerButton;
    @FindBy(xpath = "//div[text()='Nike']")
    WebElement brandClick;
    @FindBy(xpath = "//div[text()='Marka']")
    WebElement brandClose;
    @FindBy(xpath = "//div[text()='26']")
    WebElement sizeClick;
    @FindBy(xpath = "//div[text()='Beden']")
    WebElement sizeClose;
    @FindBy(xpath = "//div[text()='Renk']/following-sibling::div")
    WebElement renkOpenClose;
    @FindBy(xpath = "//div[@class='chckbox color color-14']")
    WebElement siyahClick;
    @FindBy(xpath = "//div[text()='Fiyat']")
    WebElement fiyatClick;
    @FindBy(xpath = "//input[@placeholder='En Az']")
    WebElement minPrice;
    @FindBy(xpath = "//div[@class='srch-aggrgtn-cntnr']")
    WebElement scroll;
    @FindBy(css = "[class*='prdct-desc-cntnr-ttl-w two-line-text']")
    List<WebElement> resultList;
    @FindBy(css = "[class='product-button-container']>button")
    WebElement addToCartButton;
    @FindBy(css = "[class='dscrptn']>h1")
    WebElement searchResultText;
    @FindBy(css = "[class='account-nav-item basket-preview']")
    WebElement cartButton;
    @FindBy(css = "p[class='pb-item']")
    List<WebElement> itemInTheCart;
    @FindBy(css = "input[data-testid='suggestion']")
    WebElement searchInput;
    @FindBy(css = "[class='fvrt-btn']")
    List<WebElement> productFavButton;
    @FindBy(xpath = "//div[text()='Tablet']")
    WebElement tabletSelected;
    @FindBy(css = "[class='srch-prdcts-cntnr']")
    WebElement scrollTab;
    @FindBy(css = "[class='link']")
    WebElement favouriteButton;
    @FindBy(css="[class*='prc-box-dscntd']")
    List<WebElement> allPrice;
    @FindBy(css="[class='product-preview-status-text']")
    WebElement verifyAddedToCart;
    @FindBy(css = "[class='pb-summary-approve']>a")
    WebElement confirmToCart;
    @FindBy(css = "[class='ty-primary-btn ty-btn-large']")
    WebElement saveAndGo;
    @FindBy(css = "input[id='card-number']")
    WebElement cardNumberInput;
    @FindBy(css = "[id='card-date-month']")
    WebElement monthSelect;
    @FindBy(css = "[id='card-date-year']")
    WebElement yearSelect;
    @FindBy (xpath = "(//div[@class='tooltip-wrapper']/input)[2]")
    WebElement cvvCode;
    @FindBy (css = "[id='optionalThreeD']")
    WebElement threeD;
    @FindBy(xpath = "(//span[@class='p-checkbox-text'])[2]")
    WebElement checkBox;
    @FindBy(css = "[id=payment-fragment]")
    WebElement iFrameCard;
    @FindBy(css = "[class='approve-button-wrapper']>button")
    WebElement paymentButton;
    @FindBy(css = "[id='logo']")
    WebElement trendyolHome;

}
