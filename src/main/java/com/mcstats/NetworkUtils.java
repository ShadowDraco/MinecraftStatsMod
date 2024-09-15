package com.mcstats;

import com.google.gson.JsonObject;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.IOException;

public class NetworkUtils {

    public static void postNewStat(String url, JsonObject json) throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        try {
            HttpPost request = new HttpPost(url);
            StringEntity params = new StringEntity(json.toString());
            request.addHeader("content-type", "application/json");
            request.setEntity(params);
            httpClient.execute(request);
            httpClient.close();
        } catch(Exception e) {
            System.out.println("Error sending request" + e.getMessage());
        }
    }
}
