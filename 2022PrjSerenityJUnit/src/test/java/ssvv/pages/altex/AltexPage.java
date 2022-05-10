package ssvv.pages.altex;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

@DefaultUrl("https://altex.ro/home/")
public class AltexPage extends PageObject {

    @FindBy(xpath = "//*[@id=\"__next\"]/div[1]/div[1]/div/div/div[3]/div/form/div/div/input")
    private WebElementFacade searchInput;

    @FindBy(xpath = "//*[@id=\"main-container\"]/section[3]/div/div/div/form/div[1]/div[2]/input")
    private WebElementFacade subscriberEmailInput;

    @FindBy(xpath = "//*[@id=\"__next\"]/div[1]/div[1]/div/div/div[3]/div/form/div/div/button")
    private WebElementFacade searchButton;

    public void enter_name(String name) {
        searchInput.type(name);
    }

    public void enter_email(String email) {
        subscriberEmailInput.type(email);
    }

    public void subscribe(){
        searchButton.click();
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

    @FindBy(id = "searchboxTrigger")
    private WebElementFacade searchTerms;

    // @FindBy(xpath = "//*[@id=\"masthead\"]/div/div/div[2]/div/form/div[1]/div[2]/button[2]")
    @FindBy(className = "searchbox-submit-button")
    private WebElementFacade lookupButton;

    public void enter_keywords(String keyword) {
        searchTerms.type(keyword);
    }

    public void lookup_terms() {
        lookupButton.click();
    }

    public String getSearchTitle(){
        // xpath = //*[@id="main-container"]/section[1]/div/div[3]/div[2]/div[1]/div[1]/div[1]
        WebElementFacade result = find(By.className("listing-page-title"));
        return result.getText();
    }

    public String getSearchTitleOnError(){
        // xpath: //*[@id="main-container"]/section/div/div[3]/h1
        WebElementFacade result = find(By.className("listing-grid-title"));
        return result.getText();
    }
}
