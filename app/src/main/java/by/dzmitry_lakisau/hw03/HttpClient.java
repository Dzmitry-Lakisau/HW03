package by.dzmitry_lakisau.hw03;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class HttpClient implements IHttpClient {

//    URL url;
//    HttpsURLConnection httpsURLConnection;
//
//    @Override
//    public InputStream request(String s) {
//
//        InputStream inputStream = null;
//
//        try {
//            url = new URL(s);
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        }
//        try {
//            httpsURLConnection = (HttpsURLConnection)url.openConnection();
//            httpsURLConnection.connect();
//            if (httpsURLConnection.getResponseCode() > 399) {
//                inputStream = httpsURLConnection.getErrorStream();
//            } else if (httpsURLConnection.getResponseCode() == 200) {
//               inputStream = httpsURLConnection.getInputStream();
//            }
//            else return null;
//            httpsURLConnection.disconnect();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        return inputStream;


    @Override
    public InputStream request(String url) {
        throw new IllegalStateException("implement httpClient");
    }
}
