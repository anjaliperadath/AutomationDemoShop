package com.demowebshop.tests;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.demowebshop.Context.DriverManager;
import com.demowebshop.Utils.TestProperties;
import com.demowebshop.pageObjects.BooksPage;
import com.demowebshop.pageObjects.EmailPage;
import com.demowebshop.pageObjects.HomePage;
import com.demowebshop.pageObjects.LoginPage;
import com.demowebshop.pageObjects.ProductPage;
import com.demowebshop.pageObjects.RegisterPage;
import com.demowebshop.pageObjects.ShoppingCartPage;
import com.demowebshop.pageObjects.WishlistPage;

public class BaseTest {
	WebDriver driver; //centralised web driver
	Properties prop;// make it instance variable, to obtain in other class

	@BeforeMethod(alwaysRun = true)
	@Parameters({"browserName"})
	public void initializeDriver(@Optional String browserName) throws IOException {
		prop = TestProperties.getProperties(); //to get data of TestProperties class
		if ( browserName == null || browserName.isEmpty()) { //if null give whatever in Config.properties = Chrome 		
			browserName  = prop.getProperty("browser");//whatever browser is given in the xml file will be given to "browser"
		}
		
		String env = prop.getProperty("envrionment");//to give the environment in which I want to open the website
		String URL = prop.getProperty(env);// to get URL

		System.out.println("Executing in : " + env); // to know which environment
        System.out.println(browserName);//to know in which browser website is opening
        
		getDriver(browserName);//calling the method below 
		DriverManager.setDriver(driver);//set driver of DriverManager , singleton class
		DriverManager.getDriver().manage().window().maximize(); // to maximize chrome
		initPages();
		DriverManager.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));//to wait for 5 second for alert message of subscription to appear
		DriverManager.getDriver().get(URL); // to open this URL
	}

	public void getDriver(String browser) {
		if (browser.equalsIgnoreCase("chrome")) {//EqualsIgnoreCase means case does not matter either upper or lower case chrome it is ok
			
			//ChromeOptions opt= new ChromeOptions();
			//opt.addArguments("--headless=new");// to make execution headless
			driver = new ChromeDriver();//to open chrome 

		} else if (browser.equalsIgnoreCase("edge")) { // to open msedge
			driver = new EdgeDriver();
		}

		else if (browser.equalsIgnoreCase("firefox")) { // to open firefox 
			driver = new FirefoxDriver();
		} else {
			System.out.println("Not a valid browser");
			
		}
	}

	public LoginPage loginPage; // make as instance variable
	public HomePage homePage;
	public RegisterPage registerPage;
	public ProductPage productPage;
	public ShoppingCartPage shoppingPage;
	public BooksPage booksPage;
	public WishlistPage wishlistPage;
	public EmailPage emailPage; 
	public void initPages() {
		loginPage = new LoginPage(driver);// instance variable is assigned to local variable
		homePage = new HomePage(driver);
		registerPage = new RegisterPage(driver);
		productPage=new ProductPage(driver);
		shoppingPage= new ShoppingCartPage(driver);
		booksPage=new BooksPage(driver);
		wishlistPage=new WishlistPage(driver);
		emailPage=new EmailPage(driver);
	}

	@AfterMethod(alwaysRun =true)
	public void tearDown() {
		DriverManager.getDriver().quit();
	}
	
	  
}