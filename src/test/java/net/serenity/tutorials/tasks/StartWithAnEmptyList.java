package net.serenity.tutorials.tasks;

import net.serenity.tutorials.ui.TodoMVCApplicationHomePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class StartWithAnEmptyList implements Task {

    private TodoMVCApplicationHomePage todoMVCApplicationHomePage;
    
    @Override
    @Step("{0} starts with empty todo list")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Open.browserOn().the(todoMVCApplicationHomePage)
        );
    }
}
