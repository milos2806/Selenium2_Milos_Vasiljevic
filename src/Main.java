
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.get(" http://www.booking.com/");

        // select destination
        WebElement destination = driver.findElement(By.id("ss"));
        destination.sendKeys("Belgrade");

        // check-in date
        WebElement checkIn = driver.findElement(By.className("xp__dates__checkin"));
        checkIn.click();

        WebElement checkInDate = driver.findElement(By.xpath("//*[@id=\"frm\"]/div[1]/div[2]/div/div[2]/div/div/div/div[2]/div[2]/div[3]/div/div/div[1]/table/tbody/tr[3]/td[7]/span"));
        checkInDate.click();

        // check-out date
        WebElement checkOut = driver.findElement(By.className("xp__dates__checkout"));
        checkOut.click();

        WebElement checkOutDate = driver.findElement(By.xpath("//*[@id=\"frm\"]/div[1]/div[2]/div/div[3]/div/div/div/div[2]/div[2]/div[3]/div/div/div[1]/table/tbody/tr[5]/td[6]/span"));
        checkOutDate.click();

        // Guests      
        WebElement guests = driver.findElement(By.className("xp__guests"));
        guests.click();

        WebElement rooms = driver.findElement(By.id("no_rooms"));
        rooms.click();

        // Rooms
        Select roomsNumber = new Select(driver.findElement(By.id("no_rooms")));
        roomsNumber.selectByValue("4");

        // Adults 
        Select adultsNumber = new Select(driver.findElement(By.id("group_adults")));
        adultsNumber.selectByValue("8");

        // Children
        Select childrenNumber = new Select(driver.findElement(By.id("group_children")));
        childrenNumber.selectByValue("2");

        Select firstChildAge = new Select(driver.findElement(By.name("age")));
        firstChildAge.selectByValue("12");

        Select secondChildAge = new Select(driver.findElement(By.xpath("//*[@id=\"frm\"]/div[1]/div[3]/div[2]/div/div/div[4]/select[2]")));
        secondChildAge.selectByValue("12");

        // Search
        WebDriverWait waitSearch = new WebDriverWait(driver, 4);
        WebElement searchButton = waitSearch.until(ExpectedConditions.elementToBeClickable(By.className("sb-searchbox__button")));
        searchButton.click();

        // quit 
        Thread.sleep(8000);
        driver.quit();
        
    }

}
