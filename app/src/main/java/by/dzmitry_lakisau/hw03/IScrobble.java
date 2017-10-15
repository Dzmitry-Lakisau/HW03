package by.dzmitry_lakisau.hw03;

import java.util.List;

public interface IScrobble {

    Artist getArtist();

    String getTrackTitle();

    Album getAlbum();

    List<Image> getImages();

    Date getDate();
}
