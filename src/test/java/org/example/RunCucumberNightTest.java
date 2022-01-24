package org.example;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

import static io.cucumber.junit.platform.engine.Constants.*;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("org/example")
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "pretty, json:target/report.json, html:target/report.html")
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "org.example")
@ConfigurationParameter(key = FILTER_TAGS_PROPERTY_NAME, value = "@NightTest")
public class RunCucumberNightTest {
}
