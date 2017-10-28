package com.expedia.test.api;

import com.expedia.domain.OffersContainer;
import com.expedia.json.utils.JsonUtils;
import com.expedia.test.utils.TestMutationJson;
import com.expedia.utils.FileUtil;
import org.junit.Assert;
import org.junit.Test;

import static com.expedia.constants.Constants.*;
//importing like this is better practice because it dose not affect performance .*


/**
 * @author shareef on 27/10/2017
 * To test jsons calls to the API expedia
 * here we test parsed response with expected
 * result we have in files
 */
public class OfferAPITest {

    /**
     * #Test Description:
     * It is a JSON API tests offers filtered by destination name
     * <p>
     * #Expected:
     * It shall pass, which means we can reach
     * https://offersvc.expedia.com/offers/v2/getOffers?scenario=deal-finder&page=foo&uid=foo&productType=Hotel&destinationName=New%20Orleans
     * and get response parsed for WHOLE json
     * and compare to FILE with expected result to test filter by name
     * <p>
     * #Notes:
     * I escaped the response json but with exceptions to some terms
     */
    @Test
    public void offersFilteredByDestinationNameTest() {
        String content = FileUtil.getFileContent("test/resources/json/offerBunchHotelDealsFilteredByDestinationName.json");
        String apiCall = TEST_DEAL_OFFERS_FILTERED_BY_DESTINATION_NAME;

        apiCallTest(content, apiCall);
    }

    /**
     * #Test Description:
     * It is a JSON API tests offers filtered by min trip start Date
     * <p>
     * #Expected:
     * It shall pass, which means we can reach
     * https://offersvc.expedia.com/offers/v2/getOffers?scenario=deal-finder&page=foo&uid=foo&productType=Hotel&destinationCity=New%20Orleans&maxTripStartDate=2017-11-10
     * and get response parsed for WHOLE json
     * and compare to FILE with expected result to test filter by min trip start date
     * <p>
     * #Notes:
     * I escaped the response json but with exceptions to some terms
     */
    @Test
    public void offersFilteredByMinTripStartDateTest() {
        String content = FileUtil.getFileContent("test/resources/json/offerBunchHotelDealsFilteredByMinTripStartDate.json");
        String apiCall = TEST_DEAL_OFFERS_FILTERED_BY_MIN_TIRP_START_DATE;

        apiCallTest(content, apiCall);
    }

    /**
     * #Test Description:
     * It is a JSON API tests offers filtered by max trip start Date
     * <p>
     * #Expected:
     * It shall pass, which means we can reach
     * https://offersvc.expedia.com/offers/v2/getOffers?scenario=deal-finder&page=foo&uid=foo&productType=Hotel&destinationCity=New%20Orleans&maxTripStartDate=2017-11-10"
     * and get response parsed for WHOLE json
     * and compare to FILE with expected result to test filter by max trip start date
     * <p>
     * #Notes:
     * I escaped the response json but with exceptions to some terms
     */
    @Test
    public void offersFilteredByMaxTripStartDateTest() {
        String content = FileUtil.getFileContent("test/resources/json/offerBunchHotelDealsFilteredByMaxTripStartDate.json");
        String apiCall = TEST_DEAL_OFFERS_FILTERED_BY_MAX_TIRP_START_DATE;

        apiCallTest(content, apiCall);
    }

    /**
     * #Test Description:
     * It is a JSON API tests offers filtered by region id
     * <p>
     * #Expected:
     * It shall pass, which means we can reach
     * https://offersvc.expedia.com/offers/v2/getOffers?scenario=deal-finder&page=foo&uid=foo&productType=Hotel&regionIds=6126616,6057480
     * and get response parsed for WHOLE json
     * and compare to FILE with expected result to test filter by region ids
     * <p>
     * #Notes:
     * I escaped the response json but with exceptions to some terms
     * <p>
     * #P.S we send two region ids
     */
    @Test
    public void offersFilteredByRegionIdsTest() {
        String content = FileUtil.getFileContent("test/resources/json/offerBunchHotelDealsFilteredByRegionIds.json");
        String apiCall = TEST_DEAL_OFFERS_FILTERED_BY_REAGION_IDS;
        apiCallTest(content, apiCall);
    }

    /**
     * #Test Description:
     * It is a JSON API tests offers filtered by Minimum Star Rating
     * <p>
     * #Expected:
     * It shall pass, which means we can reach
     * https://offersvc.expedia.com/offers/v2/getOffers?scenario=deal-finder&page=foo&uid=foo&productType=Hotel&minStarRating=5
     * and get response parsed for WHOLE json
     * and compare to FILE with expected result to test filter by min star rating
     * <p>
     * #Notes:
     * I escaped the response json but with exceptions to some terms
     */
    @Test
    public void offersFilteredByMinStarRatingTest() {
        String content = FileUtil.getFileContent("test/resources/json/offerBunchHotelDealsFilteredByMinStarRating.json");
        String apiCall = TEST_DEAL_OFFERS_FILTERED_BY_MIN_STAR_RATING;

        apiCallTest(content, apiCall);
    }

    private void apiCallTest(String content, String apiCall) {
        String response = JsonUtils.getJSONFromUrl(
                EXPEDIA_API_V2_URL
                        .concat(EXPEDIA_API_V2_OFFERS_URL)
                        .concat(apiCall)
        );

        OffersContainer responseOffersFromJson = new OffersContainer();
        OffersContainer expectedOffersFromJson = new OffersContainer();

        Assert.assertTrue(responseOffersFromJson.fromJSON(response));
        Assert.assertTrue(expectedOffersFromJson.fromJSON(content));

        TestMutationJson.resetDynamicJsonAttributes(responseOffersFromJson);
        TestMutationJson.resetDynamicJsonAttributes(expectedOffersFromJson);

        Assert.assertEquals(expectedOffersFromJson.toJSON(), responseOffersFromJson.toJSON());
    }

    /**
     * #Test Description:
     * It is a JSON API tests offers filtered by Maximum Star Rating
     * <p>
     * #Expected:
     * It shall pass, which means we can reach
     * https://offersvc.expedia.com/offers/v2/getOffers?scenario=deal-finder&page=foo&uid=foo&productType=Hotel&maxStarRating=5
     * and get response parsed for WHOLE json
     * and compare to FILE with expected result to test filter by max star rating
     * <p>
     * #Notes:
     * I escaped the response json but with exceptions to some terms
     */
    @Test
    public void offersFilteredByMaxStarRatingTest() {
        String content = FileUtil.getFileContent("test/resources/json/offerBunchHotelDealsFilteredByMaxStarRating.json");
        String apiCall = TEST_DEAL_OFFERS_FILTERED_BY_MAX_STAR_RATING;
        apiCallTest(content, apiCall);
    }

    /**
     * #Test Description:
     * It is a JSON API tests offers filtered by Minimum total Rating
     * <p>
     * #Expected:
     * It shall pass, which means we can reach
     * https://offersvc.expedia.com/offers/v2/getOffers?scenario=deal-finder&page=foo&uid=foo&productType=Hotel&minTotalRating=5
     * and get response parsed for WHOLE json
     * and compare to FILE with expected result to test filter by min total rating
     * <p>
     * #Notes:
     * I escaped the response json but with exceptions to some terms
     */
    @Test
    public void offersFilteredByMinTotalRatingTest() {
        String content = FileUtil.getFileContent("test/resources/json/offerBunchHotelDealsFilteredByMinTotalRate.json");
        String apiCall = TEST_DEAL_OFFERS_FILTERED_BY_MIN_STAR_RATING;
        apiCallTest(content, apiCall);
    }

    /**
     * #Test Description:
     * It is a JSON API tests offers filtered by Maximum total Rating
     * <p>
     * #Expected:
     * It shall pass, which means we can reach
     * https://offersvc.expedia.com/offers/v2/getOffers?scenario=deal-finder&page=foo&uid=foo&productType=Hotel&maxTotalRating=5
     * and get response parsed for WHOLE json
     * and compare to FILE with expected result to test filter by max total rating
     * <p>
     * #Notes:
     * I escaped the response json but with exceptions to some terms
     */
    @Test
    public void offersFilteredByMaxTotalRatingTest() {
        String content = FileUtil.getFileContent("test/resources/json/offerBunchHotelDealsFilteredByMaxTotalRate.json");
        String apiCall = TEST_DEAL_OFFERS_FILTERED_BY_MAX_TOTAL_RATING;
        apiCallTest(content, apiCall);
    }

    /**
     * #Test Description:
     * It is a JSON API tests offers filtered by Minimum guest Rating
     * <p>
     * #Expected:
     * It shall pass, which means we can reach
     * https://offersvc.expedia.com/offers/v2/getOffers?scenario=deal-finder&page=foo&uid=foo&productType=Hotel&minTotalRating=5
     * and get response parsed for WHOLE json
     * and compare to FILE with expected result to test filter by min guest rating
     * <p>
     * #Notes:
     * I escaped the response json but with exceptions to some terms
     */
    @Test
    public void offersFilteredByMinGuestRatingTest() {
        String content = FileUtil.getFileContent("test/resources/json/offerBunchHotelDealsFilteredByMinGuestRate.json");
        String apiCall = TEST_DEAL_OFFERS_FILTERED_BY_MIN_GUEST_RATING;
        apiCallTest(content, apiCall);
    }

    /**
     * #Test Description:
     * It is a JSON API tests offers filtered by Maximum guest Rating
     * <p>
     * #Expected:
     * It shall pass, which means we can reach
     * https://offersvc.expedia.com/offers/v2/getOffers?scenario=deal-finder&page=foo&uid=foo&productType=Hotel&maxGuestRating=5
     * and get response parsed for WHOLE json
     * and compare to FILE with expected result to test filter by max total rating
     * <p>
     * #Notes:
     * I escaped the response json but with exceptions to some terms
     */
    @Test
    public void offersFilteredByMaxGuestRatingTest() {
        String content = FileUtil.getFileContent("test/resources/json/offerBunchHotelDealsFilteredByMaxGuestRate.json");
        String apiCall = TEST_DEAL_OFFERS_FILTERED_BY_MAX_GUEST_RATING;
        apiCallTest(content, apiCall);
    }
}
