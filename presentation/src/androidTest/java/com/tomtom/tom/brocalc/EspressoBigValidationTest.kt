package com.tomtom.tom.brocalc

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.espresso.matcher.ViewMatchers.withText
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import com.tomtom.tom.brocalc.ui.main.MainActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class EspressoBigValidationTest {

    private val delay:Long = 500

    @Rule @JvmField
    val mActivityRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun bigFunctionalityTest() {

        Thread.sleep(2000)

        //pick rows
        for (x in 0 .. 2) {
            onView(withId(R.id.currency_value_upper)).perform(click())
            Thread.sleep(delay)
            onView(withId(R.id.currency_value_lower)).perform(click())
            Thread.sleep(delay)
        }

        onView(withId(R.id.currency_value_lower)).perform(click())

        onView(withId(R.id.b1)).perform(click())
        Thread.sleep(delay)

        for (x in 0 .. 18) {
            onView(withId(R.id.b0)).perform(click())
            Thread.sleep(delay)
        }

        //check input limitation
        onView(withId(R.id.currency_value_lower)).check(matches(withText("100000000000")))

        //check AC
        onView(withId(R.id.ac)).perform(click())
        onView(withId(R.id.currency_value_upper)).check(matches(withText("0")))
        onView(withId(R.id.currency_value_lower)).check(matches(withText("0")))

        //check backspace
        onView(withId(R.id.currency_value_upper)).perform(click())

        onView(withId(R.id.b1)).perform(click())

        for (x in 0 .. 18) {
            onView(withId(R.id.b0)).perform(click())
            Thread.sleep(100)
        }

        onView(withId(R.id.currency_value_upper)).check(matches(withText("100000000000")))

        for (x in 0 .. 10) {
            onView(withId(R.id.back)).perform(click())
            Thread.sleep(100)
        }

        onView(withId(R.id.currency_value_upper)).check(matches(withText("1")))

        onView(withId(R.id.back)).perform(click())
        Thread.sleep(100)

        onView(withId(R.id.currency_value_upper)).check(matches(withText("0")))


        //check currency coice
        onView(withId(R.id.currency_choice_upper)).perform(click())
        Thread.sleep(1000)
        onView(withText("USD")).perform(click())

        onView(withId(R.id.currency_choice_lower)).perform(click())
        Thread.sleep(1000)
        onView(withText("JPY")).perform(click())

        onView(withId(R.id.currency_choice_upper)).perform(click())
        Thread.sleep(1000)
        onView(withText("JPY")).perform(click())

        onView(withId(R.id.currency_choice_lower)).check(matches(withText("USD")))

        Thread.sleep(2000)

    }
}