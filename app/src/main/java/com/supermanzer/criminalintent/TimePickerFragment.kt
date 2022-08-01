package com.supermanzer.criminalintent

import android.app.Dialog
import android.app.TimePickerDialog
import android.icu.util.Calendar
import android.icu.util.GregorianCalendar

import android.os.Bundle
import android.text.format.DateFormat
import android.widget.TimePicker
import androidx.core.os.bundleOf
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.setFragmentResult
import androidx.navigation.fragment.navArgs


class TimePickerFragment : DialogFragment(), TimePickerDialog.OnTimeSetListener {

    private val args: TimePickerFragmentArgs by navArgs()

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val timeListener = TimePickerDialog.OnTimeSetListener { _: TimePicker, hour: Int, minute: Int ->
            val calendar = Calendar.getInstance()
            calendar.time = args.crimeTime
            val myYear = calendar.get(Calendar.YEAR)
            val myMonth = calendar.get(Calendar.MONTH)
            val myDay = calendar.get(Calendar.DAY_OF_MONTH)
            val resultDate = GregorianCalendar(myYear,myMonth, myDay, hour, minute).time

            setFragmentResult(REQUEST_KEY_TIME, bundleOf(BUNDLE_KEY_TIME to resultDate))
        }

        val calendar = Calendar.getInstance()
        calendar.time = args.crimeTime
        val hour = calendar.get(Calendar.HOUR)
        val minute = calendar.get(Calendar.MINUTE)

        return TimePickerDialog(requireContext(), timeListener, hour, minute, DateFormat.is24HourFormat(requireContext()))
    }

    companion object {
        const val REQUEST_KEY_TIME = "REQUEST_KEY_TINE"
        const val BUNDLE_KEY_TIME = "BUNDLE_KEY_TIME"
    }

    override fun onTimeSet(p0: TimePicker?, p1: Int, p2: Int) {
        TODO("Not yet implemented")
    }
}