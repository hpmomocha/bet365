package com.hpe.kevin;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

public class Bet365SecurityWebApplicationInitializer extends AbstractSecurityWebApplicationInitializer {
    public Bet365SecurityWebApplicationInitializer() {
        super();
    }

    // Nothing else to implement. We will just use the defaults.
    // The extended initializer class will take care of registering the Spring Security filter infrastructure.
}
