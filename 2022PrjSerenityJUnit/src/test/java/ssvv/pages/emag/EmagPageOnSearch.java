package ssvv.pages.emag;


import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

@DefaultUrl("https://www.emag.ro/#opensearch")
public class EmagPageOnSearch extends PageObject {

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
