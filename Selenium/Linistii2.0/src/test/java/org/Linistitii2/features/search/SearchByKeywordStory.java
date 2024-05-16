package org.Linistitii2.features.search;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.Linistitii2.steps.serenity.EndUserSteps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom("org/Linistitii2/features/search/data.csv")
public class SearchByKeywordStory {

    @Managed(uniqueSession = true, driver = "firefox")
    public WebDriver webdriver;

    @Steps
    public EndUserSteps userSteps;

    public String searchKeyword;
    public String searchFailedText;
    public String searchResultText;

    @Test
    public void searching_by_keyword_should_display_result() {
        userSteps.opens_the_home_page();
        userSteps.types_in_search_field_and_presses_enter(searchKeyword);
        if (searchKeyword.length() < 3) {
            userSteps.should_see_failed_search_notice(searchFailedText);
        } else {
            userSteps.should_see_text_in_search_results(searchResultText);
        }
    }
} 