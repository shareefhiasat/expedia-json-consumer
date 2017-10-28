package com.expedia.constants;

/**
 * test constants to separate
 * @author shareef on 27/10/2017
 */
public class Constants {
    /*
    * TEST CONSTANTS
    *
    * */
    //i repeated this despite its in Constants.java in src because test urls might be
    //different @todo i shall move to properties
    public final static String EXPEDIA_API_V2_URL = "https://offersvc.expedia.com";
    public final static String EXPEDIA_API_V2_OFFERS_URL = "/offers/v2/getOffers";

    public final static String DEAL_OFFERS = "?scenario=deal-finder&page=foo&uid=foo&productType=Hotel";


    //todo ASK expedia the link in github is wrong it sends one of the parameters as &minTripStartDate=:2000-05-03 we must remove the colon so it works
    public final static String TEST_DEAL_OFFERS_FILTERED_BY_MIN_TIRP_START_DATE = "?scenario=deal-finder&page=foo&uid=foo&productType=Hotel&destinationCity=New%20Orleans&minTripStartDate=2000-05-03";
    public final static String TEST_DEAL_OFFERS_FILTERED_BY_MAX_TIRP_START_DATE = "?scenario=deal-finder&page=foo&uid=foo&productType=Hotel&destinationCity=New%20Orleans&maxTripStartDate=2017-11-10";

    /**
     * By Location , Destination Reagion
     */
    public final static String TEST_DEAL_OFFERS_FILTERED_BY_DESTINATION_NAME = "?scenario=deal-finder&page=foo&uid=foo&productType=Hotel&destinationName=New%20Orleans";
    public final static String TEST_DEAL_OFFERS_FILTERED_BY_REAGION_IDS = "?scenario=deal-finder&page=foo&uid=foo&productType=Hotel&regionIds=6126616,6057480";

    /**
     * By Rating
     */
    public final static String TEST_DEAL_OFFERS_FILTERED_BY_MIN_STAR_RATING = "?scenario=deal-finder&page=foo&uid=foo&productType=Hotel&minStarRating=5";
    public final static String TEST_DEAL_OFFERS_FILTERED_BY_MAX_STAR_RATING = "?scenario=deal-finder&page=foo&uid=foo&productType=Hotel&maxStarRating=5";

    public final static String TEST_DEAL_OFFERS_FILTERED_BY_MIN_TOTAL_RATING = "?scenario=deal-finder&page=foo&uid=foo&productType=Hotel&minTotalRating=5";
    public final static String TEST_DEAL_OFFERS_FILTERED_BY_MAX_TOTAL_RATING = "?scenario=deal-finder&page=foo&uid=foo&productType=Hotel&maxTotalRating=5";

    public final static String TEST_DEAL_OFFERS_FILTERED_BY_MIN_GUEST_RATING = "?scenario=deal-finder&page=foo&uid=foo&productType=Hotel&minGuestRating=5";
    public final static String TEST_DEAL_OFFERS_FILTERED_BY_MAX_GUEST_RATING = "?scenario=deal-finder&page=foo&uid=foo&productType=Hotel&minGuestRating=5";


}
