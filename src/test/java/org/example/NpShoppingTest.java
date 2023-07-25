package org.example;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.*;

public class NpShoppingTest {

    @BeforeAll
    public static void setUp() {
        Configuration.baseUrl = "https://np.shopping";
        //Configuration.startMaximized = true; // Відкривати браузер на весь екран
    }

    @Test
    public void testBuyProduct() {
        // Відкриває сторінку https://np.shopping/
        open("https://np.shopping/");

        // Виконує авторизацію за допомогою логіну і паролю
        $(byName("login")).setValue("your_username");
        $(byName("password")).setValue("your_password");
        $("button[type='submit']").click();

        // Переходить на сторінку товару https://firm4191.np.shopping/goods/view/365891/all/chohol-spigen-dlya-iphone-14-pro--thin-fit-abyss-green-acs04786/
        open("https://firm4191.np.shopping/goods/view/365891/all/chohol-spigen-dlya-iphone-14-pro--thin-fit-abyss-green-acs04786/");

        // Натискається кнопка "Купити"
        $("button.buy-button").shouldBe(visible).click();
    }
}

