package by.dzmitry_lakisau.hw03;

import com.google.gson.annotations.SerializedName;

public class Album {

    @SerializedName("#text")
    private String mAlbumTitle;

    @SerializedName("mbid")
    private String mMbid;

    public String getAlbumTitle() {
        return mAlbumTitle;
    }

    public void setAlbumTitle(String mAlbum) {
        this.mAlbumTitle = mAlbum;
    }

    public String getMbid() {
        return mMbid;
    }

    public void setMbid(String mMbid) {
        this.mMbid = mMbid;
    }
}
