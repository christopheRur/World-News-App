package com.codelab.WorldNewsApp.model;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class News {

    private String country;
    private String Category;
    private JsonObject fullResponseBody;
    private JsonArray response;

}
