package net.serenity.tutorials.features.complete_items;

import net.serenity.tutorials.questions.TheTodoItems;
import net.serenity.tutorials.tasks.CompleteAToDoItem;
import net.serenity.tutorials.tasks.StartWith;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Managed;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import static net.serenitybdd.screenplay.GivenWhenThen.*;
import static org.hamcrest.CoreMatchers.hasItems;

@RunWith(SerenityRunner.class)
public class CompleteItemsStory {
    Actor felicia = Actor.named("Felicia");
    @Managed
    WebDriver herBrowser;

    @Before
    public void felicia_can_browse_the_web(){
        felicia.can(BrowseTheWeb.with(herBrowser));
    }

    @Test
    public void felicia_able_to_filter_active_tasks(){
        givenThat(felicia).wasAbleTo(StartWith.atodoListContaining("Feed the cat", "Walk the Dog", "Go for a run"));
        when(felicia).attemptsTo(CompleteAToDoItem.called("Walk the dog"));
        then(felicia).should(seeThat(TheTodoItems.displayed(),hasItems("Go for a run","Feed the cat")));
    }
}
