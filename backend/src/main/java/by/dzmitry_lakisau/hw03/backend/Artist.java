package by.dzmitry_lakisau.hw03.backend;

import com.google.gson.annotations.SerializedName;

public class Artist {

    @SerializedName("#text")
    private String mArtist;

    @SerializedName("mbid")
    private String mMbid;

    public String getArtistName() {
        return mArtist;
    }

    public void setArtistName(String mArtist) {
        this.mArtist = mArtist;
    }

    public String getMbid() {
        return mMbid;
    }

    public void setMbid(String mMbid) {
        this.mMbid = mMbid;
    }

}
