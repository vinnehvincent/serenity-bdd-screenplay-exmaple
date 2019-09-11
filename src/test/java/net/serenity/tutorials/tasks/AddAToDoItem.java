package net.serenity.tutorials.tasks;

import net.serenity.tutorials.ui.TheTodoList;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.EnterValue;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.Keys;

import static org.openqa.selenium.Keys.ENTER;
import static org.openqa.selenium.Keys.RETURN;

public class AddAToDoItem implements Task {
    private  String itemName;

    public AddAToDoItem(String itemName) {
        this.itemName = itemName;
    }

    public static AddAToDoItem called(String itemName) {
        return Instrumented.instanceOf(AddAToDoItem.class)
                .withProperties(itemName);
    }

    @Override
    @Step("{0} adds an item called '#itemName' ")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(itemName).into(TheTodoList.WHAT_NEEDS_TO_BE_DONE)
                        .thenHit(RETURN)
        );
    }
}
