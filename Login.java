package org.wikipedia.JavaTest;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.pressBack;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static androidx.test.espresso.action.ViewActions.swipeDown;
import static androidx.test.espresso.action.ViewActions.swipeUp;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withHint;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import static org.hamcrest.Matchers.allOf;

import android.widget.Toast;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.wikipedia.R;
import org.wikipedia.main.MainActivity;

@RunWith(AndroidJUnit4.class)
public class Login {
    private String stringToBetyped;

    @Rule
    public ActivityScenarioRule<MainActivity> activityRule
            = new ActivityScenarioRule<>(MainActivity.class);

    @Before
    public void initValidString() {
        // Specify a valid string.
        stringToBetyped = "Espresso";
    }

    @Test
    public void Login() throws InterruptedException {

        onView(allOf(withId(R.id.fragment_onboarding_skip_button), isDisplayed())).perform(click());

        onView(allOf(withId(R.id.nav_more_container), isDisplayed())).perform(click());

        onView(allOf(withId(R.id.main_drawer_login_button), isDisplayed())).perform(click());

        onView(allOf(withId(R.id.create_account_login_button), isDisplayed())).perform(click());

        onView(allOf(withHint(R.string.login_username_hint))).perform(click(), typeText("pixxxta"));

        onView(allOf(withHint(R.string.login_password_hint))).perform(click(), typeText("09eietaZ"));

        onView(allOf(withId(R.id.login_button), isDisplayed())).perform(click());

        Thread.sleep(5000);

        onView(allOf(withText("НЕТ, СПАСИБО"), isDisplayed())).perform(click());

        onView(allOf(withId(R.id.menu_notifications))).check(matches(isDisplayed()));


    }

    @Test
    public void Logout() throws InterruptedException {

        onView(allOf(withText("ПРОПУСТИТЬ"), isDisplayed())).perform(click());
        onView(withId(R.id.menu_icon)).perform(click());
        onView(withId(R.id.main_drawer_settings_container)).perform(click());
        onView(withId(android.R.id.content)).perform(swipeUp());
        Thread.sleep(1000);
        onView(withId(R.id.logoutButton)).perform(click());
        onView(withText("ЗАВЕРШЕНИЕ СЕАНСА")).perform(click());
        Thread.sleep(1000);
        onView(withText(R.string.toast_logout_complete)).check(matches(isDisplayed()));
        Thread.sleep(5000);


    }

    @Test
    public void switchActivity() throws InterruptedException {
        onView(allOf(withText("ПРОПУСТИТЬ"), isDisplayed())).perform(click());
        onView(allOf(withText("Сохранено"), isDisplayed())).perform(click());
        onView(allOf(withId(R.id.menu_search_lists))).check(matches(isDisplayed()));
    }

    @Test
    public void changeTheme() throws InterruptedException {
        onView(allOf(withText("ПРОПУСТИТЬ"), isDisplayed())).perform(click());
        onView(withId(R.id.menu_icon)).perform(click());
        onView(withId(R.id.main_drawer_settings_container)).perform(click());
        onView(allOf(withId(R.id.menu_search_lists), isDisplayed()));
//        onView(allOf(withText("Светлое"), isDisplayed()));
        onView(allOf(withText("Оформление приложения"), isDisplayed())).perform(click());
        onView(withId(R.id.button_theme_sepia)).perform(click());
        onView(withId(R.id.touch_outside)).perform(click());
        onView(allOf(withId(R.id.text_size_percent), isDisplayed())).perform(pressBack());
        onView(withText("Сепия")).check(matches(isDisplayed()));
        Thread.sleep(5000);
    }
}
