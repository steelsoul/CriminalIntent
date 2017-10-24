package com.bignerdranch.android.criminalintent;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.icu.util.GregorianCalendar;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.View;
import android.widget.TimePicker;

import java.util.Date;

import static com.bignerdranch.android.criminalintent.DatePickerFragment.EXTRA_DATE;

/**
 * Created by alex on 24.10.17.
 * Another dialog fragment, exercise.
 */

public class TimePickerFragment extends DialogFragment {

    private Date mTime;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        mTime = (Date)getArguments().getSerializable(EXTRA_DATE);

        View v = getActivity().getLayoutInflater()
                .inflate(R.layout.dialog_time, null);
        TimePicker timePicker = v.findViewById(R.id.dialog_time_picker);

        timePicker.setCurrentHour(mTime.getHours());
        timePicker.setCurrentMinute(mTime.getMinutes());

        return new AlertDialog.Builder(getActivity())
                .setView(v)
                .setTitle(R.string.time_picker_title)
                .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        sendResult(Activity.RESULT_OK);
                    }
                })
                .create();
    }

    private void sendResult(int resultCode) {
        if (getTargetFragment() != null) {
            Intent i = new Intent();
            i.putExtra(EXTRA_DATE, mTime);

            getTargetFragment()
                    .onActivityResult(getTargetRequestCode(), resultCode, i);
        }
    }

    public static TimePickerFragment newInstance(Date time) {
        Bundle args = new Bundle();
        args.putSerializable(EXTRA_DATE, time);
        TimePickerFragment fragment = new TimePickerFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
