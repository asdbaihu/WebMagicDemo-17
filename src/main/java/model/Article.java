package model;

import com.google.gson.annotations.SerializedName;
import model.base.Jsonable;

public class Article extends Jsonable {
    @SerializedName("title")
    public String title;

    @SerializedName("content")
    public String content;
}
