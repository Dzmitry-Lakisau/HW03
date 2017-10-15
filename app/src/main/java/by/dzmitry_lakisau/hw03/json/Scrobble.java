package by.dzmitry_lakisau.hw03.json;

import java.util.List;

import by.dzmitry_lakisau.hw03.Album;
import by.dzmitry_lakisau.hw03.Artist;
import by.dzmitry_lakisau.hw03.Date;
import by.dzmitry_lakisau.hw03.IScrobble;
import by.dzmitry_lakisau.hw03.Image;

public class Scrobble implements IScrobble {

    private Artist mArtist;
    private String mTrack;
    private Album mAlbum;
    private List<Image> mImages;
    private Date mDate;

    public void setArtist(Artist mArtist) {
        this.mArtist = mArtist;
    }

    public void setTrack(String mTrack) {
        this.mTrack = mTrack;
    }

    public void setAlbum(Album mAlbum) {
        this.mAlbum = mAlbum;
    }

    public void setImage(List<Image> mImages) {
        this.mImages = mImages;
    }

    public void setDate(Date mDate) {
        this.mDate = mDate;
    }

    @Override
    public Artist getArtist(){
        return mArtist;
    }

    @Override
    public String getTrackTitle() {
        return mTrack;
    }

    @Override
    public Album getAlbum()  {
        return mAlbum;
    }

    @Override
    public List<Image> getImages() {
        return mImages;
    }

    @Override
    public Date getDate(){
        return mDate;
    }
}
