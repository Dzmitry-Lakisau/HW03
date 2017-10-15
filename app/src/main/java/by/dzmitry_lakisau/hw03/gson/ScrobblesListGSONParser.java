package by.dzmitry_lakisau.hw03.gson;


import com.google.gson.Gson;

public class ScrobblesListGSONParser {

    public RootObject parse(String mSource){
        return new Gson().fromJson(mSource, RootObject.class);
    }
}
