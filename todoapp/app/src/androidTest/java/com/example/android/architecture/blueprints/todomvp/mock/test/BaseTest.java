package com.example.android.architecture.blueprints.todomvp.mock.test;


import cucumber.api.CucumberOptions;

@CucumberOptions(
        features = "features", // Test scenarios
        glue = {"com.example.android.architecture.blueprints.todoapp.cuc"}, // Steps definitions
        // tags = {"~@skip", "~@skipAndroid"}
        format = {"json:/data/data/com.example.android.architecture.blueprints.todomvp" +
                ".mock/cuc/cuc.json",
                "html:/data/data/com.example.android.architecture.blueprints.todomvp.mock/cuc/html"}
)
public class BaseTest {

}


