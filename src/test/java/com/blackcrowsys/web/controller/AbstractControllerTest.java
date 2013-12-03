package com.blackcrowsys.web.controller;

import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.blackcrowsys.test.config.ControllerTestConfig;

/**
 * Abstract base class for Controller Tests.
 *
 * @author rahulsingh
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ControllerTestConfig.class})
@ActiveProfiles("test")
public abstract class AbstractControllerTest {

}
