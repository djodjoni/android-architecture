package com.example.android.architecture.blueprints.todoapp.cuc;

import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;

import com.example.android.architecture.blueprints.todoapp.Injection;
import com.example.android.architecture.blueprints.todoapp.R;
import com.example.android.architecture.blueprints.todoapp.data.source.TasksDataSource;
import com.example.android.architecture.blueprints.todoapp.tasks.TasksActivity;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

public class Steps {

    public ActivityTestRule<TasksActivity> mTasksActivityTestRule =
            new ActivityTestRule<TasksActivity>(TasksActivity.class) {

        /**
         * To avoid a long list of tasks and the need to scroll through the list to find a
         * task, we call {@link TasksDataSource#deleteAllTasks()} before each test.
         */
        @Override
        protected void beforeActivityLaunched() {
            super.beforeActivityLaunched();
            // Doing this in @Before generates a race condition.
            Injection.provideTasksRepository(InstrumentationRegistry.getTargetContext())
                    .deleteAllTasks();
        }
    };

    @Before
    public void setUp() {
        mTasksActivityTestRule.launchActivity(null);
    }

    @After
    public void tearDown() {
        mTasksActivityTestRule.getActivity().finish();
    }

    @When("^I Click on the add task button$")
    public void i_Click_on_the_add_task_button() throws Throwable {
        onView(withId(R.id.fab_add_task)).perform(click());
    }
    @Then("^I should have add task screen displayed$")
    public void i_should_have_add_task_screen_displayed() throws Throwable {
        onView(withId(R.id.add_task_title)).check(matches(isDisplayed()));
    }
    @Then("^smth else$")
    public void smth_else() throws Throwable {
// Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

}
