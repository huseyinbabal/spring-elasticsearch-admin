package com.cubuzoa.springelasticsearchadmin.service.impl;

import com.cubuzoa.springelasticsearchadmin.exception.MissingTypeException;
import com.cubuzoa.springelasticsearchadmin.service.ElasticsearchService;
import io.searchbox.client.JestClient;
import io.searchbox.client.JestClientFactory;
import io.searchbox.client.JestResult;
import io.searchbox.client.config.ClientConfig;
import io.searchbox.client.http.JestHttpClient;
import io.searchbox.cluster.Health;
import io.searchbox.cluster.State;
import org.apache.commons.lang.StringUtils;
import org.apache.http.client.methods.HttpUriRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;

/**
 * A service class for performing basic elasticsearch queries
 */

@Component
public class ElasticsearchServiceImpl implements ElasticsearchService {

    @Value("${elasticsearch['host']}")
    private String host;

    @Value("${elasticsearch['port']}")
    private String port;

    private String index;

    private String type;

    protected JestClient client = null;

    /**
     * Default constructor
     */
    public ElasticsearchServiceImpl() {}

    /**
     * Jest Client builder by using constructor arguments
     *
     * @throws MissingTypeException
     */
    public void buildJestClient() {
        ClientConfig clientConfig = new ClientConfig.Builder(getServerUrl()).multiThreaded(true).build();
        JestClientFactory factory = new JestClientFactory();
        factory.setClientConfig(clientConfig);
        client = factory.getObject();
    }

    /**
     * Generates server url by using instance variables.
     * Ex: http://localhost:9200
     *
     * @return
     */
    public String getServerUrl() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(host);
        if (port != null && StringUtils.isNotEmpty(port)) {
            stringBuffer.append(":");
            stringBuffer.append(port);
        }
        return stringBuffer.toString();
    }

    /**
     * Returns server's state information
     * @return
     * @throws Exception
     */
    public JestResult getServerState() throws Exception {
        if (client == null) {
            buildJestClient();
        }
        JestResult result = client.execute(new State.Builder().build());
        return result;
    }

    public JestResult getServerHealth() throws Exception {
        if (client == null) {
            buildJestClient();
        }

        JestResult result = client.execute(new Health.Builder().build());
        return result;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public JestClient getClient() {
        return client;
    }

    public void setClient(JestClient client) {
        this.client = client;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ElasticsearchServiceImpl that = (ElasticsearchServiceImpl) o;

        if (client != null ? !client.equals(that.client) : that.client != null) return false;
        if (host != null ? !host.equals(that.host) : that.host != null) return false;
        if (index != null ? !index.equals(that.index) : that.index != null) return false;
        if (port != null ? !port.equals(that.port) : that.port != null) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = host != null ? host.hashCode() : 0;
        result = 31 * result + (port != null ? port.hashCode() : 0);
        result = 31 * result + (index != null ? index.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (client != null ? client.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ElasticsearchServiceImpl{" +
                "host='" + host + '\'' +
                ", port='" + port + '\'' +
                ", index='" + index + '\'' +
                ", type='" + type + '\'' +
                ", client=" + client +
                '}';
    }
}
