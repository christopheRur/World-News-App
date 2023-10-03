package com.codelab.WorldNewsApp.service;

import com.codelab.WorldNewsApp.model.News;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public interface NewsService {
    public JSONObject getNews(News news) throws IOException;

    public JSONObject fetchNews(String apiKey, String apiUrl, News news) throws IOException;
}
