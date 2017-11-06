package by.dzmitry_lakisau.hw03.json;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import by.dzmitry_lakisau.hw03.Album;
import by.dzmitry_lakisau.hw03.Artist;
import by.dzmitry_lakisau.hw03.Image;

public class ScrobblesListParser {

    List<Scrobble> scrobbles;

    public List<Scrobble> parse(String json){
        try {
            scrobbles = new ArrayList<Scrobble>();

            JSONObject obj = new JSONObject(json);
            JSONObject recenttracks = obj.getJSONObject("recenttracks");
            JSONArray tracksArray = recenttracks.getJSONArray("track");
            for (int i=0; i<tracksArray.length(); i++){
                Scrobble scrobble = new Scrobble();
                JSONObject jsonObject = tracksArray.optJSONObject(i).optJSONObject("artist");
                Artist artist = new Artist();
                artist.setArtistName(jsonObject.optString("#text"));
                artist.setMbid(jsonObject.optString("mbid"));
                scrobble.setArtist(artist);
                String track = tracksArray.optJSONObject(i).getString("name");
                scrobble.setTrack(track);
                jsonObject = tracksArray.optJSONObject(i).optJSONObject("album");//.optString("#text");
                Album album = new Album();
                album.setAlbumTitle(jsonObject.optString("#text"));
                album.setMbid(jsonObject.optString("mbid"));
                scrobble.setAlbum(album);
                JSONArray jsonArray = tracksArray.optJSONObject(i).optJSONArray("image");//.optJSONObject(3).optString("#text");
                List<Image> images = new ArrayList<Image>();
                for (int j = 0; j < jsonArray.length(); j++) {
                    jsonObject = jsonArray.getJSONObject(j);
                    Image image = new Image();
                    image.setImageURI(jsonObject.optString("#text"));
                    image.setSize(jsonObject.optString("size"));
                    images.add(image);
                }
                scrobble.setImage(images);
                jsonObject = tracksArray.optJSONObject(i).optJSONObject("date");//.optLong("uts");
                ScrobbleDate scrobbleDate = new ScrobbleDate();
                scrobbleDate.setFormattedDate(jsonObject.optString("#text"));
                scrobbleDate.setUnixDate(jsonObject.optLong("uts"));
                scrobble.setDate(scrobbleDate);
                scrobbles.add(scrobble);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return scrobbles;
    }
}
