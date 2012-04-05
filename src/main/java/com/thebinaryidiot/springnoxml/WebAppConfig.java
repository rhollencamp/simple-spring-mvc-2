/*
 *   Copyright 2012 Robert Hollencamp
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 */
package com.thebinaryidiot.springnoxml;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.UrlBasedViewResolver;
import org.springframework.web.servlet.view.tiles2.TilesConfigurer;
import org.springframework.web.servlet.view.tiles2.TilesView;
import org.springframework.web.servlet.view.tiles2.TilesViewResolver;

/**
 * Configuration for Spring Web
 *
 * @author robert.hollencamp
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.thebinaryidiot.springnoxml.controller")
class WebAppConfig
{
	/**
	 * Get View Resolver - we are using Apache Tiles
	 *
	 * @return
	 */
	@Bean
	public UrlBasedViewResolver viewResolver()
	{
		TilesViewResolver resolver = new TilesViewResolver();
		resolver.setViewClass(TilesView.class);
		return resolver;
	}

	/**
	 * Create Tiles Configuration
	 *
	 * @return
	 */
	@Bean
	public TilesConfigurer tilesConfigurer()
	{
		TilesConfigurer configurer = new TilesConfigurer();
		configurer.setDefinitions(new String[] {
			"/WEB-INF/layouts/layouts.xml",
			"/WEB-INF/views/**/views.xml"
		});

		return configurer;
	}
}
