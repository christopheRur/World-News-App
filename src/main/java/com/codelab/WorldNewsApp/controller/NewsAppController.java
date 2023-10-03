package com.codelab.WorldNewsApp.controller;

import com.codelab.WorldNewsApp.model.News;
import com.codelab.WorldNewsApp.service.NewsServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class NewsAppController {

    private NewsServiceImpl newsServ = new NewsServiceImpl();

    @PostMapping("/news")
    public ResponseEntity<?> getWorldNews(@RequestBody News newsRequest) {
        try {
            if (newsRequest == null) {

                return ResponseEntity.badRequest().body("No data Found!");

            } else {


                return new ResponseEntity<>(newsServ.getNews(newsRequest) , HttpStatus.OK);
            }

        } catch (Exception e) {

            log.error("==>" + e.getLocalizedMessage());

            return ResponseEntity.badRequest().body("Error occurred, unable to FETCH data.");
        }
    }

}
