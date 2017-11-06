package by.dzmitry_lakisau.hw03.gson;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import by.dzmitry_lakisau.hw03.Album;
import by.dzmitry_lakisau.hw03.Artist;
import by.dzmitry_lakisau.hw03.IScrobble;
import by.dzmitry_lakisau.hw03.Image;

public class ScrobbleGSON implements IScrobble{

    @SerializedName("artist")
    private Artist mArtist;

    @SerializedName("name")
    private String mTrack;

    @SerializedName("album")
    private Album mAlbum;

    @SerializedName("image")
    private List<Image> mImages;

    @SerializedName("date")
    private ScrobbleDate mScrobbleDate;

    @Override
    public Artist getArtist() {
        return mArtist;
    }

    public void setArtist(Artist mArtist) {
        this.mArtist = mArtist;
    }

    @Override
    public ScrobbleDate getScrobbleDate() {
        return mScrobbleDate;
    }

    public void setScrobbleDate(ScrobbleDate mScrobbleDate) {
        this.mScrobbleDate = mScrobbleDate;
    }

    @Override
    public Album getAlbum() {
        return mAlbum;
    }

    public void setAlbum(Album mAlbum) {
        this.mAlbum = mAlbum;
    }

    @Override
    public List<Image> getImages() {
        return mImages;
    }

    public void setImages(List<Image> mImages) {
        this.mImages = mImages;
    }

    @Override
    public String getTrackTitle(){
        return this.mTrack;
    }

    public void setTrack(String track){
        this.mTrack = track;
    }
}
