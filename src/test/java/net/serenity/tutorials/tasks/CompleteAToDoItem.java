package net.serenity.tutorials.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;

public class CompleteAToDoItem implements Task {

    public static Performable called(String anItem) {
        return null;
    }

    @Override
    public <T extends Actor> void performAs(T t) {

    }
}
