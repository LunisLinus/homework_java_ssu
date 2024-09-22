package org.labs.Tasks.Task2;

import java.net.URL;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class UrlParser {
    public static void main(String[] args) {
        String filePath = "src/main/resources/urls.txt";

        try {
            List<String> urls = Files.readAllLines(Paths.get(filePath));
            for (String urlString : urls) {
                if (urlString.trim().isEmpty()) {
                    continue;
                }
                System.out.println("Парсинг URL: " + urlString);
                try {
                    URL url = new URL(urlString);
                    SimpleUrl simpleUrl = new SimpleUrl();

                    simpleUrl.setProtocol(url.getProtocol());

                    String host = url.getHost();
                    simpleUrl.setAddress(host);

                    int port = (url.getPort() == -1) ? (url.getProtocol().equals("https") ? 443 : 80) : url.getPort();
                    simpleUrl.setPort(port);

                    String[] hostParts = host.split("\\.");
                    if (hostParts.length >= 2) {
                        simpleUrl.setSiteName(hostParts[hostParts.length - 2]);
                        simpleUrl.setDomainZone(hostParts[hostParts.length - 1]);
                    } else {
                        simpleUrl.setSiteName(host);
                    }

                    String path = url.getPath();
                    if (path == null || path.isEmpty()) {
                        path = "/";
                    }
                    simpleUrl.setWebpagePath(path);

                    String[] pathSegments = path.split("/");
                    if (pathSegments.length > 0) {
                        String webpageFullName = pathSegments[pathSegments.length - 1];
                        simpleUrl.setWebpageName(webpageFullName);

                        String[] nameParts = webpageFullName.split("\\.");
                        if (nameParts.length > 1) {
                            simpleUrl.setWebpageExtension(nameParts[nameParts.length - 1]);
                        }
                    }

                    String query = url.getQuery();
                    if (query != null && !query.isEmpty()) {
                        Map<String, String> queryPairs = new HashMap<>();
                        String[] pairs = query.split("&");
                        for (String pair : pairs) {
                            String[] keyValue = pair.split("=");
                            if (keyValue.length == 2) {
                                queryPairs.put(keyValue[0], keyValue[1]);
                            } else if (keyValue.length == 1) {
                                queryPairs.put(keyValue[0], "");
                            }
                        }
                        simpleUrl.setQueryParameters(queryPairs);
                    }

                    String fragment = url.getRef();
                    if (fragment != null && !fragment.isEmpty()) {
                        simpleUrl.setFragment(fragment);
                    }

                    System.out.println(simpleUrl);
                    System.out.println("-----------------------------------");

                } catch (MalformedURLException e) {
                    System.err.println("Некорректный URL: " + urlString + " - " + e.getMessage());
                    System.out.println("-----------------------------------");
                }
            }
        } catch (IOException e) {
            System.err.println("Ошибка при чтении файла: " + e.getMessage());
        }
    }
}
