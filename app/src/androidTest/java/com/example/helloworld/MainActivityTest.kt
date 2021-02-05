package com.example.helloworld;

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import com.example.helloworld.MainActivity.number
import com.example.helloworld.SecondActivity.receivedMessage
import org.junit.Test
import java.util.*

class MainActivityTest {

    fun randomCount() {
        val randomNum: Int = Random().nextInt(25)
        for (i in 1..randomNum) {
            val randomChoice = Random().nextInt(2)
            if (randomChoice == 0) {
                onView(withId(R.id.button_countUp)).perform(click())
            } else {
                onView(withId(R.id.button_countDown)).perform(click())
            }
        }
    }

    @Test
    fun test_isActivityInView() {
        val activityScenario = ActivityScenario.launch(MainActivity::class.java)

        onView(withId(R.id.main))
                .check(matches(isDisplayed()))
    }

    @Test
    fun test_visibility_texts_buttons() {
        val activityScenario = ActivityScenario.launch(MainActivity::class.java)

        onView(withId(R.id.button_hello))
                .check(matches(isDisplayed()))

        onView(withId(R.id.textView_count))
                .check(matches(isDisplayed()))

        onView(withId(R.id.button_countUp))
                .check(matches(isDisplayed()))

        onView(withId(R.id.button_countDown))
                .check(matches(isDisplayed()))
    }

    @Test
    fun test_isTextDisplayed() {
        val activityScenario = ActivityScenario.launch(MainActivity::class.java)

        randomCount()

        onView(withId(R.id.button_hello))
                .check(matches(withText(R.string.button_hello)))

        onView(withId(R.id.textView_count))
                .check(matches(withText(number.toString())))

        onView(withId(R.id.button_countUp))
                .check(matches(withText(R.string.button_countUp)))

        onView(withId(R.id.button_countDown))
                .check(matches(withText(R.string.button_countDown)))
    }

    @Test
    fun test_navSecondActivity() {
        val activityScenario = ActivityScenario.launch(MainActivity::class.java)

        onView(withId(R.id.button_hello))
                .perform(click())

        onView(withId(R.id.secondary))
                .check(matches(isDisplayed()))
    }

    @Test
    fun test_backPress_toMainActivity() {
        val activityScenario = ActivityScenario.launch(MainActivity::class.java)

        randomCount()

        onView(withId(R.id.button_hello))
                .perform(click())

        onView(withId(R.id.button_goBack))
                .perform(click())

        onView(withId(R.id.main))
                .check(matches(isDisplayed()))

        onView(withId(R.id.textView_count))
                .check(matches(withText(number.toString())))
    }

    @Test
    fun test_isNumTextViewCorrect() {
        val activityScenario = ActivityScenario.launch(MainActivity::class.java)

        randomCount()

        onView(withId(R.id.button_hello))
                .perform(click())

        onView(withId(R.id.invisible))
                .check(matches(withText(receivedMessage.toString())))
    }
}

