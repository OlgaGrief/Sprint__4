import PageObject.AboutRentPage;
import PageObject.ForWhomRentPage;
import PageObject.HomePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

//запуск с параметризацией
@RunWith(Parameterized.class)
public class ParameterRentTest {
    private WebDriver driver;
//объявление полей
    private final String userName;
    private final String surName;
    private final String address;
    private final String phoneNumber;
    private final String rentDate;
    private final String comment;

    public ParameterRentTest(String userName, String surName, String address,  String phoneNumber, String rentDate, String comment) {
        this.userName = userName;
        this.surName = surName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.rentDate = rentDate;
        this.comment = comment;
    }
    @Before
    public void setUp() {
        //менеджер для драйверов
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
//        WebDriverManager.firefoxdriver().setup();
//        driver = new FirefoxDriver();
        //переход на страницу Яндекс Самокат
        driver.get("https://qa-scooter.praktikum-services.ru");
        // полноэкранный режим окна браузера
        driver.manage().window().maximize();
        //принятие куки
        driver.findElement(By.id("rcc-confirm-button")).click();
    }

    @Parameterized.Parameters
    //тестовые данные для полей заказа
    public static Object[][] getRentDataTest() {
        return new Object[][]{
                {"Олег", "Бесподобный", "Москва, Прогулочная улица, дом 1254, подъезд 12 1", "+78954521478", "31.12.2023", "верхняя антресоль"},
                {"Филипп", "Огненный", "Санкт-Петербург, Сильный Проспект, дом 4",  "+79875412365", "01.01.2024", "привези скорее"},
        };
    }

    @Test
    public void scooterRentTest() {
        //создание объекта класса главной страницы
        HomePage homePage = new HomePage(driver);
        //клик на первую кнопку Заказать
        homePage.clickOrderButton();
        ForWhomRentPage objForWhomRentPage = new ForWhomRentPage(driver);
        //выбор станции метро - не получилось добавить через параметризацию
        objForWhomRentPage.setStation();
        objForWhomRentPage.forWhomRent(userName, surName, address, phoneNumber);
        AboutRentPage objAboutRentPage = new AboutRentPage(driver);
        //заполнение поля Срок аренды - аналогично метро, не знаю как передать через параметризацию
        objAboutRentPage.setRentDuration();
        //заполнение полей Дата, цвет, комментарий
        objAboutRentPage.aboutRentDop(rentDate, comment);
        //клик по кнопке Заказать на станице про аренду
        objAboutRentPage.clickAboutRentOrderButton();
// оформить заказ
        objAboutRentPage.clickYesButton();
        objAboutRentPage.clicklookStatusButton();
    }

//  тест для клика по второй кнопке Заказать
    @Test
    public void scooterSecondRentTest() {
        //создание объекта класса главной страницы
        HomePage objHomePage1 = new HomePage(driver);
        //клик на вторую кнопку Заказать
        objHomePage1.clickSecondOrderButton();
    }

    @After
    public void tearDown() {
        //закрыть браузер
        driver.quit();
    }
}
