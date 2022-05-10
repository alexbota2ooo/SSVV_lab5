package ssvv.features.search;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Issue;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.pages.Pages;
import net.thucydides.junit.annotations.Qualifier;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import ssvv.steps.serenity.emag.EmagEndUserSteps;

@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom("src/test/resources/emag/EmagValidSubscribe.csv")
public class EmagSubscribeStoryDdt {
    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @ManagedPages(defaultUrl = "https://www.emag.ro")
    public Pages pages;

    public String name;
    public String email;
    public String message;

//    @Qualifier
//    public String getQualifier() {
//        return name;
//    }

    @Steps
    public EmagEndUserSteps endUser;

    @Issue("#EMAG-1")
    @Test
    public void subscribeTestDDT() {
        endUser.is_home_page();
        endUser.subscribe(getName(), getEmail());
        endUser.should_see_successful_subscribe_message(getMessage());
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
}
