/*
 * Copyright 2002-2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.expedia.main.run;

import com.expedia.domain.OffersContainer;
import com.expedia.json.utils.JsonUtils;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import static com.expedia.Constants.*;

/**
 * @author shareef on 27/10/2017
 * <p>
 * Main application with spring boot
 */
@Controller
@SpringBootApplication
public class MainEmulation {

    public static final String MESSAGE = "message";
    public static final String RECORDS = "records";
    public static final String INDEX = "index";
    public static final String ERROR = "error";
    public static final String DB = "db";
    /**
     * data source used for testing and play only there is nothing with expedia to do with it
     * but i liked to do it any way
     */
    @Value("${spring.datasource.url}")
    private String dbUrl;

    /*enable below in local sandbox if you want db test
    @Value("${spring.datasource.username}")
    private String userName;

    @Value("${spring.datasource.password}")
    private String password;

    @Value("${spring.datasource.driver}")
    private String driver;*/

    @Autowired
    private DataSource dataSource;

    public static void main(String[] args) throws Exception {
        SpringApplication.run(MainEmulation.class, args);
    }

    @RequestMapping("/")
    String index() {
        return INDEX;
    }

    /**
     * you can test your database from this db
     * i already configured datasource to be working
     *
     * @param model
     * @return
     */
    @RequestMapping("/db")
    String db(Map<String, Object> model) {
        ResultSet rs = null;
        Statement stmt = null;

        try (Connection connection = dataSource.getConnection()) {
            stmt = connection.createStatement();
            stmt.executeUpdate("CREATE TABLE IF NOT EXISTS ticks (tick TIMESTAMP)");
            stmt.executeUpdate("INSERT INTO ticks VALUES (now())");
            rs = stmt.executeQuery("SELECT tick FROM ticks");

            ArrayList<String> output = new ArrayList<>();
            while (rs.next()) {
                output.add("Read from DB: " + rs.getTimestamp("tick"));
            }

            model.put(RECORDS, output);
            return DB;
        } catch (Exception e) {
            model.put(MESSAGE, e.getMessage());
            return ERROR;
        } finally {
            try {
                if (stmt != null)
                    stmt.close();

                if (rs != null)
                    rs.close();
            } catch (SQLException e) {
                Logger.getLogger(MainEmulation.class.getName())
                        .log(Level.WARNING, "Exception In " + MainEmulation.class.getName());
            }
        }
    }

    @Bean
    public DataSource dataSource() throws SQLException {
        if (dbUrl == null || dbUrl.isEmpty()) {
            return new HikariDataSource();
        } else {
            HikariConfig config = new HikariConfig();
            config.setJdbcUrl(dbUrl);
            /*enable below in local sandbox if you want db test
            config.setUsername(userName);
            config.setPassword(password);
            config.setDriverClassName(driver);
            */
            return new HikariDataSource(config);
        }
    }


    @RequestMapping("/index")
    String homepage(Map<String, Object> model) {
        return INDEX;
    }


    /**
     * Test page for by destination name
     * This is fixed filter
     * There is no abililty to use filters in the UI its just to be cute design only
     */
    @RequestMapping("/by-destination-name")
    String byDestinationNameTest(Map<String, Object> model) {
        String apiCall = DEAL_OFFERS_FILTERED_BY_DESTINATION_NAME;
        return ApiCallModel(model, apiCall);
    }

    /**
     * Test page for by region ids
     * This is fixed filter
     * There is no abililty to use filters in the UI its just to be cute design only
     */
    @RequestMapping("/by-region-ids")
    String byRegionIdsTest(Map<String, Object> model) {
        String apiCall = DEAL_OFFERS_FILTERED_BY_REAGION_IDS;
        return ApiCallModel(model, apiCall);
    }

    /**
     * Test page for by max guest rating
     * This is fixed filter
     * There is no abililty to use filters in the UI its just to be cute design only
     */
    @RequestMapping("/by-max-guest-rating")
    String byMaxGuestRatingTest(Map<String, Object> model) {
        String apiCall = DEAL_OFFERS_FILTERED_BY_MAX_GUEST_RATING;
        return ApiCallModel(model, apiCall);
    }

    /**
     * Test page for by min guest rating
     * This is fixed filter
     * There is no abililty to use filters in the UI its just to be cute design only
     */
    @RequestMapping("/by-min-guest-rating")
    String byMinGuestRatingTest(Map<String, Object> model) {
        String apiCall = DEAL_OFFERS_FILTERED_BY_MIN_GUEST_RATING;
        return ApiCallModel(model, apiCall);
    }

    /**
     * Test page for by max star rating
     * This is fixed filter
     * There is no abililty to use filters in the UI its just to be cute design only
     */
    @RequestMapping("/by-max-star-rating")
    String byMaxStarRatingTest(Map<String, Object> model) {
        String apiCall = DEAL_OFFERS_FILTERED_BY_MAX_STAR_RATING;
        return ApiCallModel(model, apiCall);
    }

    /**
     * Test page for by min star rating
     * This is fixed filter
     * There is no abililty to use filters in the UI its just to be cute design only
     */
    @RequestMapping("/by-min-star-rating")
    String byMinStarRatingTest(Map<String, Object> model) {
        String apiCall = DEAL_OFFERS_FILTERED_BY_MIN_STAR_RATING;
        return ApiCallModel(model, apiCall);
    }

    private String ApiCallModel(Map<String, Object> model, String apiCall) {
        try {

            String response = JsonUtils.getJSONFromUrl(
                    EXPEDIA_API_V2_URL
                            .concat(EXPEDIA_API_V2_OFFERS_URL)
                            .concat(apiCall)
            );

            OffersContainer responseOffersFromJson = new OffersContainer();

            responseOffersFromJson.fromJSON(response);
            model.put(RECORDS, responseOffersFromJson.getOffers().getHotel());
            return INDEX;
        } catch (Exception e) {
            //should be shown only to developer
            model.put(MESSAGE, e.getMessage());
            return ERROR;
        }
    }

    /**
     * Test page for by max total rating
     * This is fixed filter
     * There is no abililty to use filters in the UI its just to be cute design only
     */
    @RequestMapping("/by-max-total-rating")
    String byMaxTotalRatingTest(Map<String, Object> model) {
        String apiCall = DEAL_OFFERS_FILTERED_BY_MAX_TOTAL_RATING;
        return ApiCallModel(model, apiCall);
    }

    /**
     * Test page for by min total rating
     * This is fixed filter
     * There is no abililty to use filters in the UI its just to be cute design only
     */
    @RequestMapping("/by-min-total-rating")
    String byMinTotalRatingTest(Map<String, Object> model) {
        String apiCall = DEAL_OFFERS_FILTERED_BY_MIN_TOTAL_RATING;
        return ApiCallModel(model, apiCall);
    }

    /**
     * Test page for by max trip start date
     * This is fixed filter
     * There is no abililty to use filters in the UI its just to be cute design only
     */
    @RequestMapping("/by-max-trip-start-date")
    String byMaxTripStartDateTest(Map<String, Object> model) {
        String apiCall = TEST_DEAL_OFFERS_FILTERED_BY_MAX_TIRP_START_DATE;
        return ApiCallModel(model, apiCall);
    }

    /**
     * Test page for by min trip start date
     * This is fixed filter
     * There is no abililty to use filters in the UI its just to be cute design only
     */
    @RequestMapping("/by-min-trip-start-date")
    String byMinTripStartDateTest(Map<String, Object> model) {
        String apiCall = TEST_DEAL_OFFERS_FILTERED_BY_MIN_TIRP_START_DATE;
        return ApiCallModel(model, apiCall);
    }


}