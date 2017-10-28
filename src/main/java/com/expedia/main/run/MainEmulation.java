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

import static com.expedia.Constants.*;

/**
 * @author shareef on 27/10/2017
 *
 * Main application with spring boot
 */
@Controller
@SpringBootApplication
public class MainEmulation {

    /**
     * data source used for testing and play only there is nothing with expedia to do with it
     * but i liked to do it any way
     */
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

    public static void main(String[] args) throws Exception {
        SpringApplication.run(MainEmulation.class, args);
    }

    @RequestMapping("/")
    String index() {
        return "index";
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
        try (Connection connection = dataSource.getConnection()) {
            Statement stmt = connection.createStatement();
            stmt.executeUpdate("CREATE TABLE IF NOT EXISTS ticks (tick timestamp)");
            stmt.executeUpdate("INSERT INTO ticks VALUES (now())");
            ResultSet rs = stmt.executeQuery("SELECT tick FROM ticks");

            ArrayList<String> output = new ArrayList<>();
            while (rs.next()) {
                output.add("Read from DB: " + rs.getTimestamp("tick"));
            }

            model.put("records", output);
            return "db";
        } catch (Exception e) {
            model.put("message", e.getMessage());
            return "error";
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


    @RequestMapping("/index")
    String homepage(Map<String, Object> model) {
            return "index";
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
        try{

            String response = JsonUtils.getJSONFromUrl(
                    EXPEDIA_API_V2_URL
                            .concat(EXPEDIA_API_V2_OFFERS_URL)
                            .concat(apiCall)
            );

            OffersContainer responseOffersFromJson = new OffersContainer();

            responseOffersFromJson.fromJSON(response);
            model.put("records", responseOffersFromJson.getOffers().getHotel());
            return "index";
        } catch (Exception e) {
            //should be shown only to developer
            model.put("message", e.getMessage());
            return "error";
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