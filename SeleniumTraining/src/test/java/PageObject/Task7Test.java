package PageObject;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Task7Test extends GenericTest{

	
	@Test
	public void myTest(){
		
	for(int i = 0; i<3; i++){
	app.clickFirstProduct();
	app.addToCart();
	app.goToMainPage();
	assertEquals(app.getQuantityOfItemsInCart(), i+1+"");
	}
	
	app.goToCart();
	for(int i = 0; i<3; i++){
	app.removeItem();
	}
	app.goToMainPage();
	assertEquals(app.getQuantityOfItemsInCart(), "0");
	}
}
