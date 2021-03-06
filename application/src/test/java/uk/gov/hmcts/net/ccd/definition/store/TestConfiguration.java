package uk.gov.hmcts.net.ccd.definition.store;

import com.opentable.db.postgres.embedded.EmbeddedPostgres;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.StandardEnvironment;
import org.springframework.core.io.support.ResourcePropertySource;
import org.springframework.web.context.ContextCleanupListener;

import javax.annotation.PreDestroy;
import javax.sql.DataSource;
import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;

@Configuration
public class TestConfiguration extends ContextCleanupListener {

    private static final Logger LOG = LoggerFactory.getLogger(TestConfiguration.class);

    @Bean
    public EmbeddedPostgres embeddedPostgres() throws IOException {

        int port = randomPort();

        LOG.info("Starting postgres with port number {}", port);

        return EmbeddedPostgres
            .builder()
            .setPort(port)
            .start();
    }

    @Bean
    public DataSource dataSource() throws IOException {
        return embeddedPostgres().getPostgresDatabase();
    }

    @PreDestroy
    public void contextDestroyed() throws IOException {
        embeddedPostgres().close();
    }

    @Autowired
    public void loadLocalOverridePropertiesIfItExists(StandardEnvironment environment) {
        try {
            String localPropertiesPath = environment.resolvePlaceholders("classpath:test-local-override.properties");
            ResourcePropertySource localPropertySource = new ResourcePropertySource(localPropertiesPath);
            environment.getPropertySources().addFirst(localPropertySource);
        } catch (IOException ignored) {}
    }

    private int randomPort() {
        return ThreadLocalRandom.current().nextInt(50366, 60366);
    }
}
