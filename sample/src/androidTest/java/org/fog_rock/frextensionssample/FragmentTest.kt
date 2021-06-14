package org.fog_rock.frextensionssample

import androidx.test.espresso.Espresso
import androidx.test.espresso.NoActivityResumedException
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Assert
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class FragmentTest {

    private val tagMainFragment = MainFragment::class.java.simpleName
    private val tagSubFragment = SubFragment::class.java.simpleName

    @get:Rule val activityScenarioRule = ActivityScenarioRule(FragmentMainActivity::class.java)

    /**
     * デフォルト状態のチェック
     */
    @Test fun defaultView() {
        Espresso.onView(ViewMatchers.withId(R.id.textView_message))
            .check(ViewAssertions.matches(ViewMatchers.withText(tagMainFragment)))
        Espresso.onView(ViewMatchers.withId(R.id.textView_className))
            .check(ViewAssertions.matches(ViewMatchers.withText(tagMainFragment)))
        try {
            Espresso.pressBack()
            Assert.fail("Should have thrown NoActivityResumedException.")
        } catch (e: NoActivityResumedException) {
            activityScenarioRule.scenario.close()
        }
    }

    /**
     * FragmentActivity.addFragment()
     */
    @Test fun addFragment() {
        Espresso.onView(ViewMatchers.withId(R.id.button_test_addFragment))
            .perform(ViewActions.click())
        Espresso.onView(ViewMatchers.withId(R.id.textView_message))
            .check(ViewAssertions.matches(ViewMatchers.withText(tagSubFragment)))
        Espresso.onView(ViewMatchers.withId(R.id.textView_className))
            .check(ViewAssertions.matches(ViewMatchers.withText(tagSubFragment)))
        Espresso.pressBack()
        Espresso.onView(ViewMatchers.withId(R.id.textView_message))
            .check(ViewAssertions.matches(ViewMatchers.withText(tagMainFragment)))
        Espresso.onView(ViewMatchers.withId(R.id.textView_className))
            .check(ViewAssertions.matches(ViewMatchers.withText(tagMainFragment)))
    }

    /**
     * FragmentActivity.replaceFragment()
     */
    @Test fun replaceFragment() {
        Espresso.onView(ViewMatchers.withId(R.id.button_test_replaceFragment))
            .perform(ViewActions.click())
        Espresso.onView(ViewMatchers.withId(R.id.textView_message))
            .check(ViewAssertions.matches(ViewMatchers.withText(tagSubFragment)))
        Espresso.onView(ViewMatchers.withId(R.id.textView_className))
            .check(ViewAssertions.matches(ViewMatchers.withText(tagSubFragment)))
        try {
            Espresso.pressBack()
            Assert.fail("Should have thrown NoActivityResumedException.")
        } catch (e: NoActivityResumedException) {
            activityScenarioRule.scenario.close()
        }
    }
}