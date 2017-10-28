package com.expedia.test.utils;

import com.expedia.domain.OffersContainer;

import java.util.ArrayList;

/**
 * @author shareef on 27/10/2017
 *
 * dirty hack to make tests work because some attributes
 * from the production will change like numberOfPeopleViewing
 * and many other
 * <p>
 * #BEST PRACTICE:
 * IS
 * 1. to have local dump that we get reset job with jenkins
 * that we know already in advance what is the response MUST Be
 * like!.
 * <p>
 * 2.compare it with the files we have stored in junit tests for that
 * <p>
 * #NOTES:
 * <p>
 * #BEST APPROCH
 * Make Automation Test that will test all possible values
 * of numberOfPeopleViewing for example may be using selinide.
 */
public class TestMutationJson {

    private static final ArrayList<Integer> testDateMutation = new ArrayList<>();

    static {
        testDateMutation.add(2017);
        testDateMutation.add(12);
        testDateMutation.add(23);
    }

    /**
     * dirty hack to make tests work because some attributes
     * from the production will change like numberOfPeopleViewing
     * and many other
     *
     * @implNote should be deprecated when we have local api working with consistent test dump of database
     * @return
     */
    public static void resetDynamicJsonAttributes(OffersContainer offersContainer) {
        for (OffersContainer.Offers.Hotel hotel : offersContainer.getOffers().getHotel()) {

            //This is easyily get broken because live data not supposed to be subject of unit test
            //it should be on local db with reset .

            /*
            * When some test fails we check difference and add the
            * dynamic attribute to reset for test to pass
            *
            * */
            hotel.setHotelUrgencyInfo(new OffersContainer.Offers.Hotel.HotelUrgencyInfo());
            hotel.setHotelPricingInfo(new OffersContainer.Offers.Hotel.HotelPricingInfo());
            hotel.setHotelUrls(new OffersContainer.Offers.Hotel.HotelUrls());
            hotel.setHotelInfo(new OffersContainer.Offers.Hotel.HotelInfo());

            hotel.setOfferDateRange(new OffersContainer.Offers.Hotel.OfferDateRange());

            hotel.setDestination(new OffersContainer.Offers.Hotel.Destincation());
        }

    }
}
