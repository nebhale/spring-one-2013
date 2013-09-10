/*
 * Copyright 2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.nebhale.springone2013.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestResponseBodyMethodProcessor;

import com.nebhale.springone2013.jsonviewoutput.ViewAwareMappingJackson2HttpMessageConverter;
import com.nebhale.springone2013.jsonviewoutput.ViewInjectingReturnValueHandler;

@Configuration
@ComponentScan(basePackages = "com.nebhale.springone2013")
@EnableWebMvc
public class WebConfiguration extends WebMvcConfigurerAdapter {

    @Autowired
    private volatile RequestMappingHandlerAdapter requestMappingHandlerAdapter;

    @Bean
    ViewInjectingReturnValueHandler viewInjectingReturnValueHandler() {
        List<HandlerMethodReturnValueHandler> handlers = new ArrayList<>(this.requestMappingHandlerAdapter.getReturnValueHandlers().getHandlers());

        for (HandlerMethodReturnValueHandler handler : handlers) {
            if (handler instanceof RequestResponseBodyMethodProcessor) {
                ViewInjectingReturnValueHandler decorator = new ViewInjectingReturnValueHandler(handler);
                int index = handlers.indexOf(handler);
                handlers.set(index, decorator);

                this.requestMappingHandlerAdapter.setReturnValueHandlers(handlers);
                return decorator;
            }
        }

        return null;
    }

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(new ViewAwareMappingJackson2HttpMessageConverter());
    }
}
