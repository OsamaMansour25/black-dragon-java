package dk.acto.blackdragon.service;

import java.io.IOException;
import java.net.URL;

public interface DataFetcher {
    String fetchData(URL url) throws IOException;
}
