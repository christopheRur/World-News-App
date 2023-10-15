package com.codelab.WorldNewsApp;

import com.codelab.WorldNewsApp.controller.NewsAppController;
import com.codelab.WorldNewsApp.model.News;
import com.codelab.WorldNewsApp.service.NewsServiceImpl;
import com.google.gson.JsonArray;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
class WorldNewsAppApplicationTests {
	@Mock
	private News news;
	@Mock
	private NewsServiceImpl service;

	@InjectMocks
	private NewsAppController controller;

	@Test
	public void testGetWorldNews() throws IOException {
		news = new News();
		news.setCountry("us");
		Mockito.when(service.getNews(news)).thenReturn(new JsonArray());
		ResponseEntity<?> response = controller.getWorldNews(news);
		assertEquals(HttpStatus.OK, response.getStatusCode());

	}
	@Test
	void contextLoads() {
	}
	@Test
	public void testFetchNews() throws IOException {
		news = new News();
		news.setCountry("us");
		Mockito.when(service.fetchNews("api-key","apiURL",news)).thenReturn(new JsonArray());}


}
