package net.serenity.tutorials.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;

import java.util.List;

public class StartWithATodoListContaining implements Task {
    private final List<String> todos;

    public StartWithATodoListContaining(List<String> todos) {
        this.todos = todos;
    }

    @Override
    @Step("{0} starts with a list containing #todos")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(StartWith.anEmptyToDoList());
        todos.forEach(
                todo -> actor.attemptsTo(AddAToDoItem.called(todo))
        );
    }
}
