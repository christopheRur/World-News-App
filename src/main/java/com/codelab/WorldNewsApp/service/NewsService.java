package com.codelab.WorldNewsApp.service;

import com.codelab.WorldNewsApp.model.News;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public interface NewsService {
    public JsonArray getNews(News news) throws IOException;

    public JsonArray fetchNews(String apiKey, String apiUrl, News news) throws IOException;
}
