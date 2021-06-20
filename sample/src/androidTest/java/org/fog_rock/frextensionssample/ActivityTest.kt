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

    private val textMessage = "Hello World!"
    private val emptyMessage = ""

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
            .check(ViewAssertions.matches(ViewMatchers.withText(emptyMessage)))
    }

    /**
     * Context.startActivity(): Bundleあり
     */
    @Test fun startActivity_withBundle() {
        // Perform view actions.
        Espresso.onView(ViewMatchers.withId(R.id.editText_putExtra_message))
                .perform(ViewActions.replaceText(textMessage))
        Espresso.onView(ViewMatchers.withId(R.id.button_test_startActivity))
                .perform(ViewActions.click())
        // Check intent.
        IntentSubject.assertThat(Intents.getIntents().first()).apply {
            hasComponentClass(SubActivity::class.java.name)
            extras().string(SubActivity.ARGS_MESSAGE).isEqualTo(textMessage)
        }
        // Check views.
        Espresso.onView(ViewMatchers.withId(R.id.textView_message))
            .check(ViewAssertions.matches(ViewMatchers.withText(textMessage)))
    }

    /**
     * Context.startActivity(): 別のActivity表示
     */
    @Test fun startActivity_otherActivity() {
        // Perform view actions.
        Espresso.onView(ViewMatchers.withId(R.id.button_show_fragmentMainActivity))
                .perform(ViewActions.click())
        // Check intent.
        IntentSubject.assertThat(Intents.getIntents().first()).apply {
            hasComponentClass(FragmentMainActivity::class.java.name)
        }
    }

    /**
     * Context.startActivityAndFinishAll(): Bundleなし
     */
    @Test fun startActivityAndFinishAll_withoutBundle() {
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
            .check(ViewAssertions.matches(ViewMatchers.withText(emptyMessage)))
    }

    /**
     * Context.startActivityAndFinishAll(): Bundleあり
     */
    @Test fun startActivityAndFinishAll_withBundle() {
        // Perform view actions.
        Espresso.onView(ViewMatchers.withId(R.id.editText_putExtra_message))
            .perform(ViewActions.replaceText(textMessage))
        Espresso.onView(ViewMatchers.withId(R.id.button_test_startActivityAndFinishAll))
            .perform(ViewActions.click())
        // Check intent.
        IntentSubject.assertThat(Intents.getIntents().first()).apply {
            hasComponentClass(SubActivity::class.java.name)
            hasFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            hasFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
            extras().string(SubActivity.ARGS_MESSAGE).isEqualTo(textMessage)
        }
        // Check views.
        Espresso.onView(ViewMatchers.withId(R.id.textView_message))
            .check(ViewAssertions.matches(ViewMatchers.withText(textMessage)))
    }
}