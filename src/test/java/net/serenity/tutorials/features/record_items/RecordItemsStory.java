package net.serenity.tutorials.features.record_items;

import net.serenity.tutorials.questions.TheTodoItems;
import net.serenity.tutorials.tasks.AddAToDoItem;
import net.serenity.tutorials.tasks.StartWith;
import net.serenity.tutorials.tasks.StartWithAnEmptyList;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Narrative;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import static net.serenitybdd.screenplay.GivenWhenThen.*;
import static net.serenitybdd.screenplay.GivenWhenThen.when;
import static org.hamcrest.CoreMatchers.hasItem;
@Narrative(
        title = "Recording to do items on the list",
        text = {"In order to keep track of things to be done",
                "As user",
                "I would like to record to do items"
                },
        cardNumber = "#124"
        )
@RunWith(SerenityRunner.class)
public class RecordItemsStory {
    Actor justin = Actor.named("Justin");

    @Managed(uniqueSession = true)
    WebDriver hisBrowser;


    @Before
    public void justin_can_browser_the_web(){
        justin.can(BrowseTheWeb.with(hisBrowser));
    }
    @Test
    public void justin_is_able_to_add_a_to_do_item_to_the_to_do_list(){
       givenThat(justin).wasAbleTo(StartWith.anEmptyToDoList());
       when(justin).attemptsTo(AddAToDoItem.called("Feed the cat"));
       then(justin).should(seeThat(TheTodoItems.displayed(), hasItem("Feed the cat")));
    }
    @Test
    public void justin_is_able_add_additional_to_do_items(){
        givenThat(justin).wasAbleTo(StartWith.atodoListContaining("Feed the cat", "take out the baggage"));
        when(justin).attemptsTo(AddAToDoItem.called("Walk the dog"));
        then(justin).should(seeThat(TheTodoItems.displayed(), hasItem("Walk the dog")));
    }
}
