package com.order.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.reactive.config.WebFluxConfigurer;

/**
 * The Class WebFluxConfig.
 */
@Configuration
@EnableWebFlux
public class WebFluxConfig implements WebFluxConfigurer {
}