package ssvv.pages.emag;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

@DefaultUrl("https://www.emag.ro")
public class EmagPage extends PageObject {

    @FindBy(xpath = "//*[@id=\"main-container\"]/section[3]/div/div/div/form/div[1]/div[1]/input")
    private WebElementFacade subscriberNameInput;

    @FindBy(xpath = "//*[@id=\"main-container\"]/section[3]/div/div/div/form/div[1]/div[2]/input")
    private WebElementFacade subscriberEmailInput;

    @FindBy(xpath = "//*[@id=\"main-container\"]/section[3]/div/div/div/form/div[1]/div[3]/button")
    private WebElementFacade subscribeButton;

    public void enter_name(String name) {
        subscriberNameInput.type(name);
    }

    public void enter_email(String email) {
        subscriberEmailInput.type(email);
    }

    public void subscribe(){
        subscribeButton.click();
    }

    public boolean isSuccessMessageVisible(){
        WebElementFacade result = find(By.xpath("//*[@id=\"main-container\"]/section[3]/div/div/div/form/div[3]"));
        return result.isVisible();
    }

    public String getSuccessMessage(){
        WebElementFacade result = find(By.xpath("//*[@id=\"main-container\"]/section[3]/div/div/div/form/div[3]"));
        return result.getText();
    }

    public boolean isErrorMessageVisible(){
        WebElementFacade result = find(By.xpath("//*[@id=\"main-container\"]/section[3]/div/div/div/form/div[1]/div[2]/span"));
        return result.isVisible();
    }

    public String getErrorMessage(){
        WebElementFacade result = find(By.xpath("//*[@id=\"main-container\"]/section[3]/div/div/div/form/div[1]/div[2]/span"));
        return result.getText();
    }
}
