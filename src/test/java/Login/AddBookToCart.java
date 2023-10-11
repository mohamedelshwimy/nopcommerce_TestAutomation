package Login;

import Base.BaseTests;
import Pages.BooksPage;
import Pages.CartPage;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class AddBookToCart extends BaseTests {

    @Test
    public void testAddBookToCart(){
        BooksPage booksPage = homePage.goToBooks();
        booksPage.clickBooks();
        booksPage.addFirstBookToCart();
        booksPage.openCart();

    }


}
