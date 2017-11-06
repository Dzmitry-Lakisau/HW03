package by.dzmitry_lakisau.hw03.json;

import com.google.gson.annotations.SerializedName;

import by.dzmitry_lakisau.hw03.IScrobbleDate;

public class ScrobbleDate implements IScrobbleDate {

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
}
