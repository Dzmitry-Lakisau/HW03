package by.dzmitry_lakisau.hw03;

import android.annotation.TargetApi;

import by.dzmitry_lakisau.hw03.gson.ScrobbleGSON;
import by.dzmitry_lakisau.hw03.gson.ScrobblesListGSONParser;
import by.dzmitry_lakisau.hw03.json.Scrobble;
import by.dzmitry_lakisau.hw03.json.ScrobblesListParser;
import by.dzmitry_lakisau.hw03.mocks.Mocks;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(RobolectricTestRunner.class)
@Config(
        constants = BuildConfig.class,
        sdk = 21
)
@TargetApi(19)
public class ParserTest {

    private static final String EXPECTED_ARTIST_NAME = "Rainbow";
    private static final String EXPECTED_TRACK_TITLE = "Poison Heart";
    private static final String EXPECTED_ALBUM_TITLE = "Inner City Life (2017 Rebuild / Burial Remix)";
    private static final String EXPECTED_IMAGE_URI = "https://lastfm-img2.akamaized.net/i/u/300x300/5f951cfae3ab41f1c1cae58964707a15.png";
    private static final String EXPECTED_CONVERTED_DATE = "12 Oct 2017, 21:20:17";

    private IHttpClient mHttpClient;

    @Before
    public void mockHttpClient() {
        mHttpClient = mock(IHttpClient.class);
    }

    @Test
    public void parseUsingJSON() throws Exception {
        InputStream mockedInputStream = Mocks.stream("scrobbles with root.json");
        when(mHttpClient.request(Matchers.anyString())).thenReturn(mockedInputStream);
        InputStream response = mHttpClient.request("http://myBackend");

        final int bufferSize = 1024;
        final char[] buffer = new char[bufferSize];
        final StringBuilder out = new StringBuilder();
        try(Reader in = new InputStreamReader(response, "UTF-8")) {
            for (; ; ) {
                int rsz = in.read(buffer, 0, buffer.length);
                if (rsz < 0)
                    break;
                out.append(buffer, 0, rsz);
            }
        }

        final ScrobblesListParser scrobblesListParser = new ScrobblesListParser();
        List<Scrobble> scrobbleList = scrobblesListParser.parse(out.toString());
        assertEquals(scrobbleList.size(), 10);
        for (Scrobble scrobble : scrobbleList){
            assertEquals(scrobble.getImages().size(), 4);
        }
        assertEquals(scrobbleList.get(9).getArtist().getArtistName(), EXPECTED_ARTIST_NAME);
        assertEquals(scrobbleList.get(6).getTrackTitle(), EXPECTED_TRACK_TITLE);
        assertEquals(scrobbleList.get(3).getAlbum().getAlbumTitle(), EXPECTED_ALBUM_TITLE);
        assertEquals(scrobbleList.get(4).getAlbum().getAlbumTitle(), EXPECTED_ALBUM_TITLE);
        assertEquals(scrobbleList.get(8).getImages().get(3).getImageURI(), EXPECTED_IMAGE_URI);
    }

    @Test
    public void parseUsingGSON() throws Exception {
        InputStream mockedInputStream = Mocks.stream("scrobbles with root.json");
        when(mHttpClient.request(Matchers.anyString())).thenReturn(mockedInputStream);
        InputStream response = mHttpClient.request("http://myBackend");

        final int bufferSize = 1024;
        final char[] buffer = new char[bufferSize];
        final StringBuilder out = new StringBuilder();
        try(Reader in = new InputStreamReader(response, "UTF-8")) {
            for (; ; ) {
                int rsz = in.read(buffer, 0, buffer.length);
                if (rsz < 0)
                    break;
                out.append(buffer, 0, rsz);
            }
        }

        final ScrobblesListGSONParser scrobblesListGSONParser = new ScrobblesListGSONParser();
        List<ScrobbleGSON> scrobbleGSONList = scrobblesListGSONParser.parse(out.toString()).getRecentTracks().getScrobblesListGSON();
        assertEquals(scrobbleGSONList.size(), 10);
        for (ScrobbleGSON scrobble : scrobbleGSONList){
            assertEquals(scrobble.getImages().size(), 4);
        }
        assertEquals(scrobbleGSONList.get(9).getArtist().getArtistName(), EXPECTED_ARTIST_NAME);
        assertEquals(scrobbleGSONList.get(6).getTrackTitle(), EXPECTED_TRACK_TITLE);
        assertEquals(scrobbleGSONList.get(3).getAlbum().getAlbumTitle(), EXPECTED_ALBUM_TITLE);
        assertEquals(scrobbleGSONList.get(4).getAlbum().getAlbumTitle(), EXPECTED_ALBUM_TITLE);
        assertEquals(scrobbleGSONList.get(8).getImages().get(3).getImageURI(), EXPECTED_IMAGE_URI);
    }

    @Test
    public void convertUnixDate() throws Exception{
        InputStream mockedInputStream = Mocks.stream("scrobbles with root.json");
        when(mHttpClient.request(Matchers.anyString())).thenReturn(mockedInputStream);
        InputStream response = mHttpClient.request("http://myBackend");

        final int bufferSize = 1024;
        final char[] buffer = new char[bufferSize];
        final StringBuilder out = new StringBuilder();
        try(Reader in = new InputStreamReader(response, "UTF-8")) {
            for (; ; ) {
                int rsz = in.read(buffer, 0, buffer.length);
                if (rsz < 0)
                    break;
                out.append(buffer, 0, rsz);
            }
        }

        final ScrobblesListGSONParser scrobblesListGSONParser = new ScrobblesListGSONParser();
        List<ScrobbleGSON> scrobbleGSONList = scrobblesListGSONParser.parse(out.toString()).getRecentTracks().getScrobblesListGSON();
        assertEquals(scrobbleGSONList.size(), 10);
        assertEquals(scrobbleGSONList.get(9).getScrobbleDate().getFormattedDate(), EXPECTED_CONVERTED_DATE);
    }
}