package ssvv.steps.serenity.emag;

import net.thucydides.core.annotations.Step;
import ssvv.pages.emag.EmagPage;
import ssvv.pages.emag.EmagPageOnSearch;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

public class EmagEndUserSteps {
    EmagPage emagPage;

    EmagPageOnSearch emagPageOnSearch;

    //For searching:
    @Step
    public void is_the_search_home_page() {
        emagPageOnSearch.open();
    }

    @Step
    public void enters(String keyword) {
        emagPageOnSearch.enter_keywords(keyword);
    }

    @Step
    public void starts_search() {
        emagPageOnSearch.lookup_terms();
    }

    @Step
    public void looks_for(String term) {
        enters(term);
        starts_search();
    }

    @Step
    public void should_see_title(String title) {
        assertThat(emagPageOnSearch.getSearchTitle(), containsString(title));
    }

    @Step
    public void should_see_title_with_error(String title) {
        assertThat(emagPageOnSearch.getSearchTitleOnError(), containsString(title));
    }


    //For subscribing:
    @Step
    public void is_home_page(){
        emagPage.open();
    }

    @Step
    public void subs_enters_name(String name) {
        emagPage.enter_name(name);
    }

    @Step
    public void subs_enters_email(String email) {
        emagPage.enter_email(email);
    }

    @Step
    public void presses_subscribe(){
        emagPage.subscribe();
    }

    @Step
    public void subscribe(String name, String email){
        subs_enters_name(name);
        subs_enters_email(email);
        presses_subscribe();
    }

    @Step
    public void should_see_successful_subscribe_message(String message){
        assertThat(emagPage.getSuccessMessage(), containsString(message));
    }

    @Step
    public void should_see_error_subscribe_message(String message){
        assertThat(emagPage.getErrorMessage(), containsString(message));
    }
}
