package com.expedia.test.config;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author shareef on 27/10/2017
 * loading Spring's context in your test .
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:test/resources/testContext.xml")
@WebAppConfiguration
abstract public class SpringContextTest {

    static {
        Logger.getLogger(SpringContextTest.class.getName())
                .log(Level.INFO, "Spring Context Test initialization called");
    }

}
