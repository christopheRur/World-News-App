package com.codelab.WorldNewsApp.service;

import com.codelab.WorldNewsApp.model.News;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Slf4j
@Service
public class NewsServiceImpl implements NewsService {

    @Override
    public JSONObject getNews(News news) throws IOException {

        String apiKey = "f20248dbdbb54fd791f0c8d8b531f894";
        String apiUrl = "https://newsapi.org/v2/top-headlines?country=" + news.getCountry(); // You can customize the API URL as needed
        JSONObject newResponse = fetchNews(apiKey, apiUrl, news);

        return newResponse;
    }

    @Override
    public JSONObject fetchNews(String apiKey, String apiUrl, News news) throws IOException {

        HttpClient httpClient = HttpClients.createDefault();

        HttpGet httpGet = new HttpGet(apiUrl);
        httpGet.addHeader("X-Api-Key", apiKey);
        HttpResponse response=null;
        JSONObject json=null;

        try {
            int oK = 200;

             response = httpClient.execute(httpGet);
            int statusCode = response.getStatusLine().getStatusCode();

            if (statusCode == oK) {
                json=new JSONObject(EntityUtils.toString(response.getEntity()));

                news.setResponseBody(json);



                news.getResponseBody().get("articles");

                //JSONObject jsonObj =new JSONObject(news.getResponseBody().get("articles"));


                log.info("Successfully {} , {}",statusCode, news.getResponseBody().get("articles"));


                return news.getResponseBody();
            }

        } catch (Exception e) {

            return json;

        }


        return json;
    }
}
