package com.codelab.WorldNewsApp.service;

import com.codelab.WorldNewsApp.model.News;
import com.google.gson.JsonObject;
import org.springframework.stereotype.Service;

@Service
public interface NewsService {
    public JsonObject getNews(News news);

    public JsonObject fetchNews(String apiKey, String apiUrl, News news);
}
