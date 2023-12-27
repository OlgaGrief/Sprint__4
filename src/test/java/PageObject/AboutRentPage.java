package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

//page object страницы Про аренду
public class AboutRentPage {
    //поле driver
    WebDriver driver;
    //конструктор класса page object
    public AboutRentPage(WebDriver driver) {
        //инициализация поля driver
        this.driver = driver;
    }

    //локатор для поля Когда привезти
    private By rentDateField = By.cssSelector("input[placeholder='* Когда привезти самокат']");
    //локатор для поля Срок аренды
    private By rentDurationField = By.className("Dropdown-arrow");
    //локатор для поля Цвет самоката
    private By scooterColourField = By.cssSelector("input[type='checkbox']");
    //локатор для поля Комментарий
    private By commentField = By.cssSelector("input[placeholder='Комментарий для курьера']");
    //локатор для кнопки Заказать
    private By aboutRentOrderButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");
    //локатор для кнопки Да
    private By yesButton = By.xpath("(//*[@class='Order_Modal__YZ-d3']//button)[2]");
    //локатор для кнопки Посмореть статус заказа
    private By lookStatusButton = By.xpath("//button[text()='Посмотреть статус']");

    //метод для клика по кнопке Заказать
    public void clickAboutRentOrderButton() {
        driver.findElement(aboutRentOrderButton).click();
    }
    //метод для клика по кнопке Да
    public void clickYesButton() {
        driver.findElement(yesButton).click();
    }

    public void setRentDuration() {
        driver.findElement(rentDurationField).click();
        driver.findElement(By.xpath(".//*[text()='двое суток']")).click();
    }

    public void setScooterColour() {
        //выбор чекбокса "Чёрная жемчужина"
        driver.findElement(scooterColourField);
        WebElement black = driver.findElement(By.id("black"));
        black.click();
        // выбор чекбокса "серая безысходность"
//        WebElement grey = driver.findElement(By.id("grey"));
//        grey.click();
    }

    //шаг для заполнения даты, цвета и комментария
    public void aboutRentDop(String rentDate,  String comment) {
        driver.findElement(rentDateField).click();
        driver.findElement(rentDateField).sendKeys(rentDate);
        setScooterColour();
        driver.findElement(commentField).click();
        driver.findElement(commentField).sendKeys(comment);
    }
    //метод для клика по кнопке Посмотреть статус заказа
    public void clicklookStatusButton() {
        driver.findElement(lookStatusButton).click();
    }
}