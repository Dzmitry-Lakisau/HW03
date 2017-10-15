package by.dzmitry_lakisau.hw03.gson;

import com.google.gson.annotations.SerializedName;

public class RootObject {

    @SerializedName("recenttracks")
    private RecentTracks recentTracks;

    public RecentTracks getRecentTracks() {
        return recentTracks;
    }

    public void setRecentTracks(RecentTracks recentTracks) {
        this.recentTracks = recentTracks;
    }

}
