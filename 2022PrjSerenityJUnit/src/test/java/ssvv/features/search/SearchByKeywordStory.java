package ssvv.features.search;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Issue;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Pending;
import net.thucydides.core.annotations.Steps;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import ssvv.steps.serenity.EndUserSteps;

@RunWith(SerenityRunner.class)
public class SearchByKeywordStory {

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @Steps
    public EndUserSteps anna;

    @Issue("#WIKI-1")
    @Test
    public void searching_by_keyword_apple_should_display_the_corresponding_article() {
        anna.is_the_home_page();
        anna.looks_for("apple");
       anna.should_see_definition("A common, round fruit produced by the tree Malus domestica, cultivated in temperate climates.");

    }

    @Test
    public void searching_by_keyword_pear_should_display_the_corresponding_article() {
        anna.is_the_home_page();
        anna.looks_for("pear");
       // anna.should_see_definition("An edible fruit produced by the pear tree, similar to an apple but elongated towards the stem.");
        anna.should_see_definition("An edible fruit produced by the pear tree, similar to an apple but typically elongated towards the stem");
    }

    @Test
    public void searching_by_keyword_strawberry_should_display_the_corresponding_article() {
        anna.is_the_home_page();
        anna.looks_for("strawberry");
        anna.should_see_definition("The sweet, usually red, edible fruit of certain plants of the genus Fragaria");
    }

    @Test
    public void searching_by_keyword_dog_should_display_the_corresponding_article() {
        anna.is_the_home_page();
        anna.looks_for("dog");
        anna.should_see_definition("A mammal, Canis familiaris or Canis lupus familiaris, that has been domesticated for thousands of years, of highly variable appearance due to human breeding");
    }

    @Pending @Test
    public void searching_by_ambiguious_keyword_should_display_the_disambiguation_page() {
    }
} 
