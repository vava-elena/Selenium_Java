package ru.stqa.training.page.object.user.product;

import static ru.stqa.training.page.object.user.header.HeaderMap.COUNT_ITEMS_INTO_CART;
import static ru.stqa.training.page.object.user.product.ProductPageMap.HEADER_PAGE;
import static ru.stqa.training.page.object.user.product.ProductPageMap.PRODUCT_ADD_TO_CART_BTN;
import static ru.stqa.training.selenium.SharedMethods.click;
import static ru.stqa.training.selenium.SharedMethods.getAttribute;
import static ru.stqa.training.selenium.SharedMethods.waitElementPresent;
import static ru.stqa.training.selenium.SharedMethods.waitTextToPresentInElement;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import ru.stqa.training.page.object.PageObject;

public class ProductPageObject extends PageObject {

	public ProductPageObject(final WebDriver driver, final WebDriverWait wait) {
		super(driver, wait);
	}

	@Override
	public boolean pageIsPresent() {
		return waitElementPresent(driver, HEADER_PAGE.by(), wait);
	}

	public String getProductName() {
		return getAttribute(driver, HEADER_PAGE.by(), "textContent");
	}
	
	public void addToCartProduct() {
		click(driver, PRODUCT_ADD_TO_CART_BTN.by());
	}
	
	public boolean waitChangeCountInCart() {
		int count = Integer.parseInt(getAttribute(driver, COUNT_ITEMS_INTO_CART.by(), "textContent")) + 1;
		return waitTextToPresentInElement(COUNT_ITEMS_INTO_CART.by(), wait, ""+count);
	}
}
