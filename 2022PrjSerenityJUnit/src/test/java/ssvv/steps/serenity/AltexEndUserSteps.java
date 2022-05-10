package ssvv.steps.serenity;

import net.thucydides.core.annotations.Step;
import org.yecht.Data;
import ssvv.pages.altex.AltexPage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

public class AltexEndUserSteps {
    AltexPage altexPage;

    //For searching:
    @Step
    public void is_the_search_home_page() {
        altexPage.open();
    }

    @Step
    public void enters(String keyword) {
        altexPage.enter_keywords(keyword);
    }

    @Step
    public void starts_search() {
        altexPage.lookup_terms();
    }

    @Step
    public void looks_for(String term) {
        enters(term);
        starts_search();
    }

    @Step
    public void should_see_title(String title) {
        assertThat(altexPage.getSearchTitle(), containsString(title));
    }

    @Step
    public void should_see_title_with_error(String title) {
        assertThat(altexPage.getSearchTitleOnError(), containsString(title));
    }


    //For subscribing:
    @Step
    public void is_home_page(){
        altexPage.open();
    }

    @Step
    public void subs_enters_name(String name) {
        altexPage.enter_name(name);
    }

    @Step
    public void subs_enters_email(String email) {
        altexPage.enter_email(email);
    }

    @Step
    public void presses_subscribe(){
        altexPage.subscribe();
    }

    @Step
    public void subscribe(String name, String email){
        subs_enters_name(name);
        subs_enters_email(email);
        presses_subscribe();
    }

    @Step
    public void should_see_successful_subscribe_message(String message){
        assertThat(altexPage.getSuccessMessage(), containsString(message));
    }

    @Step
    public void should_see_error_subscribe_message(String message){
        assertThat(altexPage.getErrorMessage(), containsString(message));
    }
}
