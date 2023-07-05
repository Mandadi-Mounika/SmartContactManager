package com.cg.contact;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import springfox.documentation.spring.web.plugins.Docket;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class SmartContactManager1ApplicationTests {

    

    @Test
    public void swaggerConfigurationEnabled() {
        // Verify that the Swagger configuration is enabled
        SmartContactManager1Application application = new SmartContactManager1Application();
        Docket docket = application.productApi();
        assertNotNull(docket);
    }
}

