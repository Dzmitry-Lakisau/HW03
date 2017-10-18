package by.dzmitry_lakisau.hw03;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private GetLatestScrobbleTask get;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button scrobbleButton = (Button) findViewById(R.id.button_scrobble);
        scrobbleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                get = new GetLatestScrobbleTask(MainActivity.this);
                get.execute();
            }
        });
    }
}
