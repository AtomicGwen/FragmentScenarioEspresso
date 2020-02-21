package com.example.android.testing.espresso.fragmentscenario

import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.idling.CountingIdlingResource
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.android.testing.espresso.LoginFragment
import com.example.android.testing.espresso.LoginViewModel
import org.hamcrest.core.IsNot.not

import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.annotation.LooperMode


/**
 * A test using the androidx.test unified API, which can execute on an Android device or locally using Robolectric.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
@LooperMode(LooperMode.Mode.PAUSED)
class LoginFragmentTest {
    @Test
    fun launchFragmentAndVerifyUI() {
        launchFragmentInContainer<LoginFragment>()

        onView(withId(R.id.usernameText)).check(matches(withHint("Username")))
        onView(withId(R.id.passwordText)).check(matches(withHint("Password")))
        onView(withId(R.id.loginButton)).check(matches(withText("Login")))
    }

    @Test
    fun login() {
        val idlingResource = IntentServiceIdlingResource()
        IdlingRegistry.getInstance().register(idlingResource)

        launchFragmentInContainer<LoginFragment>()

        // 'Login'
        onView(withId(R.id.usernameText)).perform(typeText("Hello"), closeSoftKeyboard())
        onView(withId(R.id.passwordText)).perform(typeText("World"), closeSoftKeyboard())
        onView(withId(R.id.loginButton)).perform(click())

        onView(withId(R.id.loggedInText)).check(matches(withText("Logged in!")))

        IdlingRegistry.getInstance().unregister(idlingResource)
    }
}
