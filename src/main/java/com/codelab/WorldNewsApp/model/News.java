package com.codelab.WorldNewsApp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.json.JSONObject;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class News {

    private String country;
    private String Category;
    private JSONObject responseBody;

}
