/*
 * Copyright (c) 2021 SallyLueNoa
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.fog_rock.frextensionssample

import androidx.test.espresso.Espresso
import androidx.test.espresso.NoActivityResumedException
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.*
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class FragmentTest {

    @get:Rule val activityScenarioRule = ActivityScenarioRule(FragmentMainActivity::class.java)

    @Before
    fun before() {
        Intents.init()
    }

    @After
    fun after() {
        Intents.release()
    }

    /**
     * Check default state.
     */
    @Test
    fun defaultState() {
        // Check views.
        Espresso.onView(ViewMatchers.withId(R.id.textView_message))
            .check(ViewAssertions.matches(ViewMatchers.withText("MainFragment 0")))
        // Press back.
        try {
            Espresso.pressBack()
            Assert.fail("Should have thrown NoActivityResumedException.")
        } catch (e: NoActivityResumedException) {
            activityScenarioRule.scenario.close()
        }
    }

    /**
     * FragmentActivity.addFragment(): Click once.
     */
    @Test
    fun addFragment_once() {
        // Perform view actions.
        Espresso.onView(ViewMatchers.withId(R.id.button_test_addFragment))
            .perform(ViewActions.click())
        // Check views.
        Espresso.onView(ViewMatchers.withId(R.id.textView_message))
            .check(ViewAssertions.matches(ViewMatchers.withText("SubFragment 1")))
        // Press back.
        Espresso.pressBack()
        // Check views.
        Espresso.onView(ViewMatchers.withId(R.id.textView_message))
            .check(ViewAssertions.matches(ViewMatchers.withText("MainFragment 0")))
        // Press back.
        try {
            Espresso.pressBack()
            Assert.fail("Should have thrown NoActivityResumedException.")
        } catch (e: NoActivityResumedException) {
            activityScenarioRule.scenario.close()
        }
    }

    /**
     * FragmentActivity.addFragment(): Click several times.
     */
    @Test
    fun addFragment_severalTimes() {
        for (i in 1..3) {
            // Perform view actions.
            Espresso.onView(ViewMatchers.withId(R.id.button_test_addFragment))
                .perform(ViewActions.click())
            // Check views.
            Espresso.onView(ViewMatchers.withId(R.id.textView_message))
                .check(ViewAssertions.matches(ViewMatchers.withText("SubFragment $i")))
        }
        for (i in 2 downTo 0) {
            // Press back.
            Espresso.pressBack()
            // Check views.
            Espresso.onView(ViewMatchers.withId(R.id.textView_message))
                .check(ViewAssertions.matches(ViewMatchers.withText(
                    if (i > 0) "SubFragment $i" else "MainFragment 0"
                )))
        }
        // Press back.
        try {
            Espresso.pressBack()
            Assert.fail("Should have thrown NoActivityResumedException.")
        } catch (e: NoActivityResumedException) {
            activityScenarioRule.scenario.close()
        }
    }

    /**
     * FragmentActivity.replaceFragment(): Click once.
     */
    @Test
    fun replaceFragment_once() {
        // Perform view actions.
        Espresso.onView(ViewMatchers.withId(R.id.button_test_replaceFragment))
            .perform(ViewActions.click())
        // Check views.
        Espresso.onView(ViewMatchers.withId(R.id.textView_message))
            .check(ViewAssertions.matches(ViewMatchers.withText("SubFragment 0")))
        // Press back.
        try {
            Espresso.pressBack()
            Assert.fail("Should have thrown NoActivityResumedException.")
        } catch (e: NoActivityResumedException) {
            activityScenarioRule.scenario.close()
        }
    }

    /**
     * FragmentActivity.replaceFragment(): Click several times.
     */
    @Test
    fun replaceFragment_severalTimes() {
        for (i in 1..3) {
            // Perform view actions.
            Espresso.onView(ViewMatchers.withId(R.id.button_test_replaceFragment))
                .perform(ViewActions.click())
            // Check views.
            Espresso.onView(ViewMatchers.withId(R.id.textView_message))
                .check(ViewAssertions.matches(ViewMatchers.withText("SubFragment 0")))
        }
        // Press back.
        try {
            Espresso.pressBack()
            Assert.fail("Should have thrown NoActivityResumedException.")
        } catch (e: NoActivityResumedException) {
            activityScenarioRule.scenario.close()
        }
    }
}