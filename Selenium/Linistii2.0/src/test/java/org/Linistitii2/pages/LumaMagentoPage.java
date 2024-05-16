package org.Linistitii2.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.stream.Collectors;

import static java.lang.Thread.sleep;

@DefaultUrl("https://magento.softwaretestingboard.com/")
//@DefaultUrl("https://www.saucedemo.com/")
public class LumaMagentoPage extends PageObject {

    @FindBy(name = "q")
    public WebElementFacade searchInput;

    @FindBy(id = "nickname_field")
    public WebElementFacade reviewNicknameInput;

    @FindBy(id = "summary_field")
    public WebElementFacade reviewSummaryInput;

    @FindBy(id = "review_field")
    public WebElementFacade reviewTextBlockInput;

    public void type_in_search_field_and_presses_enter(String keyword) {
        searchInput.typeAndEnter(keyword);
    }

    public void click_on_first_search_result() {
        find(By.xpath("//div[@class='product-item-info']"))
                .click();
    }

    public void click_on_first_size() {
        findAll(By.xpath("//div[@class='swatch-option text']"))
                .get(0).click();
    }

    public void click_on_first_color() {
        findAll(By.xpath("//div[@class='swatch-option color']"))
                .get(0).click();
    }

    public void click_on_add_to_cart() {
        find(By.id("product-addtocart-button"))
                .click();
    }

    public void click_on_cart() {
        find(By.xpath("//a[@class='action showcart']"))
                .click();
    }

    public void click_on_first_remove_from_cart() {
        find(By.xpath("//a[@class='action delete']"))
                .click();
    }

    public void click_on_confirm_remove_from_cart() {
        find(By.xpath("//button[@class='action-primary action-accept']"))
                .click();
    }

    public void click_on_add_review() {
        find(By.xpath("//a[@class='action add']"))
                .click();
    }

    public void click_on_review_stars(int stars) {
        find(By.id("Rating_" + stars + "_label")).click();
    }

    public void type_in_review_nickname_field(String text) {
        reviewNicknameInput.type(text);
    }

    public void type_in_review_summary_field(String text) {
        reviewSummaryInput.type(text);
    }

    public void type_in_review_text_block_field(String text) {
        reviewTextBlockInput.type(text);
    }

    public void click_on_submit_review() {
        find(By.xpath("//button[@class='action submit primary']"))
                .click();
    }

    public String getFailedSearchNotice() {
        return find(By.xpath("//div[@class='message notice']"))
                .findBy(By.tagName("div")).getTextContent();
    }

    public List<String> getSearchResults() {
        WebElementFacade definitionList = find(By.tagName("ol"));
        return definitionList.findElements(By.tagName("li")).stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    public String getAlertSuccessMessage() {
        return find(By.xpath("//div[@data-ui-id='message-success']"))
                .getTextContent();
    }

    public String getEmptyCartMessage() {
        return find(By.xpath("//strong[@class='subtitle empty']"))
                .getTextContent();
    }

    public void waitUntilPageIsLoaded(){
//        new WebDriverWait(getDriver(), 500).until(
//                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
//        try {
//            sleep(500);
//        } catch (InterruptedException e) {
//            System.out.println(e.getMessage());
//        }
    }
}