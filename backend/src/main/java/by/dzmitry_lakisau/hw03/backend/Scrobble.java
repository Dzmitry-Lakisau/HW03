package by.dzmitry_lakisau.hw03.backend;

import java.util.List;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

//import by.dzmitry_lakisau.hw03.backend.Album;


/**
 * The object model for the data we are sending through endpoints
 */
@Entity
public class Scrobble{

    @Id
    private Long id;
    private Artist mArtist;
    private String mTrack;
    private Album mAlbum;
    private List<Image> mImages;
    private Date mDate;

    public void setArtist(Artist mArtist) {
        this.mArtist = mArtist;
    }

    public void setTrackTitle(String mTrack) {
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


    public Artist getArtist(){
        return mArtist;
    }


    public String getTrackTitle() {
        return mTrack;
    }


    public Album getAlbum()  {
        return mAlbum;
    }


    public List<Image> getImages() {
        return mImages;
    }


    public Date getDate(){
        return mDate;
    }
}