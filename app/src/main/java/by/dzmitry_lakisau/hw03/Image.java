package by.dzmitry_lakisau.hw03;

import com.google.gson.annotations.SerializedName;

public class Image {

    @SerializedName("#text")
    private String mImageURI;

    @SerializedName("size")
    private String mSize;

    public String getImageURI() {
        return mImageURI;
    }

    public void setImageURI(String mImagePath) {
        this.mImageURI = mImagePath;
    }

    public String getSize() {
        return mSize;
    }

    public void setSize(String mSize) {
        this.mSize = mSize;
    }
}
