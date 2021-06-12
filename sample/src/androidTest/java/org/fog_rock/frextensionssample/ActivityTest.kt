package org.fog_rock.frextensionssample

import android.content.Intent
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.matcher.IntentMatchers
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.hamcrest.Matchers
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ActivityTest {

    @get:Rule val activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Before fun before() {
        Intents.init()
    }

    @After fun after() {
        Intents.release()
    }

    @Test fun test_startActivity() {
        Espresso.onView(ViewMatchers.withId(R.id.button_test_startActivity))
                .perform(ViewActions.click())
        Intents.intended(Matchers.allOf(
                IntentMatchers.hasComponent(SubActivity::class.java.name),
                IntentMatchers.hasFlags(0)
        ))
    }

    @Test fun test_startActivityAndFinishAll() {
        Espresso.onView(ViewMatchers.withId(R.id.button_test_startActivityAndFinishAll))
                .perform(ViewActions.click())
        Intents.intended(Matchers.allOf(
                IntentMatchers.hasComponent(SubActivity::class.java.name),
                IntentMatchers.hasFlags(Intent.FLAG_ACTIVITY_NEW_TASK, Intent.FLAG_ACTIVITY_CLEAR_TASK)
        ))
    }
}