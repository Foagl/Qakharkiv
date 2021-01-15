package ua.kharkov.city;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstTest {
      public ChromeDriver driver;
    @Before  // Аннотация позволяющая не дублировать код. Создает метод, который выполняется перед тестами.
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe"); // Путь до WebDriver, который я скачал отдельно
        driver = new ChromeDriver();
        System.out.println("open");
    }
    @After public void close(){ // Аннотация позволяющая не дублировать код. Процедура закрытия окончания теста.
        System.out.println("close");
        driver.quit(); // Закрытие окна браузера.
    }
    @Test // Аннотация тест для Junit что бы ПО поняло что мы проводим тестирование.
    public void FirstTest(){
        driver.get("https://www.city.kharkov.ua/");
        driver.manage().window().setSize(new Dimension(1600,900));
        String title = driver.getTitle();
        Assert.assertTrue(title.equals("Офіційний сайт Харківської міської ради, міського голови, виконавчого комітету | Официальный сайт Харьковского городского совета, городского головы, исполнительного комитета"));
        System.out.println(title);
    }
    @Test  //Без этой аннотации Junit не поймет нужно ли выполнять данный тест( Запуск 2 и более тестов)
    public void FirstTest2(){
        driver.get("https://www.city.kharkov.ua/");
        String title = driver.getTitle();
        Assert.assertTrue(title.equals("Офіційний сайт Харківської міської ради, міського голови, виконавчого комітету | Официальный сайт Харьковского городского совета, городского головы, исполнительного комитета"));
        System.out.println(title);
    }
}
