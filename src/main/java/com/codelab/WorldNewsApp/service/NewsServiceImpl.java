package com.codelab.WorldNewsApp.service;

import com.codelab.WorldNewsApp.model.News;
import com.google.gson.JsonObject;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.springframework.stereotype.Service;


@Service
public class NewsServiceImpl implements NewsService {

    @Override
    public JsonObject getNews(News news) {

        String apiKey = "f20248dbdbb54fd791f0c8d8b531f894";
        String apiUrl = "https://newsapi.org/v2/top-headlines?country=" + news.getCountry(); // You can customize the API URL as needed
        JsonObject newResponse = fetchNews(apiKey, apiUrl, news);

        return newResponse;
    }

    @Override
    public JsonObject fetchNews(String apiKey, String apiUrl, News newsCountry) {

        HttpClient httpClient = HttpClients.createDefault();

        HttpGet httpGet = new HttpGet(apiUrl);
        httpGet.addHeader("X-Api-Key", apiKey);

        try {

        }catch (Exception e){


        }

        return null;
    }
}
