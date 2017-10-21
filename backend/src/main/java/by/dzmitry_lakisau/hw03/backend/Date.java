package by.dzmitry_lakisau.hw03.backend;

import com.googlecode.objectify.annotation.Index;

import java.text.SimpleDateFormat;
import java.util.Locale;

public class Date {

    @Index
    private long mUnixDate;

    private String mFormattedDate;

    public long getUnixDate() {
        return mUnixDate;
    }

    public void setUnixDate(long mUnixDtate) {
        this.mUnixDate = mUnixDtate;
    }

    public String getFormattedDate() {
        return mFormattedDate;
    }

    public void setFormattedDate(String mFormattedDate) {
        this.mFormattedDate = mFormattedDate;
    }

    public String convertUnixDate(){
        java.util.Date date = new java.util.Date (mUnixDate * 1000L);
        SimpleDateFormat sdf = new SimpleDateFormat("d MMM yyyy, HH:mm:ss", Locale.ENGLISH);
        String formattedDate = sdf.format(date);
        return formattedDate;
    }
}
