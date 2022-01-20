package practice;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateOrg {
	@BeforeClass
	public void bc() {
		System.out.println("launch the browser");
	}
	@AfterClass
	public void ac() {
		System.out.println("quit the browser");
	}
	@BeforeMethod
	public void bm() {
		System.out.println("Login to Application");
	}
	@AfterMethod
	public void am() {
		System.out.println("Logout Application");
	}
	@Test
	
	public void org() {
		System.out.println("Navigate to org");
		System.out.println("create org");
		System.out.println("verify to org");
	}
	
	@Test
	public void contact() {
		System.out.println("Navigate to contact");
		System.out.println("create contact");
		System.out.println("verify to contact");
	}
	
	@Test
	public void product() {
		System.out.println("Navigate to product");
		System.out.println("create product");
		System.out.println("verify to product");
	}
	
}
