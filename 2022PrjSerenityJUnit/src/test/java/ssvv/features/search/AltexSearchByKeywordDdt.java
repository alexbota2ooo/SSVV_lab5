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
import ssvv.steps.serenity.AltexEndUserSteps;

@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom("src/test/resources/altex/AltexValidSearch.csv")
public class AltexSearchByKeywordDdt {

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @ManagedPages(defaultUrl = "https://altex.ro/home/")
    public Pages pages;

    public String name;
    public String titleSearch;

    @Qualifier
    public String getQualifier() {
        return name;
    }

    @Steps
    public AltexEndUserSteps endUser;

    @Issue("#ALTEX-1")
    @Test
    public void searchAltexByKeywordTestDDT() {
        endUser.is_the_search_home_page();
        endUser.looks_for(getName());
        endUser.should_see_title(getTitleSearch());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitleSearch() {
        return titleSearch;
    }

    public void setTitleSearch(String titleSearch) {
        this.titleSearch = titleSearch;
    }
}
