package com.github.jvanheesch;

import org.apache.wicket.protocol.http.WicketFilter;
import org.springframework.web.WebApplicationInitializer;

import javax.servlet.FilterRegistration.Dynamic;
import javax.servlet.ServletContext;

public class SpringWebApplicationInitializer implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext servletContext) {
        Dynamic wicketApplicationFilter = servletContext.addFilter("WicketApplication", new WicketFilter());
        wicketApplicationFilter.setInitParameter("applicationClassName", WicketApplication.class.getName());
        // https://stackoverflow.com/a/5494421/1939921
        wicketApplicationFilter.setInitParameter(WicketFilter.FILTER_MAPPING_PARAM, "/*");
        // https://www.javatips.net/api/brix-cms-plugins-master/brix-plugins-demo/src/main/java/org/brixcms/plugin/demo/WebInitializer.java
        // Not quite sure what this does, but it seems to do the job.
        wicketApplicationFilter.addMappingForUrlPatterns(null, false, "/*");
    }
}
