package com.supermanzer.criminalintent

import androidx.fragment.app.testing.FragmentScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class CrimeDetailFragmentTest {
    private lateinit var scenario: FragmentScenario<CrimeDetailFragment>

    @Before
    fun setUp() {
        scenario = FragmentScenario.launch(CrimeDetailFragment::class.java)
    }

    @After
    fun teardown() {
        scenario.close()
    }

    @Test
    fun enterTitleUpdatesCrime() {
        val TITLE = "Stolen Yogurt"
        onView(withId(R.id.crime_title)).perform(typeText(TITLE))
        onView(withId(R.id.crime_title))
            .check(matches(withText(TITLE)))
    }

    @Test
    fun checkBoxSolved() {
        onView(withId(R.id.crime_solved)).perform(click())

    }
}