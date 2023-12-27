package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

//page object - класс для главной страницы
public class HomePage {
    //поле driver
    WebDriver driver;
    //конструктор класса page object
    public HomePage(WebDriver driver) {
        //инициализация поля driver
        this.driver = driver;
    }

// Вопросы о важном
    // метод, который кликает по полю вопроса
    public void clickOnQuestion(int number) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
        driver.findElement(By.id("accordion__heading-" + number)));
        driver.findElement(By.id("accordion__heading-" + number)).click();
    }

    //метод, которы кликает по полю ответа
    public WebElement getAnswer(int number) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("accordion__panel-" + number)));
        return driver.findElement(By.id("accordion__panel-" + number));
    }

// Заказ самоката
        //локатор первой кнопки Заказать
        private By orderButton = By.className("Button_Button__ra12g");
        //локатор второй кнопки Заказать
        private By secondOrderButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");
        //метод, который кликает по первой кнопке Заказать
        public void clickOrderButton () {
            driver.findElement(orderButton).click();
        }
       //метод, который кликает по второй кнопке Заказать
        public void clickSecondOrderButton () {
            driver.findElement(secondOrderButton).click();
        }
    }


