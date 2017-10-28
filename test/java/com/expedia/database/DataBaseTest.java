package com.expedia.database;

import com.expedia.test.config.SpringContextTest;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * test database on test properties configuration
 * @author shareef on 27/10/2017
 */
public class DataBaseTest extends SpringContextTest {

    @Value("${spring.datasource.url}")
    private String dbUrl;

    @Value("${spring.datasource.username}")
    private String userName;

    @Value("${spring.datasource.password}")
    private String password;

    @Value("${spring.datasource.driver}")
    private String driver;

    @Autowired
    private DataSource dataSource;

    @Test
    public void pingDatabaseConnection() {
        try (Connection connection = dataSource.getConnection()) {
            Statement stmt = connection.createStatement();
            stmt.executeUpdate("DROP TABLE IF EXISTS ticks");
            stmt.executeUpdate("CREATE TABLE IF NOT EXISTS ticks (tick TIMESTAMP)");
            stmt.executeUpdate("INSERT INTO ticks VALUES (now())");
            ResultSet rs = stmt.executeQuery("SELECT tick FROM ticks");

            ArrayList<String> output = new ArrayList<>();
            while (rs.next()) {
                output.add(String.valueOf(rs.getTimestamp("tick")));
            }

            Assert.assertTrue(!output.isEmpty());
        } catch (Exception e) {
            Logger.getLogger(SpringContextTest.class.getName())
                    .log(Level.INFO, "Exception In " + DataBaseTest.class.getName());
        }
    }

    @Bean
    public DataSource dataSource() throws SQLException {
        if (dbUrl == null || dbUrl.isEmpty()) {
            return new HikariDataSource();
        } else {
            HikariConfig config = new HikariConfig();
            config.setJdbcUrl(dbUrl);
            config.setUsername(userName);
            config.setPassword(password);
            config.setDriverClassName(driver);
            return new HikariDataSource(config);
        }
    }

}