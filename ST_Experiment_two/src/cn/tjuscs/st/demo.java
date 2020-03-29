package cn.tjuscs.st;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import java.util.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;

@RunWith(Parameterized.class)
public class demo {
  public String expected = null;
  public String input = null;
  
  public demo(String expected, String input) {
	// TODO Auto-generated constructor stub
	this.expected = expected;
	this.input = input;
	}

  @Parameters
  public static Collection<Object[]> sendData() {
	List<Object[]> list = new ArrayList<Object[]>(); 
	WebDriver driver;
    String  driverPath = System.getProperty("user.dir") + "/driver/geckodriver";
    System.setProperty("webdriver.gecko.driver", driverPath);
    driver = new FirefoxDriver();
    driver.get("http://103.120.226.190/selenium-demo/git-repo");
    String dataURL = System.getProperty("user.dir") + "/data/Selenium+Lab2020.xlsx";
    try {
    	FileInputStream file_data = new FileInputStream(dataURL);
    	XSSFWorkbook wb = new XSSFWorkbook(file_data);
    	file_data.close();
    	XSSFSheet st = wb.getSheetAt(0);
    	Iterator<Row> rt = st.rowIterator();
    	Row row = null;
    	int i = 1;
    	while(i<=20) {
    		row = rt.next();
    		String id = row.getCell(1).toString();
			String ps = row.getCell(2).toString();
			driver.findElement(By.name("user_number")).click();
		    driver.findElement(By.name("user_number")).sendKeys(id);
		    driver.findElement(By.name("password")).click();
		    driver.findElement(By.name("password")).sendKeys(ps);
		    driver.findElement(By.cssSelector(".btn")).click();
			String result = driver.findElement(By.xpath("/html/body/div/div/div/div/div/div/div[2]/div/form/div[5]/code")).getText();
			list.add(new String[] {ps,result});
			i++;
    	}
    }
    catch (FileNotFoundException e){
    	e.printStackTrace();
    }
    catch (IOException e) {
    	e.printStackTrace();
    }
    driver.quit();
    return list;
  }
  @Test
  public void test() {
	  assertEquals(expected, input);
  }
  
}
