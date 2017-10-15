package by.dzmitry_lakisau.hw03.gson;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RecentTracks {

    @SerializedName("track")
    private List<ScrobbleGSON> mScrobblesListGSON;

    @SerializedName("@attr")
    private Attributes attributes;

    public List<ScrobbleGSON> getScrobblesListGSON() {
        return mScrobblesListGSON;
    }

    public void setScrobbleListGSON(List<ScrobbleGSON> mScrobblesListGSON) {
        this.mScrobblesListGSON = mScrobblesListGSON;
    }

    private class Attributes {

        @SerializedName("user")
        private String user;

        @SerializedName("page")
        private long currentPage;

        @SerializedName("perPage")
        private long perPage;

        @SerializedName("totalPages")
        private long totalPages;

        @SerializedName("total")
        private long totalScrobbles;
    }
}

