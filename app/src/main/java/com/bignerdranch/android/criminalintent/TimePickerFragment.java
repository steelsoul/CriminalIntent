package com.bignerdranch.android.criminalintent;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import java.util.Calendar;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.View;
import android.widget.TimePicker;

import java.util.Date;

/**
 * Created by alex on 24.10.17.
 * Another dialog fragment, exercise.
 */

public class TimePickerFragment extends DialogFragment {
    public static final String EXTRA_TIME = "com.bignerdranch.android.criminalintent.DatePickerFragment.EXTRA_TIME";
    private long mTime;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        mTime = (long)getArguments().getSerializable(EXTRA_TIME);

        View v = getActivity().getLayoutInflater()
                .inflate(R.layout.dialog_time, null);
        TimePicker timePicker = v.findViewById(R.id.dialog_time_picker);

        Date date = new Date(mTime);
        timePicker.setCurrentHour(date.getHours());
        timePicker.setCurrentMinute(date.getMinutes());

        timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker timePicker, int h, int m) {
                Calendar c = Calendar.getInstance();
                c.set(Calendar.HOUR, h);
                c.set(Calendar.MINUTE, m);
                mTime = c.getTimeInMillis();
            }
        });

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
            i.putExtra(EXTRA_TIME, mTime);

            getTargetFragment()
                    .onActivityResult(getTargetRequestCode(), resultCode, i);
        }
    }

    public static TimePickerFragment newInstance(long time) {
        Bundle args = new Bundle();
        args.putSerializable(EXTRA_TIME, time);
        TimePickerFragment fragment = new TimePickerFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
