package com.example.android.architecture.blueprints.todomvp.test;


import cucumber.api.CucumberOptions;

@CucumberOptions(
        features = "features", // Test scenarios
        glue = {"com.example.android.architecture.blueprints.todoapp.cuc"}, // Steps definitions
        // tags = {"~@skip", "~@skipAndroid"}
        format = {"pretty",
                "json:/data/data/com.example.android.architecture.blueprints.todomvp/cuc/cuc.json",
                "html:/data/data/com.example.android.architecture.blueprints.todomvp/cuc/html"}
)
public class BaseTest {

}


