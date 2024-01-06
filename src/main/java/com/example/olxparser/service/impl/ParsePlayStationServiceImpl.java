package com.example.olxparser.service.impl;

import com.example.olxparser.entity.PlayStation;
import com.example.olxparser.service.ParsePlayStationService;
import org.jsoup.Jsoup;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class ParsePlayStationServiceImpl implements ParsePlayStationService {
//    public void printParsedThing(String url) throws IOException {
//
//        var document = Jsoup
//                .connect(url)
//                .get();
//        System.out.println(document.title());
//        var temp = document.select("a");
//        for (var e: temp){
//            System.out.println(e.text()+" | " + e.attr("href"));
//        }
//    }
public void parsePlayStation(String url) throws IOException {
    var document = Jsoup
            .connect(url)
            .get();
    System.out.println(document.title());

    var cards = document.select("div[data-cy=l-card]");
    for (var card : cards) {
        String title = card.select("h6").text();
        String price = card.select("p[data-testid=ad-price]").text();
        String locationDate = card.select("p[data-testid=location-date]").text();
        String link = card.select("a.css-rc5s2u").attr("href");

        System.out.println("Title: " + title);
        System.out.println("Price: " + price);
        System.out.println("Location and date: " + locationDate);
        System.out.println("Link: "+ "https://olx.pl" + link);
        System.out.println("----------");
    }
}

}
