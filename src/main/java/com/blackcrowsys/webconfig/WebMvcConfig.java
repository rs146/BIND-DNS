package com.blackcrowsys.webconfig;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.json.MappingJacksonJsonView;

/**
 * @author rahulsingh
 * 
 * MVC configuration.
 */
@Configuration
@EnableWebMvc
public class WebMvcConfig extends WebMvcConfigurationSupport {

    @Bean
    @Override
    public RequestMappingHandlerMapping requestMappingHandlerMapping() {
        RequestMappingHandlerMapping result = super.requestMappingHandlerMapping();
        result.setUseSuffixPatternMatch(false);
        result.setUseTrailingSlashMatch(false);
        return result;
    }

    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/").setCachePeriod(3155);
    }

    @Bean
    public ContentNegotiatingViewResolver contentNegotiatingViewResolver() {
        ContentNegotiatingViewResolver result = new ContentNegotiatingViewResolver();
        Map<String, String> mediaTypes = new HashMap<String, String>();
        mediaTypes.put("json", MediaType.APPLICATION_JSON_VALUE);
        result.setMediaTypes(mediaTypes);
        MappingJacksonJsonView jacksonView = new MappingJacksonJsonView();
        jacksonView.setExtractValueFromSingleKeyModel(true);
        Set<String> modelKeys = new HashSet<String>();
        modelKeys.add("networks");
        modelKeys.add("network");
        jacksonView.setModelKeys(modelKeys);
        result.setDefaultViews(Collections.singletonList((View) jacksonView));
        return result;
    }

    @Bean
    public InternalResourceViewResolver internalResolver() {
        InternalResourceViewResolver internalResolver = new InternalResourceViewResolver();
        internalResolver.setPrefix("/WEB-INF/views/");
        internalResolver.setSuffix(".jsp");
        return internalResolver;
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        super.addViewControllers(registry);
        registry.addViewController("/login/form")
                .setViewName("login");
        registry.addViewController("/errors/403")
                .setViewName("/errors/403");
    }
}
