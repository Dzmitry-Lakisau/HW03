package by.dzmitry_lakisau.hw03.gson;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import by.dzmitry_lakisau.hw03.Album;
import by.dzmitry_lakisau.hw03.Artist;
import by.dzmitry_lakisau.hw03.Date;
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
    List<Image> mImages;

    @SerializedName("date")
    private Date mDate;

    @Override
    public Artist getArtist() {
        return mArtist;
    }

    public void setArtist(Artist mArtist) {
        this.mArtist = mArtist;
    }

    @Override
    public Date getDate() {
        return mDate;
    }

    public void setDate(Date mDate) {
        this.mDate = mDate;
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
