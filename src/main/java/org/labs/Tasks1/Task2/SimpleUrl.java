package org.labs.Tasks1.Task2;

import java.util.HashMap;
import java.util.Map;

public class SimpleUrl {
    private String address;
    private String protocol;
    private int port = -1;
    private String domainZone;
    private String siteName;
    private String webpagePath;
    private String webpageName;
    private String webpageExtension;
    private String fragment;

    private Map<String, String> queryParameters = new HashMap<>();

    public SimpleUrl() {
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getDomainZone() {
        return domainZone;
    }

    public void setDomainZone(String domainZone) {
        this.domainZone = domainZone;
    }

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public String getWebpagePath() {
        return webpagePath;
    }

    public void setWebpagePath(String webpagePath) {
        this.webpagePath = webpagePath;
    }

    public String getWebpageName() {
        return webpageName;
    }

    public void setWebpageName(String webpageName) {
        this.webpageName = webpageName;
    }

    public String getWebpageExtension() {
        return webpageExtension;
    }

    public void setWebpageExtension(String webpageExtension) {
        this.webpageExtension = webpageExtension;
    }

    public String getFragment() {
        return fragment;
    }

    public void setFragment(String fragment) {
        this.fragment = fragment;
    }

    public Map<String, String> getQueryParameters() {
        return queryParameters;
    }

    public void setQueryParameters(Map<String, String> queryParameters) {
        this.queryParameters = queryParameters;
    }

    public void addQueryParameter(String key, String value) {
        this.queryParameters.put(key, value);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("SimpleUrl {\n");
        sb.append("  protocol='").append(protocol).append("',\n");
        sb.append("  address='").append(address).append("',\n");
        if (port != -1) {
            sb.append("  port=").append(port).append(",\n");
        }
        sb.append("  domainZone='").append(domainZone).append("',\n");
        sb.append("  siteName='").append(siteName).append("',\n");
        sb.append("  webpagePath='").append(webpagePath).append("',\n");
        sb.append("  webpageName='").append(webpageName).append("',\n");
        sb.append("  webpageExtension='").append(webpageExtension).append("',\n");
        if (fragment != null && !fragment.isEmpty()) {
            sb.append("  fragment='").append(fragment).append("',\n");
        }
        if (!queryParameters.isEmpty()) {
            sb.append("  queryParameters=").append(queryParameters).append(",\n");
        }
        if (sb.lastIndexOf(",\n") == sb.length() - 2) {
            sb.delete(sb.length() - 2, sb.length());
            sb.append("\n");
        }
        sb.append("}");
        return sb.toString();
    }
}
