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
@UseTestDataFrom("src/test/resources/emag/AltexErrorSearch.csv")
public class EmagSearchByKeywordStoryDdtError {

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @ManagedPages(defaultUrl = "https://www.emag.ro/#opensearch")
    public Pages pages;

    public String name;
    public String titleSearch;

    @Qualifier
    public String getQualifier() {
        return name;
    }

    @Steps
    public EmagEndUserSteps endUser;

    @Issue("#EMAG-2")
    @Test
    public void searchEmagByKeywordTestDDT() {
        endUser.is_the_search_home_page();
        endUser.looks_for(getName());
        endUser.should_see_title_with_error(getTitleSearch());
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


