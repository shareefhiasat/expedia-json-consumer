package com.expedia.test.json;

import com.expedia.domain.OffersContainer;
import com.expedia.json.utils.JsonUtils;
import org.junit.Assert;
import org.junit.Test;

import static com.expedia.Constants.*;


/**
 * @author shareef on 27/10/2017
 * To test jsons utility by calls to the API expedia
 * means we want to test parsing json from json reponse
 * and compare with from json from object and compare them
 */
public class JsonTest {

    /**
     * #Test Description:
     * General to test if api is reachables
     * #Expected:
     * 1. API is Reachable
     * 2. Json utility works
     * It shall pass, which means we can reach
     * https://offersvc.expedia.com/offers/v2/getOffers?scenario=deal-finder&page=foo&uid=foo&productType=Hotel
     * and json pase for first offerInfo works
     */
    @Test
    public void jsonSmokeTest() {
        String response = JsonUtils.getAttributeFromJSONUrl(
                EXPEDIA_API_V2_URL
                        .concat(EXPEDIA_API_V2_OFFERS_URL)
                        .concat(DEAL_OFFERS),
                "offerInfo"
        );

        Assert.assertEquals(
                "{\"siteID\":\"1\",\"language\":\"en_US\",\"currency\":\"USD\"}",
                response);
    }

    /**
     * #Test Description:
     * It is a JSON API that presents a bunch of Hotel deals.
     * <p>
     * #Expected:
     * It shall pass, which means we can reach
     * https://offersvc.expedia.com/offers/v2/getOffers?scenario=deal-finder&page=foo&uid=foo&productType=Hotel
     * and get response parsed for WHOLE json
     * <p>
     * #Notes:
     * I escaped the response json but with exceptions to some terms
     * #P.S:
     * Check com/expedia/json/security/JsonSecureSerializer.java:24 i added exception on localizedHotelName and other
     * to be excepted from being escaped
     */
    @Test
    public void offersTest() {
        String response = JsonUtils.getJSONFromUrl(
                EXPEDIA_API_V2_URL
                        .concat(EXPEDIA_API_V2_OFFERS_URL)
                        .concat(DEAL_OFFERS)
        );

        OffersContainer offersFromJson = new OffersContainer();
        Assert.assertTrue(offersFromJson.fromJSON(response));
        Assert.assertEquals(offersFromJson.toJSON(), response);
    }

    /**
     * #Test Description:
     * It is a JSON API that presents a bunch of Hotel deals.
     * <p>
     * #Expected:
     * It shall FAIL, which means we can reach
     * https://offersvc.expedia.com/offers/v2/getOffers?scenario=deal-finder&page=foo&uid=foo&productType=Hotel
     * and get response parsed for WHOLE json but because of escaping response it will fail
     * check details below.
     * <p>
     * #More Detailed Description:
     * Secured means when we get a response we escape the response
     * for script injection by doing HtmlEscape, this FAILS here
     * means either we should not Escape assuming that we validate
     * the saving of that string in our severs , or we trust
     * that response !. or we escape it in jsp or front end
     * using this for exampel ${fn:escapeXml(xxxx)}
     * example am referring  check word &trade; here.
     * "hotelInfo":{"hotelId":"19384","hotelName":"Wyndham Lake Buena Vista Disney Springs&trade;
     * <p>
     * #Notes:
     * This is secured response json parsed and html escaped
     * #P.S:
     * Check com/expedia/json/security/JsonSecureSerializer.java:24 i added exception on localizedHotelName and other
     * to be excepted from being escaped
     */
    @Test
    public void offersTestSecured() {
        String response = JsonUtils.getJSONFromUrl(
                EXPEDIA_API_V2_URL
                        .concat(EXPEDIA_API_V2_OFFERS_URL)
                        .concat(DEAL_OFFERS)
        );

        OffersContainer offersFromJson = new OffersContainer();
        //todo ASK expedia do we trust that response!
        Assert.assertTrue(offersFromJson.fromJSON(response));
        Assert.assertEquals(offersFromJson.toJSON(), response);
    }
}
