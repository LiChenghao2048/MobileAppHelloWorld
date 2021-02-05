package com.example.helloworld;

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*

import org.junit.Test

class SecondActivityTest {

    @Test
    fun test_isActivityInView() {
        val activityScenario = ActivityScenario.launch(SecondActivity::class.java)

        onView(withId(R.id.secondary))
                .check(matches(isDisplayed()))
    }

    @Test
    fun test_visibility_button() {
        val activityScenario = ActivityScenario.launch(SecondActivity::class.java)

        onView(withId(R.id.button_goBack))
                .check(matches(isDisplayed()))
    }

    @Test
    fun test_isTextDisplayed() {
        val activityScenario = ActivityScenario.launch(SecondActivity::class.java)

        onView(withId(R.id.button_goBack))
                .check(matches(withText(R.string.button_goBack)))
    }
}