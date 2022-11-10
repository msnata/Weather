import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MsnataTest {

    //    TC_1_1  - Тест кейс:
    //    //1. Открыть страницу https://openweathermap.org/
    //    //2. Набрать в строке поиска город Paris
    //    //3. Нажать пункт меню Search
    //    //4. Из выпадающего списка выбрать Paris, FR
    //    //5. Подтвердить, что заголовок изменился на "Paris, FR"

    @Test
    public void testH2TagTextWhenSearchingCityCountry() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/C:\\Program Files\\DriverSelenium\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        String url = "https://openweathermap.org/";
        String cityName = "Paris";
        String expectedResult = "Paris, FR";

        driver.get(url);
        Thread.sleep(5000);

        WebElement searchCityField = driver.findElement(
                By.xpath("//div[@id = 'weather-widget']//input[@placeholder = 'Search city']")
        );
        searchCityField.click();
        searchCityField.sendKeys(cityName);

        WebElement searchButton = driver.findElement(
                By.xpath("//div[@id = 'weather-widget']//button[@type = 'submit']")
        );
        searchButton.click();

        Thread.sleep(1000);

        WebElement parisFRChoiceInDropdownMenu = driver.findElement(
                By.xpath("//ul[@class = 'search-dropdown-menu']/li/span[text() = \"Paris, FR \"]")
        );
        parisFRChoiceInDropdownMenu.click();

        WebElement h2CityCountryHeader = driver.findElement(
                By.xpath("//div[@id = 'weather-widget']//h2")
        );
        Thread.sleep(1000);

        String actualResult = h2CityCountryHeader.getText();

        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();
    }

    //TC_11_01
    //1.  Открыть базовую ссылку
    //2.  Нажать на пункт меню Guide
    //3.  Подтвердить, что вы перешли на страницу со ссылкой https://openweathermap.org/guide и
    // что title этой страницы OpenWeatherMap API guide - OpenWeatherMap

    @Test

    public void testTitleInGuide() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/C:\\Program Files\\DriverSelenium\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        String url = "https://openweathermap.org/";
        String expectedResulTitle = "OpenWeatherMap API guide - OpenWeatherMap";
        String expectedResultUrl = "https://openweathermap.org/guide";

        driver.get(url);
        Thread.sleep(5000);

        WebElement guideButton = driver.findElement(
                By.xpath("//div[@id = 'desktop-menu']//ul//a[text() = 'Guide']")
        );
        driver.manage().window().maximize();
        guideButton.click();

       String actualResultTitle = driver.getTitle();
       String actualResultUrl = driver.getCurrentUrl();

        Assert.assertEquals(actualResultTitle, expectedResulTitle);
        Assert.assertEquals(actualResultUrl, expectedResultUrl);
        driver.quit();

    }



    //TC_11_02
    //1.  Открыть базовую ссылку
    //2.  Нажать на единицы измерения Imperial: °F, mph
    //3.  Подтвердить, что температура для города показана в Фарингейтах

//        @Test
//    public void testFarengeit() throws InterruptedException {
//        System.setProperty("webdriver.chrome.driver", "/C:\\Program Files\\DriverSelenium\\chromedriver.exe");
//
//        WebDriver driver = new ChromeDriver();
//
//        String url = "https://openweathermap.org/";
//        String expectedResult = "°F";
//
//        driver.get(url);
//        Thread.sleep(5000);
//
//
//        WebElement findImperial = driver.findElement(
//                By.xpath("//div[@id = 'weather-widget']//div[2]/div[text() = \"Imperial: °F, mph\"]")
//        );
//            findImperial.click();
//
//            String actualResult = findImperial;
//
//            Assert.assertEquals(actualResult, expectedResult);
//
//         driver.quit();
//        }

    /*TC_11_03
1.  Открыть базовую ссылку
2. Подтвердить, что внизу страницы есть панель с текстом “We use cookies which are essential for th
e site to work. We also use non-essential cookies to help us improve our services.
Any data collected is anonymised. You can allow all cookies or manage them individually.”
3. Подтвердить, что на панели внизу страницы есть 2 кнопки “Allow all” и “Manage cookies”*/

    @Test
    public void testTextFooter() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "/C:\\Program Files\\DriverSelenium\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        String url = "https://openweathermap.org/";

        String expectedResult1 = "We use cookies which are essential for the site to work. We also use non-essential cookies to help us improve our services. Any data collected is anonymised. You can allow all cookies or manage them individually.";

        String expectedResult2 = "Allow all";
        String expectedResult3 = "Manage cookies";

        driver.get(url);
        Thread.sleep(5000);

        WebElement textFooter = driver.findElement(
                By.xpath("//div [@id = \'stick-footer-panel\']/div/div/div/div/p")
        );

        WebElement buttonAllowAll = driver.findElement(
                By.xpath("//div [@id = 'stick-footer-panel']//button[@type = 'button']")
        );

        WebElement buttonManageCookies = driver.findElement(
                By.xpath("//a[@href = '/cookies-settings']")
        );

        String actualResult1 = textFooter.getText();
        String actualResult2 = buttonAllowAll.getText();
        String actualResult3 = buttonManageCookies.getText();


        Assert.assertEquals(actualResult1, expectedResult1);
        Assert.assertEquals(actualResult2, expectedResult2);
        Assert.assertEquals(actualResult3, expectedResult3);

    driver.quit();
    }
    /*TC_11_04
    1.  Открыть базовую ссылку
    2.  Подтвердить, что в меню Support есть 3 подменю с названиями “FAQ”, “How to start” и “Ask a question”*/

//    @Test
//    public void testSupportMenu() throws InterruptedException {
//
//        System.setProperty("webdriver.chrome.driver", "/C:\\Program Files\\DriverSelenium\\chromedriver.exe");
//
//        WebDriver driver = new ChromeDriver();
//
//        String url = "https://openweathermap.org/";
//
//        driver.get(url);
//        Thread.sleep(5000);
//
//        driver.quit();
//
//    }

    /*TC_11_05
    1. Открыть базовую ссылку
    2. Нажать пункт меню Support → Ask a question
    3. Заполнить поля Email, Subject, Message
    4. Не подтвердив CAPTCHA, нажать кнопку Submit
    5. Подтвердить, что пользователю будет показана ошибка “reCAPTCHA verification failed, please try again.”*/

        @Test
    public void testSupportMenu() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "/C:\\Program Files\\DriverSelenium\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        String url = "https://openweathermap.org/";
        String email = "test@test.com";
        String message = "Test";
        String expectedResult = "reCAPTCHA verification failed, please try again.";

        driver.get(url);
        Thread.sleep(5000);

        WebElement searchSup = driver.findElement(
                By.xpath("//div [@id = 'support-dropdown']")
        );
        driver.manage().window().maximize();
        searchSup.click();
        Thread.sleep(2000);

        WebElement searchAskAQuestion = driver.findElement(
                By.xpath("//a[@href = 'https://home.openweathermap.org/questions']")
        );
        searchAskAQuestion.click();

        driver.navigate().to("https://home.openweathermap.org/questions");
        WebElement searchEmailField = driver.findElement(
                By.xpath("//input[@id = 'question_form_email']")
        );
        searchEmailField.sendKeys(email);
        searchEmailField.click();

        WebElement searchSubject = driver.findElement(
                By.xpath("//div/select [@id = 'question_form_subject']/option[2]")
        );
        searchSubject.click();

        WebElement searchMassege = driver.findElement(
                By.xpath("//div/textarea[@id = 'question_form_message']")
        );
        searchMassege.sendKeys(message);
        searchMassege.click();

        WebElement questionSubmit = driver.findElement(
                By.xpath("//form[@id = 'new_question_form']//input[@type = 'submit']")
        );
        questionSubmit.click();

        WebElement helpBlock = driver.findElement(
                By.xpath("//div[@class = 'help-block']")
        );

        String actualResult = helpBlock.getText();

        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();

    }

    /*TC_11_06
    1.  Открыть базовую ссылку
    2.  Нажать пункт меню Support → Ask a question
    3.  Оставить значение по умолчанию в checkbox Are you an OpenWeather user?
    4. Оставить пустым поле Email
    5. Заполнить поля  Subject, Message
    6. Подтвердить CAPTCHA
    7. Нажать кнопку Submit
    8. Подтвердить, что в поле Email пользователю будет показана ошибка “can't be blank”*/

    @Test
    public void testCaptchaMistake() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/C:\\Program Files\\DriverSelenium\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        String url = "https://openweathermap.org/";
        String message = "Test";

        driver.get(url);
        Thread.sleep(5000);

        WebElement searchSup = driver.findElement(
                By.xpath("//div [@id = 'support-dropdown']")
        );
        driver.manage().window().maximize();
        searchSup.click();
        Thread.sleep(2000);

        WebElement searchAskAQuestion = driver.findElement(
                By.xpath("//a[@href = 'https://home.openweathermap.org/questions']")
        );
        searchAskAQuestion.click();

        driver.navigate().to("https://home.openweathermap.org/questions");

        WebElement searchSubject = driver.findElement(
                By.xpath("//div/select [@id = 'question_form_subject']/option[2]")
        );
        searchSubject.click();

        WebElement searchMassege = driver.findElement(
                By.xpath("//div/textarea[@id = 'question_form_message']")
        );
        searchMassege.sendKeys(message);
        searchMassege.click();

        driver.quit();

    }

    /*TC_11_08
    1.  Открыть базовую ссылку
    2.  Нажать на лого компании
    3.  Дождаться, когда произойдет перезагрузка сайта, и подтвердить, что текущая ссылка не изменилась*/

    @Test
    public void testLogo() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "/C:\\Program Files\\DriverSelenium\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        String url = "https://openweathermap.org/";
        String expectedResult = "https://openweathermap.org/";

        driver.get(url);
        Thread.sleep(5000);

        WebElement logo = driver.findElement(
                By.xpath("//ul[@id = 'first-level-nav']//img")
        );
        logo.click();

       //driver.manage().timeouts().pageLoadTimeout();

        String actualResult = driver.getCurrentUrl();

        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();

    }





//    @Test
//    public void testName(){
//        System.setProperty("webdriver.chrome.driver", "/C:\\Program Files\\DriverSelenium\\chromedriver.exe");
//
//        WebDriver driver = new ChromeDriver();
//
// driver.quit();
//        driver.close();
//    }
}
