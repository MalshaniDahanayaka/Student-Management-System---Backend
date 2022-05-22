package com.kelaniya.backend.utils.email.mailgun;

import com.kelaniya.backend.entity.request.AnnouncementRequest;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.util.List;

public class MGSample {


    private static final String YOUR_DOMAIN_NAME = "sandboxd0200e0007e04c3e99d2200a600863ab.mailgun.org";



    public static JsonNode sendSimpleMessage(List list,AnnouncementRequest announcementRequest, String userEmail) throws UnirestException {

        HttpResponse<JsonNode> request = Unirest.post("https://api.mailgun.net/v3/" + YOUR_DOMAIN_NAME + "/messages")
			    .basicAuth("api", APIK.API_KEY)
                .queryString("from", userEmail)
                .queryString("to", "skasunmk982@gmail.com")
                .queryString("to", "mekaladahanayaka80@gmail.com")
                .queryString("subject", announcementRequest.getTitle())
                .queryString("text",announcementRequest.getBody() )
                .asJson();
        return request.getBody();
    }


}
