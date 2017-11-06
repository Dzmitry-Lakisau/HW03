package by.dzmitry_lakisau.hw03;

import java.util.List;

//import by.dzmitry_lakisau.hw03.json.ScrobbleDate;

public interface IScrobble {

    Artist getArtist();

    String getTrackTitle();

    Album getAlbum();

    List<Image> getImages();

    IScrobbleDate getScrobbleDate();
}
