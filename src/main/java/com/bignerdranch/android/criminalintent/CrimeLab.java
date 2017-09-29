package com.bignerdranch.android.criminalintent;

import android.annotation.SuppressLint;
import android.content.Context;

import java.util.ArrayList;
import java.util.UUID;

/**
 * Storage of crimes
 * Created by alex on 30.09.17.
 */

class CrimeLab {
    @SuppressLint("StaticFieldLeak")
    private static CrimeLab sCrimeLab;
    private Context mAppContext;
    private ArrayList<Crime> mCrimes;

    private CrimeLab(Context appContext) {
        mAppContext = appContext;
        mCrimes = new ArrayList<>();
        for (int i = 0; i < 100; ++i) {
            Crime c = new Crime();
            c.setTitle("Crime #" + i);
            c.setSolved(i % 2 == 0);
            mCrimes.add(c);
        }
    }

    static CrimeLab get(Context c) {
        if (sCrimeLab == null) {
            sCrimeLab = new CrimeLab(c.getApplicationContext());
        }
        return sCrimeLab;
    }

    ArrayList<Crime> getCrimes() {
        return mCrimes;
    }

    public Crime getCrime(UUID id) {
        for (Crime c: mCrimes) {
            if (c.getId().equals(id))
                return c;
        }
        return null;
    }
}
