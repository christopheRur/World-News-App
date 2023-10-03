package com.codelab.WorldNewsApp.service;

import com.codelab.WorldNewsApp.model.News;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Slf4j
@Service
public class NewsServiceImpl implements NewsService {

    @Override
    public JsonArray getNews(News news) throws IOException {

        String apiKey = "f20248dbdbb54fd791f0c8d8b531f894";
        String apiUrl = "https://newsapi.org/v2/top-headlines?country=" + news.getCountry(); // You can customize the API URL as needed
        JsonArray newResponse = fetchNews(apiKey, apiUrl, news);

        return newResponse;
    }

    @Override
    public JsonArray fetchNews(String apiKey, String apiUrl, News news) throws IOException {

        HttpClient httpClient = HttpClients.createDefault();

        HttpGet httpGet = new HttpGet(apiUrl);
        httpGet.addHeader("X-Api-Key", apiKey);
        HttpResponse response;
        JsonObject json;
        JsonArray arrayResponse;

        try {
            int oK = 200;

            response = httpClient.execute(httpGet);
            int statusCode = response.getStatusLine().getStatusCode();

            if (statusCode == oK) {
                json = (JsonObject) JsonParser.parseString(EntityUtils.toString(response.getEntity()));

                news.setFullResponseBody(json);

                JsonArray jsonArray = news.getFullResponseBody().get("articles").getAsJsonArray();

                //JsonObject jsonObject= jsonArray.get(1).getAsJsonObject();

                news.setResponse(jsonArray);

                arrayResponse = news.getResponse();

                log.info("Successfully {} , {}", statusCode, jsonArray);


                return arrayResponse;
            }

        } catch (Exception e) {
            log.error("==============>{}",
                    e.getLocalizedMessage());
            return null;

        }

        return null;
    }
}
