package net.serenity.tutorials.tasks;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;

public class CompleteAToDoItem implements Task {

    public static CompleteAToDoItem called(String anItem) {
        return Instrumented.instanceOf(CompleteAToDoItem.class)
                .withProperties(anItem);
    }

    @Override
    public <T extends Actor> void performAs(T t) {

    }
}
