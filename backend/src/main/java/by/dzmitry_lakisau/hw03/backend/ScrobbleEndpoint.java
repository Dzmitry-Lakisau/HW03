package by.dzmitry_lakisau.hw03.backend;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.googlecode.objectify.ObjectifyService;

import java.util.List;
import java.util.logging.Logger;

import javax.inject.Named;

import static com.googlecode.objectify.ObjectifyService.ofy;

/**
 * An endpoint class we are exposing
 */
@Api(
        name = "scrobbleApi",
        version = "v1",
        resource = "scrobble",
        namespace = @ApiNamespace(
                ownerDomain = "backend.hw03.dzmitry_lakisau.by",
                ownerName = "backend.hw03.dzmitry_lakisau.by",
                packagePath = ""
        )
)
public class ScrobbleEndpoint {

    private static final Logger logger = Logger.getLogger(ScrobbleEndpoint.class.getName());

    static {
        // Typically you would register this inside an OfyServive wrapper. See: https://code.google.com/p/objectify-appengine/wiki/BestPractices
        ObjectifyService.register(Scrobble.class);
    }

    /**
     * This method gets the <code>Scrobble</code> object associated with the specified <code>id</code>.
     *
     * @return The <code>Scrobble</code> associated with <code>id</code>.
     */
    @ApiMethod(name = "getLatestScrobble", path = "scrobble")
    public Scrobble getLatestScrobble() {
        logger.info("Calling getScrobble method");

        List<Scrobble> s =  ofy().load().type(Scrobble.class).order("-mDate.mUnixDate").list();
        Scrobble result = s.get(0);
        return result;
    }

    /**
     * This inserts a new <code>Scrobble</code> object.
     *
     * @param timestamp, trackTitle, artistName, albumTitle The object to be added.
     * @return The object to be added.
     */
    @ApiMethod(name = "insertScrobble",
                path = "scrobble",
                httpMethod = ApiMethod.HttpMethod.POST)
    public void insertScrobble(@Named("timestamp") Long timestamp, @Named("trackTitle") String trackTitle, @Named("artistName") String artistName, @Named("albumTitle") String albumTitle) {
        // Typically in a RESTful API a POST does not have a known ID (assuming the ID is used in the resource path).
        // You should validate that user.id has not been set. If the ID type is not supported by the
        // Objectify ID generator, e.g. long or String, then you should generate the unique ID yourself prior to saving.
        //
        // If your client provides the ID then you should probably use PUT instead.
        Scrobble scrobble = new Scrobble();

        scrobble.setTrackTitle(trackTitle);

        Album album = new Album();
        album.setAlbumTitle(albumTitle);
        scrobble.setAlbum(album);

        Artist artist = new Artist();
        artist.setArtistName(artistName);
        scrobble.setArtist(artist);

        Date date = new Date();
        date.setUnixDate(timestamp / 1000);
        scrobble.setDate(date);

        ofy().save().entity(scrobble).now();
        logger.info("Calling insertScrobble method");
    }
}