package by.dzmitry_lakisau.hw03;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;

import java.io.IOException;
import java.util.List;

import by.dzmitry_lakisau.hw03.backend.scrobbleApi.ScrobbleApi;
import by.dzmitry_lakisau.hw03.backend.scrobbleApi.model.Scrobble;


class GetLatestScrobbleTask extends AsyncTask<Long, Void, String[]> {

    private Context mContext;
    public static final String NO_DATA = "No scrobbles with this id";
    private static ScrobbleApi myApiService = null;
    Scrobble scrobble;

    GetLatestScrobbleTask(Context context){
        mContext = context;
    }

    @Override
    protected String[] doInBackground(Long... params) {
        if(myApiService == null) {  // Only do this once
            ScrobbleApi.Builder builder = new ScrobbleApi.Builder(AndroidHttp.newCompatibleTransport(), new AndroidJsonFactory(), null)
                    // options for running against local devappserver
                    // - 10.0.2.2 is localhost's IP address in Android emulator
                    // - turn off compression when running against local devappserver
                    .setRootUrl("https://hw04-55555.appspot.com/")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                            abstractGoogleClientRequest.setDisableGZipContent(true);
                        }
                    });
            // end options for devappserver

            myApiService = builder.build();
        }

//        Long id = Long.parseLong("5629499534213120");//params[0];

        try {
            String s = myApiService.getBaseUrl();
//           if (!myApiService.getScrobble(id).isEmpty()){
               scrobble = myApiService.getLatestScrobble().execute();
               String[] result = {scrobble.getTrackTitle(), scrobble.getArtist().getArtistName(), scrobble.getAlbum().getAlbumTitle()};
               return result;
//           }
//            else return new String[] {NO_DATA};
        } catch (IOException e) {
           return new String[] {e.getMessage()};
        }
    }

    @Override
    protected void onPostExecute(String[] result) {
        if (result.length == 1){
            Toast.makeText(mContext, result[0], Toast.LENGTH_LONG).show();
        }
        else {
            Toast.makeText(mContext, String.format("%s1 - %s2 from %s3", result[1], result[0], result[2]), Toast.LENGTH_LONG).show();
        }
    }
}
