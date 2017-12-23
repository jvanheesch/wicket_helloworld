package com.github.jvanheesch;

import org.apache.wicket.protocol.http.WicketFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean
    public FilterRegistrationBean someFilterRegistration() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setName("WicketApplication");
        registration.setFilter(new WicketFilter());
        registration.addInitParameter("applicationClassName", WicketApplication.class.getName());
        registration.addInitParameter(WicketFilter.FILTER_MAPPING_PARAM, "/*");
        registration.addUrlPatterns("/*");
        return registration;
    }
}
