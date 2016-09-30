package com.example.android.architecture.blueprints.todoapp;


import android.os.Bundle;
import android.support.test.runner.AndroidJUnitRunner;

import cucumber.api.android.CucumberInstrumentationCore;


public class CucRunner extends AndroidJUnitRunner {
    private CucumberInstrumentationCore cucumberInstrumentationCore = new
            CucumberInstrumentationCore(this);

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        //note you can put those in CucumberOptions also
        //bundle.putString("features", "features");
        //bundle.putString("glue", "com.example.android.architecture.blueprints.todoapp.cuc");
        //bundle.putString("tags", "~@skipAndroid");
        this.cucumberInstrumentationCore.create(bundle);
    }

    @Override
    public void onStart() {
        //normally waitForIdleSync this is called by the MonitoringInstrumentation
        //however it'll not hurt if we do it and prevent from errors if Google changes it
        waitForIdleSync();
        this.cucumberInstrumentationCore.start();
    }
}