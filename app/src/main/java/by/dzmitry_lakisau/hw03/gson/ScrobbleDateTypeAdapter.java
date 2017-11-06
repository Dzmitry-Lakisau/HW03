package by.dzmitry_lakisau.hw03.gson;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class ScrobbleDateTypeAdapter extends TypeAdapter {

    @Override
    public void write(JsonWriter out, Object value) throws IOException {

    }

    @Override
    public ScrobbleDate read(final JsonReader in) throws IOException {

        ScrobbleDate result = new ScrobbleDate();

        in.beginObject();
        while (in.hasNext()) {
            switch (in.nextName()) {
                case "uts":
                    long rawDate = in.nextLong();

                    result.setUnixDate(rawDate);

                    Date date = new Date(rawDate * 1000L);
                    SimpleDateFormat sdf = new SimpleDateFormat("d MMM yyyy, HH:mm:ss", Locale.ENGLISH);
                    String formattedDate = sdf.format(date);

                    result.setFormattedDate(formattedDate);
                    break;
                case "#text":
                    in.nextString();
                    break;
            }
        }
        in.endObject();

        return result;
    }
}
