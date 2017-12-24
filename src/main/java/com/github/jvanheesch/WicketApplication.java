package com.github.jvanheesch;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.spring.injection.annot.SpringComponentInjector;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WicketApplication extends WebApplication {
    @Override
    public Class<? extends WebPage> getHomePage() {
        return HomePage.class;
    }

    @Override
    protected void init() {
        super.init();

        this.getComponentInstantiationListeners().add(new SpringComponentInjector(this));
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(WicketApplication.class, args);
    }
}
