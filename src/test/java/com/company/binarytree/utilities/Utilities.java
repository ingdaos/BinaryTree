package com.company.binarytree.utilities;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Map;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author PERSONAL
 */
public class Utilities {

    public static HttpEntity<String> getHttpEntity() {
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_UTF8_VALUE);
        HttpEntity<String> entity = new HttpEntity<>(headers);
        return entity;
    }

    public static HttpEntity<String> getHttpEntity(String json) {
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_UTF8_VALUE);
        HttpEntity<String> entity = new HttpEntity<>(json, headers);
        return entity;
    }

    public static Response sendGetRequest(TestRestTemplate restTemplate, String url) {
        ResponseEntity<Response> exchange = restTemplate.exchange(url, HttpMethod.GET, getHttpEntity(), Response.class);
        System.out.println(exchange.getBody());
        return exchange.getBody();
    }

    public static Response sendPostRequest(TestRestTemplate restTemplate, String url, Map<String, Object> request) {
        String stringRequest = toJson(request);
        System.out.println(request);
        ResponseEntity<Response> exchange = restTemplate.exchange(url, HttpMethod.POST, getHttpEntity(stringRequest), Response.class);
        System.out.println(exchange.getBody());
        return exchange.getBody();
    }

    private static String toJson(Map<String, Object> map) {
        String json = "{}";
        try {
            ObjectMapper mapper = new ObjectMapper();
            json = mapper.writeValueAsString(map);
        } catch (JsonProcessingException ex) {
            System.err.println(ex.getMessage());
        }
        return json;
    }

}
