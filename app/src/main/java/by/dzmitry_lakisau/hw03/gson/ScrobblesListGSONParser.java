package by.dzmitry_lakisau.hw03.gson;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class ScrobblesListGSONParser {

    public RootObject parse(String mSource){
        Gson gson = new GsonBuilder().registerTypeAdapter(ScrobbleDate.class, new ScrobbleDateTypeAdapter()).create();
        return gson.fromJson(mSource, RootObject.class);
    }
}
