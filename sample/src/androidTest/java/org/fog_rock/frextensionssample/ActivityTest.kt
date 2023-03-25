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

import android.content.Intent
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.ext.truth.content.IntentSubject
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ActivityTest {

    @get:Rule val activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Before
    fun before() {
        Intents.init()
    }

    @After
    fun after() {
        Intents.release()
    }

    /**
     * Context.startActivity(): Without Bundle.
     */
    @Test
    fun startActivity_withoutBundle() {
        // Perform view actions.
        Espresso.onView(ViewMatchers.withId(R.id.button_test_startActivity))
                .perform(ViewActions.click())
        // Check intent.
        IntentSubject.assertThat(Intents.getIntents().first()).apply {
            hasComponentClass(SubActivity::class.java.name)
            extras().isNull()
        }
        // Check views.
        Espresso.onView(ViewMatchers.withId(R.id.textView_message))
            .check(ViewAssertions.matches(ViewMatchers.withText("")))
    }

    /**
     * Context.startActivity(): With Bundle.
     */
    @Test
    fun startActivity_withBundle() {
        // Perform view actions.
        Espresso.onView(ViewMatchers.withId(R.id.editText_message))
                .perform(ViewActions.replaceText("startActivity"))
        Espresso.onView(ViewMatchers.withId(R.id.button_test_startActivity))
                .perform(ViewActions.click())
        // Check intent.
        IntentSubject.assertThat(Intents.getIntents().first()).apply {
            hasComponentClass(SubActivity::class.java.name)
            extras().string(SubActivity.ARGS_MESSAGE).isEqualTo("startActivity")
        }
        // Check views.
        Espresso.onView(ViewMatchers.withId(R.id.textView_message))
            .check(ViewAssertions.matches(ViewMatchers.withText("startActivity")))
    }

    /**
     * Context.startActivity(): Show other Activity.
     */
    @Test
    fun startActivity_otherActivity() {
        // Perform view actions.
        Espresso.onView(ViewMatchers.withId(R.id.button_show_fragmentMainActivity))
                .perform(ViewActions.click())
        // Check intent.
        IntentSubject.assertThat(Intents.getIntents().first()).apply {
            hasComponentClass(FragmentMainActivity::class.java.name)
        }
    }

    /**
     * Context.startActivityAndFinishAll(): Without Bundle.
     */
    @Test
    fun startActivityAndFinishAll_withoutBundle() {
        // Perform view actions.
        Espresso.onView(ViewMatchers.withId(R.id.button_test_startActivityAndFinishAll))
            .perform(ViewActions.click())
        // Check intent.
        IntentSubject.assertThat(Intents.getIntents().first()).apply {
            hasComponentClass(SubActivity::class.java.name)
            hasFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            hasFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
            extras().isNull()
        }
        // Check views.
        Espresso.onView(ViewMatchers.withId(R.id.textView_message))
            .check(ViewAssertions.matches(ViewMatchers.withText("")))
    }

    /**
     * Context.startActivityAndFinishAll(): With Bundle.
     */
    @Test
    fun startActivityAndFinishAll_withBundle() {
        // Perform view actions.
        Espresso.onView(ViewMatchers.withId(R.id.editText_message))
            .perform(ViewActions.replaceText("startActivityAndFinishAll"))
        Espresso.onView(ViewMatchers.withId(R.id.button_test_startActivityAndFinishAll))
            .perform(ViewActions.click())
        // Check intent.
        IntentSubject.assertThat(Intents.getIntents().first()).apply {
            hasComponentClass(SubActivity::class.java.name)
            hasFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            hasFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
            extras().string(SubActivity.ARGS_MESSAGE).isEqualTo("startActivityAndFinishAll")
        }
        // Check views.
        Espresso.onView(ViewMatchers.withId(R.id.textView_message))
            .check(ViewAssertions.matches(ViewMatchers.withText("startActivityAndFinishAll")))
    }
}