package by.dzmitry_lakisau.hw03;

import java.io.InputStream;

public interface IHttpClient {

    InputStream request(String url);
}
