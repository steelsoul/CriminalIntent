package com.bignerdranch.android.criminalintent;

import android.support.v4.app.Fragment;

/**
 * Crime list activity
 * Created by alex on 30.09.17.
 */

public class CrimeListActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new CrimeListFragment();
    }
}
