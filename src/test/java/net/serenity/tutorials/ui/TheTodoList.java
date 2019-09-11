package net.serenity.tutorials.ui;

import net.serenitybdd.screenplay.targets.Target;

public class TheTodoList {

    public static final Target WHAT_NEEDS_TO_BE_DONE = Target.the(" 'What needs to done?' field")
            .locatedBy("#new-todo");
    public static final Target ITEMS = Target.the("List of To Do items")
            .locatedBy(".view label");
}
