package com.Librarian.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"html:target/cucumber-reports",
                "rerun:target/rerun.txt"
        },
        features = "src/test/resources/features",
        glue = "com/Librarian/step_definitions",
        dryRun = true,
        tags = "@borrow_book",
        publish = true
)
public class CucumberRunner {
}
