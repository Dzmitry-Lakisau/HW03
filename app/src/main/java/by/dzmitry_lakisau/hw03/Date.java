package by.dzmitry_lakisau.hw03;

import com.google.gson.annotations.SerializedName;

import java.text.SimpleDateFormat;
import java.util.Locale;

public class Date {

    @SerializedName("uts")
    private long mUnixDate;

    @SerializedName("#text")
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
