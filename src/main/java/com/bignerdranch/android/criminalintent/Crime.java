package com.bignerdranch.android.criminalintent;

import java.util.UUID;

/**
 * Crime model
 * Created by alex on 28.09.17.
 */

public class Crime {

    private UUID mId;
    private String mTitle;

    public Crime() {
        mId = UUID.randomUUID();
    }

    public UUID getId() {
        return mId;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }
}
