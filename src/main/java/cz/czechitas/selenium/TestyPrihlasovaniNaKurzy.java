package cz.czechitas.selenium;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestyPrihlasovaniNaKurzy {

    WebDriver prohlizec;

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "C:\\Java-Training\\Selenium\\geckodriver.exe");
        prohlizec = new FirefoxDriver();
        prohlizec.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @Test
    public void rodicSExistujicimUctemSeMusiPrihlasitDoAplikace() {
        prohlizec.navigate().to("https://cz-test-jedna.herokuapp.com/prihlaseni");
        WebElement email = prohlizec.findElement(By.id("email"));
        email.sendKeys("abcd@abcd.com");
        WebElement heslo = prohlizec.findElement(By.id("password"));
        heslo.sendKeys("Test12345");
        WebElement prihlaseni = prohlizec.findElement(By.xpath("//button[contains(text(), 'Přihlásit')]"));
        prihlaseni.click();
        WebElement overeniPrihlaseni = prohlizec.findElement(By.linkText("Přihlášky"));
        Assertions.assertEquals("Přihlášky",overeniPrihlaseni.getText());
    }

    @Test
    public void nejprveMusiBytKurz() {
        prohlizec.navigate().to("https://cz-test-jedna.herokuapp.com/");
        WebElement tlacitkoKurzu = prohlizec.findElement(By.xpath("//a[@href = 'https://cz-test-jedna.herokuapp.com/31-trimesicni-kurzy-programova']"));
        tlacitkoKurzu.click();
        WebElement vyberKurzuJava = prohlizec.findElement(By.xpath("//a[@href = 'https://cz-test-jedna.herokuapp.com/zaci/pridat/71-java-1']"));
        vyberKurzuJava.click();
        WebElement email = prohlizec.findElement(By.id("email"));
        email.sendKeys("abcd@abcd.com");
        WebElement heslo = prohlizec.findElement(By.id("password"));
        heslo.sendKeys("Test12345");
        WebElement prihlaseni = prohlizec.findElement(By.xpath("//button[contains(text(), 'Přihlásit')]"));
        prihlaseni.click();
        WebElement tlacitkoTermin = prohlizec.findElement(By.xpath("//tr[2]/td[2]/div/button/div/div/div"));
        tlacitkoTermin.click();
        WebElement vlozeniTerminuDoTlacitkaTermin = prohlizec.findElement(By.xpath("//*[@id=\"bs-select-1-0\"]"));
        vlozeniTerminuDoTlacitkaTermin.click();
        WebElement krestniJmenoZaka = prohlizec.findElement(By.id("forename"));
        krestniJmenoZaka.sendKeys("Eva");
        WebElement prijmeniZaka = prohlizec.findElement(By.id("surname"));
        prijmeniZaka.sendKeys("Testová");
        WebElement datumNarozeniZaka = prohlizec.findElement(By.id("birthday"));
        datumNarozeniZaka.sendKeys("10.02.1998");
        WebElement platbaHotove = prohlizec.findElement(By.xpath("//tr[8]/td[2]/span[4]/label"));
        platbaHotove.click();
        WebElement souhlasSVseobecnymiPodminkami = prohlizec.findElement(By.xpath("//tr[11]/td[2]/span/label"));
        souhlasSVseobecnymiPodminkami.click();
        WebElement vytvoritPrihlasku = prohlizec.findElement(By.xpath("//tr[11]/td[2]/input"));
        vytvoritPrihlasku.click();
        WebElement potvrzeniPrihlasky = prohlizec.findElement(By.xpath("//tr[10]/td[1]"));
        Assertions.assertEquals("Potvrzení", potvrzeniPrihlasky.getText());
    }

    @Test
    public void nejprveMusiBytPrihlaseni() {

        prohlizec.navigate().to("https://cz-test-jedna.herokuapp.com/prihlaseni");
        WebElement email = prohlizec.findElement(By.id("email"));
        email.sendKeys("abcd@abcd.com");
        WebElement heslo = prohlizec.findElement(By.id("password"));
        heslo.sendKeys("Test12345");
        WebElement prihlaseni = prohlizec.findElement(By.xpath("//button[contains(text(), 'Přihlásit')]"));
        prihlaseni.click();
        WebElement vytvoreniNovePrihlasky = prohlizec.findElement(By.xpath("/html/body/div/div/div/div/div/div[1]/a"));
        vytvoreniNovePrihlasky.click();
        WebElement tlacitkoKurzu = prohlizec.findElement(By.xpath("//a[@href = 'https://cz-test-jedna.herokuapp.com/31-trimesicni-kurzy-programova']"));
        tlacitkoKurzu.click();
        WebElement vyberKurzuJava = prohlizec.findElement(By.xpath("//a[@href = 'https://cz-test-jedna.herokuapp.com/zaci/pridat/71-java-1']"));
        vyberKurzuJava.click();
        WebElement tlacitkoTermin = prohlizec.findElement(By.xpath("//tr[2]/td[2]/div/button/div/div/div"));
        tlacitkoTermin.click();
        WebElement vlozeniTerminuDoTlacitkaTermin = prohlizec.findElement(By.xpath("//*[@id=\"bs-select-1-0\"]"));
        vlozeniTerminuDoTlacitkaTermin.click();
        WebElement krestniJmenoZaka = prohlizec.findElement(By.id("forename"));
        krestniJmenoZaka.sendKeys("Eva");
        WebElement prijmeniZaka = prohlizec.findElement(By.id("surname"));
        prijmeniZaka.sendKeys("Testová");
        WebElement datumNarozeniZaka = prohlizec.findElement(By.id("birthday"));
        datumNarozeniZaka.sendKeys("10.02.1998");
        WebElement platbaHotove = prohlizec.findElement(By.xpath("//tr[8]/td[2]/span[4]/label"));
        platbaHotove.click();
        WebElement souhlasSVseobecnymiPodminkami = prohlizec.findElement(By.xpath("//tr[11]/td[2]/span/label"));
        souhlasSVseobecnymiPodminkami.click();
        WebElement vytvoritPrihlasku = prohlizec.findElement(By.xpath("//tr[11]/td[2]/input"));
        vytvoritPrihlasku.click();
        WebElement potvrzeniPrihlasky = prohlizec.findElement(By.xpath("//tr[10]/td[1]"));
        Assertions.assertEquals("Potvrzení", potvrzeniPrihlasky.getText());
    }
    @Test
    public void odhlaseniUzivatele() {
        prohlizec.navigate().to("https://cz-test-jedna.herokuapp.com/prihlaseni");
        WebElement email = prohlizec.findElement(By.id("email"));
        email.sendKeys("abcd@abcd.com");
        WebElement heslo = prohlizec.findElement(By.id("password"));
        heslo.sendKeys("Test12345");
        WebElement prihlaseni = prohlizec.findElement(By.xpath("//button[contains(text(), 'Přihlásit')]"));
        prihlaseni.click();
        WebElement prihlasovaciJmeno = prohlizec.findElement(By.xpath("//a/strong"));
        prihlasovaciJmeno.click();
        WebElement odhlaseni = prohlizec.findElement(By.xpath("//*[@id=\"logout-link\"]"));
        odhlaseni.click();
        WebElement kontrolaPoOdhlaseni = prohlizec.findElement(By.linkText("Přihlásit"));
        Assertions.assertEquals("Přihlásit", kontrolaPoOdhlaseni.getText());
    }

    @AfterEach
    public void tearDown() {
        prohlizec.close();
    }
}
