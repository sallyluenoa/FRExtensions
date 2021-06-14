package org.fog_rock.frextensionssample

import android.content.Intent
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
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

    private val textMessage = "Hello World!"

    @get:Rule val activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Before fun before() {
        Intents.init()
    }

    @After fun after() {
        Intents.release()
    }

    /**
     * Context.startActivity(): Bundleなし
     */
    @Test fun startActivity_withoutBundle() {
        Espresso.onView(ViewMatchers.withId(R.id.button_test_startActivity))
                .perform(ViewActions.click())
        Intents.intended(Matchers.allOf(
                IntentMatchers.hasComponent(SubActivity::class.java.name),
                IntentMatchers.hasFlags(0)
        ))
        Espresso.onView(ViewMatchers.withId(R.id.textView_message))
            .check(ViewAssertions.matches(ViewMatchers.withText("")))
    }

    /**
     * Context.startActivity(): Bundleあり
     */
    @Test fun startActivity_withBundle() {
        Espresso.onView(ViewMatchers.withId(R.id.editText_putExtra_message))
                .perform(ViewActions.replaceText(textMessage))
        Espresso.onView(ViewMatchers.withId(R.id.button_test_startActivity))
                .perform(ViewActions.click())
        Intents.intended(Matchers.allOf(
            IntentMatchers.hasComponent(SubActivity::class.java.name),
            IntentMatchers.hasFlags(0),
            IntentMatchers.hasExtra(SubActivity.ARGS_MESSAGE, textMessage)
        ))
        Espresso.onView(ViewMatchers.withId(R.id.textView_message))
            .check(ViewAssertions.matches(ViewMatchers.withText(textMessage)))
    }

    /**
     * Context.startActivity(): 別のActivity表示
     */
    @Test fun startActivity_otherActivity() {
        Espresso.onView(ViewMatchers.withId(R.id.button_show_fragmentMainActivity))
                .perform(ViewActions.click())
        Intents.intended(Matchers.allOf(
                IntentMatchers.hasComponent(FragmentMainActivity::class.java.name),
                IntentMatchers.hasFlags(0)
        ))
    }

    /**
     * Context.startActivityAndFinishAll(): Bundleなし
     */
    @Test fun startActivityAndFinishAll_withoutBundle() {
        Espresso.onView(ViewMatchers.withId(R.id.button_test_startActivityAndFinishAll))
            .perform(ViewActions.click())
        Intents.intended(Matchers.allOf(
            IntentMatchers.hasComponent(SubActivity::class.java.name),
            IntentMatchers.hasFlags(Intent.FLAG_ACTIVITY_NEW_TASK, Intent.FLAG_ACTIVITY_CLEAR_TASK)
        ))
        Espresso.onView(ViewMatchers.withId(R.id.textView_message))
            .check(ViewAssertions.matches(ViewMatchers.withText("")))
    }

    /**
     * Context.startActivityAndFinishAll(): Bundleあり
     */
    @Test fun startActivityAndFinishAll_withBundle() {
        Espresso.onView(ViewMatchers.withId(R.id.editText_putExtra_message))
            .perform(ViewActions.replaceText(textMessage))
        Espresso.onView(ViewMatchers.withId(R.id.button_test_startActivityAndFinishAll))
            .perform(ViewActions.click())
        Intents.intended(Matchers.allOf(
            IntentMatchers.hasComponent(SubActivity::class.java.name),
            IntentMatchers.hasFlags(Intent.FLAG_ACTIVITY_NEW_TASK, Intent.FLAG_ACTIVITY_CLEAR_TASK),
            IntentMatchers.hasExtra(SubActivity.ARGS_MESSAGE, textMessage)
        ))
        Espresso.onView(ViewMatchers.withId(R.id.textView_message))
            .check(ViewAssertions.matches(ViewMatchers.withText(textMessage)))
    }
}