package net.serenity.tutorials.questions;

import net.serenity.tutorials.ui.TheTodoList;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

import java.util.List;

public class TheTodoItems implements Question<List<String>> {
    public static Question<List<String>> displayed() {
        return new TheTodoItems();
    }

    @Override
    public List<String> answeredBy(Actor actor) {
        return Text.of(TheTodoList.ITEMS)
                .viewedBy(actor)
                .asList();
    }
}
