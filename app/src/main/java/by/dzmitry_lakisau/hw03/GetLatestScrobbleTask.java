package by.dzmitry_lakisau.hw03;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.EditText;
import android.widget.Toast;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;

import java.io.IOException;

import by.dzmitry_lakisau.hw03.backend.scrobbleApi.ScrobbleApi;
import by.dzmitry_lakisau.hw03.backend.scrobbleApi.model.Scrobble;


class GetLatestScrobbleTask extends AsyncTask<Long, Void, String[]> {

    private Context mContext;
    private static ScrobbleApi myApiService = null;
    private Scrobble scrobble;

    GetLatestScrobbleTask(Context context){
        mContext = context;
    }

    @Override
    protected String[] doInBackground(Long... params) {
        if(myApiService == null) {  // Only do this once
            ScrobbleApi.Builder builder = new ScrobbleApi.Builder(AndroidHttp.newCompatibleTransport(), new AndroidJsonFactory(), null)
                    .setRootUrl("https://hw04-55555.appspot.com/_ah/api")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                            abstractGoogleClientRequest.setDisableGZipContent(true);
                        }
                    });

            myApiService = builder.build();
        }

        try {
            scrobble = myApiService.getLatestScrobble().execute();
            String[] result = {scrobble.getTrackTitle(), scrobble.getArtist().getArtistName(), scrobble.getAlbum().getAlbumTitle(), String.valueOf(scrobble.getDate().getUnixDate())};
            Date date = new Date();
            date.setUnixDate(Long.parseLong(result[3]));
            result[3] = date.convertUnixDate();
            return result;

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
            Activity activity = (Activity) mContext;
            EditText editText = activity.findViewById(R.id.trackEditText);
            editText.setText(result[0]);
            editText = activity.findViewById(R.id.artistEditText);
            editText.setText(result[1]);
            editText = activity.findViewById(R.id.albumEditText);
            editText.setText(result[2]);
            editText = activity.findViewById(R.id.timestampEditText);
            editText.setText(result[3]);
        }
    }
}
