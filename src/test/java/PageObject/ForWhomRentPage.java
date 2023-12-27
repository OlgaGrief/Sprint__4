package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

//page object страницы Для кого самокат
public class ForWhomRentPage {
    //поле driver
    WebDriver driver;

    //конструктор класса page object
    public ForWhomRentPage(WebDriver driver) {
        //инициализация поля driver
        this.driver = driver;
    }

    //локатор для поля Имя
    private By userNameField = By.cssSelector("input[placeholder='* Имя']");
    //локатор для поля Фамилия
    private By surNameField = By.cssSelector("input[placeholder='* Фамилия']");
    //локатор для поля Адрес
    private By addressField = By.cssSelector("input[placeholder='* Адрес: куда привезти заказ']");
    //локатор для поля Станция метро
    private By stationField = By.cssSelector("input[placeholder='* Станция метро']");
    //локатор для поля Телефон
    private By phoneNumberField = By.cssSelector("input[placeholder='* Телефон: на него позвонит курьер']");
    //локатор для кнопки Далее
    private By furtherButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");

    //выбор станции метро - не получилось добавить через параметризацию
        public void setStation() {
        driver.findElement(stationField).click();
        driver.findElement(By.xpath(".//*[text()='Спортивная']")).click();
   }

   //шаг заполнения полей Имя, Фамилия, Адрес
            public void forWhomRent(String userName, String surName, String address, String phoneNumber) {
                driver.findElement(userNameField).sendKeys(userName);
                driver.findElement(surNameField).sendKeys(surName);
                driver.findElement(addressField).sendKeys(address);
                driver.findElement(phoneNumberField).sendKeys(phoneNumber);
                driver.findElement(furtherButton).click();
            }
        }