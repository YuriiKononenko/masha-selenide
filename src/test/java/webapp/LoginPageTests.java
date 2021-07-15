package webapp;

import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideConfig;
import com.codeborne.selenide.SelenideElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class LoginPageTests {

    @Test
    public void verifyUserCanLoginWithValidParameters() {
        // configure browser
        Configuration.browser = Browsers.CHROME;
        Selenide.open("https://app.dev.betterme.world/login");
        SelenideElement emailInput =  Selenide.$("input[data-input='email-login-email']");
        SelenideElement passwordInput =  $("input[data-input='email-login-password']");
        SelenideElement loginButton =  $("div[class*='login_button'] button");

        emailInput.setValue("xidob74169@ovooovo.com");
        passwordInput.setValue("111111");
        loginButton.click();

        ElementsCollection actualMeals = $$("a[class^=meal-card_container]");

        actualMeals.shouldHave(size(3));
    }

}
