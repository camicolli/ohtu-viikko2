package ohtu;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;


public class Tester {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "/home/cocacoca/chromedriver"); 
        //Tarkastetaan skenaariot
        //Tavallinen oikea login
        logIn("pekka","akkep");
        //oikea nimi, väärä salasana
        logIn("pekka","vaaraSalasana");
        //kumpkin on väärin
        logIn("Tallaista","eiOle");
        register("luodaan","uusiKayttaja","uusiKayttaja");
        registerAndLogOut("username","password");
    }
    //Luodaan logIn omaksi metodikseen
    public static void logIn(String username,String password){
        WebDriver driver = new ChromeDriver();

        driver.get("http://localhost:4567");
        sleep(2);
        
        WebElement element = driver.findElement(By.linkText("login"));
        element.click();

        sleep(2);

        element = driver.findElement(By.name("username"));
        element.sendKeys("pekka");
        element = driver.findElement(By.name("password"));
        element.sendKeys("akkep");
        element = driver.findElement(By.name("login"));
        
        sleep(2);
        element.submit();
        sleep(3);
        driver.quit();
    }
    
    private static void sleep(int n){
        try{
            Thread.sleep(n*1000);
        } catch(Exception e){}
    }//RekisteröitymisMetodi
    public static void register(String username,String password, String passwordConfirmation){
        WebDriver driver = new HtmlUnitDriver();
        driver.get("http://localhost:4567");

        sleep(2);

        WebElement element = driver.findElement(By.linkText("register new user"));
        element.click();

        sleep(2);

        element = driver.findElement(By.name("username"));
        element.sendKeys(username);

        element = driver.findElement(By.name("password"));
        element.sendKeys(password);

        element = driver.findElement(By.name("passwordConfirmation"));
        element.sendKeys(passwordConfirmation);
        sleep(2);
        element.submit();
        driver.quit();
    }
    public static void registerAndLogOut(String username,String password){
        WebDriver driver = new HtmlUnitDriver();

      driver.get("http://localhost:4567");

      sleep(2);

      WebElement element = driver.findElement(By.linkText("register new user"));
      element.click();

      sleep(2);

        element = driver.findElement(By.name("username"));
        element.sendKeys(username);

        element = driver.findElement(By.name("password"));
        element.sendKeys(password);

        element = driver.findElement(By.name("passwordConfirmation"));
        element.sendKeys(password);
        sleep(2);
        element.submit();


        element = driver.findElement(By.linkText("continue to application mainpage"));
        element.click();


        element = driver.findElement(By.linkText("logout"));
        element.click();
        driver.quit();
    }
    }

