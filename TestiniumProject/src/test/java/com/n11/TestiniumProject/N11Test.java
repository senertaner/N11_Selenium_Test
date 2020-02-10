package com.n11.TestiniumProject;

import java.util.List;
import java.util.Random;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class N11Test {
	private static final Logger logger = LogManager.getLogger(N11Test.class.getName());

	public static void main(String[] args) throws Exception {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\tanersener\\Desktop\\selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://www.n11.com/");
		Thread.sleep(2000);
		String url = driver.getCurrentUrl();

		if (url.equals("https://www.n11.com/")) {
			System.out.println("N11 Anasayfası açıldı ");
		} else {
			logger.error("Başka sayafa açıldı");
		}
		Thread.sleep(2000);
		driver.get("https://www.n11.com/giris-yap");
		Thread.sleep(2000);
		WebElement username = driver.findElement(By.id("email"));
		WebElement password = driver.findElement(By.id("password"));
		WebElement login = driver.findElement(By.xpath("//div[@id=\"loginButton\"]"));

		username.sendKeys("XXXXX@gmail.com"); // MAİL ADRESİNİ BURAYA YAZINIZ
		password.sendKeys("XXXX");// MAİL ADRESİNİZİN ŞİFRESİNİ BURAYA YAZINIZ
		login.click();
		driver.findElement(By.id("searchData")).sendKeys("bilgisayar");
		driver.findElement(By.className("searchBtn")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"contentListing\"]/div/div/div[2]/div[4]/a[2]")).click(); // driver.findElement(By.linkText("2")).click();//a[text()='2']

		url = driver.getCurrentUrl();
		Thread.sleep(2000);
		if (url.equals("https://www.n11.com/arama?q=bilgisayar&pg=2")) {

			System.out.println("2.sayfa açıldı");
		} else {
			logger.error("Başka sayafa açıldı");
		}
		Thread.sleep(3000);
		driver.findElement(By.xpath(".//*[@id='p-402675361']/div[1]/a")).click();
		Thread.sleep(2000);
		driver.findElement(By.className("btnAddBasket")).click();
		Thread.sleep(1000);
		driver.findElement(By.className("myBasket")).click();
		Thread.sleep(2000);
		driver.findElement(By.className("spinnerUp")).click();
		Thread.sleep(4000);
		driver.findElement(By.className("svgIcon_trash")).click();
		Thread.sleep(1000);

		String productNumber = driver.findElement(By.className("basketTotalNum")).getText();
		if (productNumber.equals(null)) {
			System.out.print("Sepetiniz Boş");
		} else {
			System.out.print("Sepetiniz Dolu");
		}

	}

}
