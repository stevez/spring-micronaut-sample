package mrhaki.micronaut;

import io.micronaut.context.annotation.ConfigurationProperties;
import io.micronaut.context.annotation.Property;
import io.micronaut.context.annotation.Value;
import io.micronaut.http.client.HttpClientConfiguration;
import io.micronaut.runtime.ApplicationConfiguration;

import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.SocketAddress;
import java.util.Optional;

import static mrhaki.micronaut.BinClientConfiguration.PREFIX;

/**
 * Custom HTTP client configuration set via application
 * properties prefixed with "bin.client".
 */
@ConfigurationProperties(PREFIX)
public class BinClientConfiguration extends HttpClientConfiguration {
    public static final String PREFIX = "bin.client";
    /**
     * HTTP client connection pool configuration.
     */
    private final BintryClientConnectionPoolConfiguration connectionPoolConfiguration;


    @Property(name = "proxy.hostname")
    private String hostname;

    @Property(name = "proxy.port")
    private int port;

    @Property(name= "proxy.proxyType")
    private String type;


    public BinClientConfiguration(
            final ApplicationConfiguration applicationConfiguration,
            final BintryClientConnectionPoolConfiguration connectionPoolConfiguration) {
        super(applicationConfiguration);
        this.connectionPoolConfiguration = connectionPoolConfiguration;
    }

    @Override
    public ConnectionPoolConfiguration getConnectionPoolConfiguration() {
        return connectionPoolConfiguration;
    }

    @ConfigurationProperties(ConnectionPoolConfiguration.PREFIX)
    public static class BintryClientConnectionPoolConfiguration extends ConnectionPoolConfiguration {
    }

    @Override
    public Optional<SocketAddress> getProxyAddress() {

        SocketAddress sa = new InetSocketAddress(hostname, port);
        return Optional.ofNullable(sa);

    }

    @Override
    public Proxy.Type getProxyType() {
        return Proxy.Type.HTTP;
    }


}