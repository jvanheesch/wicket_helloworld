package com.github.jvanheesch;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;

public class HomePage extends WebPage {
    private static final long serialVersionUID = -4628714388032191363L;

    @Override
    protected void onInitialize() {
        super.onInitialize();

        this.add(new Label("message", "Hello World!"));
    }
}
