import PageObject.HomePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Arrays;
import java.util.Collection;


@RunWith(Parameterized.class)
public class QuestionsDropdownTest {
    //поле driver
    private WebDriver driver;
    //поля
    private final int questionNumber;
    private final int answerNumber;

    public QuestionsDropdownTest(int questionNumber, int answerNumber) {
        this.questionNumber = questionNumber;
        this.answerNumber = answerNumber;
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
    }

    // массив
    @Parameters
    public static Collection<Object[]> data(){
        return Arrays.asList(new Object[][] {
                {0, 0},
                {1, 1},
                {2, 2},
                {3, 3},
                {4, 4},
                {5, 5},
                {6, 6},
                {7, 7},
        });
    }

// тест открытия текста ответа в соответствии с номером вопроса
    @Test
    public void QuestionTest() {
        HomePage homePage = new HomePage(driver);
        driver.findElement(By.id("rcc-confirm-button")).click();
        homePage.clickOnQuestion(questionNumber);
        Assert.assertTrue(homePage.getAnswer(answerNumber).isDisplayed());
    }

    @After
    public void tearDown() {
        //закрыть браузер
        driver.quit();
    }
}


