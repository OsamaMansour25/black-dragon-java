package dk.acto.blackdragon.service;

import dk.acto.blackdragon.service.DataFetcher;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class MyDataFetcher implements DataFetcher {
    @Override
    public String fetchData(URL url) throws IOException {
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        StringBuilder result = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream(), StandardCharsets.UTF_8))) {
            String line;
            while ((line = reader.readLine()) != null) {
                result.append(line);
                result.append("\n");
            }
        } finally {
            conn.disconnect();
        }

        return result.toString().trim();
    }
}
