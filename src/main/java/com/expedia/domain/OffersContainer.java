package com.expedia.domain;

import com.expedia.web.types.Webinizer;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.UnsupportedEncodingException;
import java.util.List;


/**
 * @author shareef on 27/10/2017
 *
 * main object that encapsulate the big json into one
 * domain class with sub classes
 */
public class OffersContainer extends Webinizer {

    /**
     * offerInfo : {"siteID":"1","language":"en_US","currency":"USD"}
     * userInfo : {"persona":{"personaType":"OTHERS"},"userId":"foo"}
     * offers : {"hotel":[{"offerDateRange":{"travelStartDate":[2017,12,7],"travelEndDate":[2017,12,18],"lengthOfStay":11},"destination":{"regionID":"178293","associatedMultiCityRegionId":"178293","longName":"New York (and vicinity), New York, United States of America","shortName":"New York","country":"United States of America","province":"New York","city":"New York","tla":"NYC","nonLocalizedCity":"New York"},"hotelInfo":{"hotelId":"4818574","hotelName":"the OUT NYC","localizedHotelName":"the OUT NYC","hotelDestination":"New York","hotelDestinationRegionID":"2621","hotelLongDestination":"New York,NY,USA","hotelStreetAddress":"510 W 42nd St","hotelCity":"New York","hotelProvince":"NY","hotelCountryCode":"USA","hotelLatitude":40.760007,"hotelLongitude":-73.996383,"hotelStarRating":"4.0","hotelGuestReviewRating":3.94,"hotelReviewTotal":983,"hotelImageUrl":"https://images.trvl-media.com/hotels/5000000/4820000/4818600/4818574/0138f487_t.jpg","isOfficialRating":false},"hotelUrgencyInfo":{"airAttachRemainingTime":0,"numberOfPeopleViewing":32,"numberOfPeopleBooked":0,"numberOfRoomsLeft":49,"lastBookedTime":1508873763309,"almostSoldStatus":"AVAILABLE","link":"/hotel-Search#selected=4818574","airAttachEnabled":false},"hotelPricingInfo":{"averagePriceValue":267.87,"totalPriceValue":2946.57,"crossOutPriceValue":796.04,"originalPricePerNight":796.04,"percentSavings":66.35,"drr":false},"hotelUrls":{"hotelInfositeUrl":"https%3A%2F%2Fwww.expedia.com%2Fgo%2Fhotel%2Finfo%2F4818574%2F2017-12-07%2F2017-12-18","hotelSearchResultUrl":"https%3A%2F%2Fwww.expedia.com%2Fgo%2Fhotel%2Fsearch%2FDestination%2F2017-12-07%2F2017-12-18%3FSearchType%3DDestination%26CityName%3DNew+York%26RegionId%3D178293%26Selected%3D4818574"}},{"offerDateRange":{"travelStartDate":[2018,1,8],"travelEndDate":[2018,1,9],"lengthOfStay":1},"destination":{"regionID":"178280","associatedMultiCityRegionId":"178280","longName":"Los Angeles (and vicinity), California, United States Of America","shortName":"Los Angeles","country":"United States of America","province":"California","city":"Los Angeles","tla":"QLA","nonLocalizedCity":"Los Angeles"},"hotelInfo":{"hotelId":"1180296","hotelName":"Hollywood Inn Express North","localizedHotelName":"Hollywood Inn Express North","hotelDestination":"Los Angeles","hotelDestinationRegionID":"2011","hotelLongDestination":"Los Angeles,CA,USA","hotelStreetAddress":"5131 Hollywood Blvd.","hotelCity":"Los Angeles","hotelProvince":"CA","hotelCountryCode":"USA","hotelLatitude":34.10177,"hotelLongitude":-118.30159,"hotelStarRating":"2.0","hotelGuestReviewRating":2.85,"hotelReviewTotal":641,"hotelImageUrl":"https://images.trvl-media.com/hotels/2000000/1190000/1180300/1180296/1180296_50_t.jpg","isOfficialRating":false},"hotelUrgencyInfo":{"airAttachRemainingTime":0,"numberOfPeopleViewing":15,"numberOfPeopleBooked":3,"numberOfRoomsLeft":0,"lastBookedTime":1509053528983,"almostSoldStatus":"ALMOST_SOLD","link":"/hotel-Search#selected=1180296","airAttachEnabled":false},"hotelPricingInfo":{"averagePriceValue":88.2,"totalPriceValue":88.2,"crossOutPriceValue":180,"originalPricePerNight":180,"percentSavings":51,"drr":false},"hotelUrls":{"hotelInfositeUrl":"https%3A%2F%2Fwww.expedia.com%2Fgo%2Fhotel%2Finfo%2F1180296%2F2018-01-08%2F2018-01-09","hotelSearchResultUrl":"https%3A%2F%2Fwww.expedia.com%2Fgo%2Fhotel%2Fsearch%2FDestination%2F2018-01-08%2F2018-01-09%3FSearchType%3DDestination%26CityName%3DLos+Angeles%26RegionId%3D178280%26Selected%3D1180296"}},{"offerDateRange":{"travelStartDate":[2017,11,27],"travelEndDate":[2017,12,2],"lengthOfStay":5},"destination":{"regionID":"178276","associatedMultiCityRegionId":"178276","longName":"Las Vegas (and vicinity), Nevada, United States Of America","shortName":"Las Vegas","country":"United States of America","province":"Nevada","city":"Las Vegas","tla":"LAS","nonLocalizedCity":"Las Vegas"},"hotelInfo":{"hotelId":"15237","hotelName":"Luxor hotel and Casino","localizedHotelName":"Luxor hotel and Casino","hotelDestination":"Las Vegas","hotelDestinationRegionID":"2008","hotelLongDestination":"Las Vegas,NV,USA","hotelStreetAddress":"3900 S. Las Vegas Blvd","hotelCity":"Las Vegas","hotelProvince":"NV","hotelCountryCode":"USA","hotelLatitude":36.09659,"hotelLongitude":-115.173085,"hotelStarRating":"3.5","hotelGuestReviewRating":3.64,"hotelReviewTotal":51373,"hotelImageUrl":"https://images.trvl-media.com/hotels/1000000/20000/15300/15237/e2b95d01_t.jpg","isOfficialRating":false},"hotelUrgencyInfo":{"airAttachRemainingTime":0,"numberOfPeopleViewing":268,"numberOfPeopleBooked":332,"numberOfRoomsLeft":503,"lastBookedTime":1509087416365,"almostSoldStatus":"AVAILABLE","link":"/hotel-Search#selected=15237","airAttachEnabled":false},"hotelPricingInfo":{"averagePriceValue":44.58,"totalPriceValue":222.9,"crossOutPriceValue":68.58,"originalPricePerNight":68.58,"percentSavings":35,"drr":false},"hotelUrls":{"hotelInfositeUrl":"https%3A%2F%2Fwww.expedia.com%2Fgo%2Fhotel%2Finfo%2F15237%2F2017-11-27%2F2017-12-02","hotelSearchResultUrl":"https%3A%2F%2Fwww.expedia.com%2Fgo%2Fhotel%2Fsearch%2FDestination%2F2017-11-27%2F2017-12-02%3FSearchType%3DDestination%26CityName%3DLas+Vegas%26RegionId%3D178276%26Selected%3D15237"}}]}
     */

    private OfferInfo offerInfo;
    private UserInfo userInfo;
    private Offers offers;

    public OfferInfo getOfferInfo() {
        return offerInfo;
    }

    public void setOfferInfo(OfferInfo offerInfo) {
        this.offerInfo = offerInfo;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public Offers getOffers() {
        return offers;
    }

    public void setOffers(Offers offers) {
        this.offers = offers;
    }

    public static class OfferInfo extends Webinizer {
        /**
         * siteID : 1
         * language : en_US
         * currency : USD
         */

        private String siteID;
        private String language;
        private String currency;

        public String getSiteID() {
            return siteID;
        }

        public void setSiteID(String siteID) {
            this.siteID = siteID;
        }

        public String getLanguage() {
            return language;
        }

        public void setLanguage(String language) {
            this.language = language;
        }

        public String getCurrency() {
            return currency;
        }

        public void setCurrency(String currency) {
            this.currency = currency;
        }
    }

    public static class UserInfo extends Webinizer {
        /**
         * persona : {"personaType":"OTHERS"}
         * userId : foo
         */

        private Persona persona;
        private String userId;

        public Persona getPersona() {
            return persona;
        }

        public void setPersona(Persona persona) {
            this.persona = persona;
        }

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public static class Persona extends Webinizer {
            /**
             * personaType : OTHERS
             */

            private String personaType;

            public String getPersonaType() {
                return personaType;
            }

            public void setPersonaType(String personaType) {
                this.personaType = personaType;
            }
        }
    }

    public static class Offers extends Webinizer {
        @JsonProperty(value = "Hotel")
        private List<Offers.Hotel> hotel;

        public List<Offers.Hotel> getHotel() {
            return hotel;
        }

        public void setHotel(List<Offers.Hotel> Hotel) {
            this.hotel = Hotel;
        }

        public static class Hotel extends Webinizer {
            /**
             * offerDateRange : {"travelStartDate":[2017,12,7],"travelEndDate":[2017,12,18],"lengthOfStay":11}
             * destination : {"regionID":"178293","associatedMultiCityRegionId":"178293","longName":"New York (and vicinity), New York, United States of America","shortName":"New York","country":"United States of America","province":"New York","city":"New York","tla":"NYC","nonLocalizedCity":"New York"}
             * hotelInfo : {"hotelId":"4818574","hotelName":"the OUT NYC","localizedHotelName":"the OUT NYC","hotelDestination":"New York","hotelDestinationRegionID":"2621","hotelLongDestination":"New York,NY,USA","hotelStreetAddress":"510 W 42nd St","hotelCity":"New York","hotelProvince":"NY","hotelCountryCode":"USA","hotelLatitude":40.760007,"hotelLongitude":-73.996383,"hotelStarRating":"4.0","hotelGuestReviewRating":3.94,"hotelReviewTotal":983,"hotelImageUrl":"https://images.trvl-media.com/hotels/5000000/4820000/4818600/4818574/0138f487_t.jpg","isOfficialRating":false}
             * hotelUrgencyInfo : {"airAttachRemainingTime":0,"numberOfPeopleViewing":32,"numberOfPeopleBooked":0,"numberOfRoomsLeft":49,"lastBookedTime":1508873763309,"almostSoldStatus":"AVAILABLE","link":"/hotel-Search#selected=4818574","airAttachEnabled":false}
             * hotelPricingInfo : {"averagePriceValue":267.87,"totalPriceValue":2946.57,"crossOutPriceValue":796.04,"originalPricePerNight":796.04,"percentSavings":66.35,"drr":false}
             * hotelUrls : {"hotelInfositeUrl":"https%3A%2F%2Fwww.expedia.com%2Fgo%2Fhotel%2Finfo%2F4818574%2F2017-12-07%2F2017-12-18","hotelSearchResultUrl":"https%3A%2F%2Fwww.expedia.com%2Fgo%2Fhotel%2Fsearch%2FDestination%2F2017-12-07%2F2017-12-18%3FSearchType%3DDestination%26CityName%3DNew+York%26RegionId%3D178293%26Selected%3D4818574"}
             */

            private OfferDateRange offerDateRange;
            private Destincation destination;
            private HotelInfo hotelInfo;
            private HotelUrgencyInfo hotelUrgencyInfo;
            private HotelPricingInfo hotelPricingInfo;
            private HotelUrls hotelUrls;

            public OfferDateRange getOfferDateRange() {
                return offerDateRange;
            }

            public void setOfferDateRange(OfferDateRange offerDateRange) {
                this.offerDateRange = offerDateRange;
            }

            public Destincation getDestination() {
                return destination;
            }

            public void setDestination(Destincation destination) {
                this.destination = destination;
            }

            public HotelInfo getHotelInfo() {
                return hotelInfo;
            }

            public void setHotelInfo(HotelInfo hotelInfo) {
                this.hotelInfo = hotelInfo;
            }

            public HotelUrgencyInfo getHotelUrgencyInfo() {
                return hotelUrgencyInfo;
            }

            public void setHotelUrgencyInfo(HotelUrgencyInfo hotelUrgencyInfo) {
                this.hotelUrgencyInfo = hotelUrgencyInfo;
            }

            public HotelPricingInfo getHotelPricingInfo() {
                return hotelPricingInfo;
            }

            public void setHotelPricingInfo(HotelPricingInfo hotelPricingInfo) {
                this.hotelPricingInfo = hotelPricingInfo;
            }

            public HotelUrls getHotelUrls() {
                return hotelUrls;
            }

            public void setHotelUrls(HotelUrls hotelUrls) {
                this.hotelUrls = hotelUrls;
            }

            public static class OfferDateRange extends Webinizer {
                /**
                 * travelStartDate : [2017,12,7]
                 * travelEndDate : [2017,12,18]
                 * lengthOfStay : 11
                 */

                private List<Integer> travelStartDate;
                private List<Integer> travelEndDate;
                private int lengthOfStay;

                public int getLengthOfStay() {
                    return lengthOfStay;
                }

                public void setLengthOfStay(int lengthOfStay) {
                    this.lengthOfStay = lengthOfStay;
                }

                public List<Integer> getTravelStartDate() {
                    return travelStartDate;
                }

                public void setTravelStartDate(List<Integer> travelStartDate) {
                    this.travelStartDate = travelStartDate;
                }

                public List<Integer> getTravelEndDate() {
                    return travelEndDate;
                }

                public void setTravelEndDate(List<Integer> travelEndDate) {
                    this.travelEndDate = travelEndDate;
                }
            }

            public static class Destincation extends Webinizer {
                /**
                 * regionID : 178293
                 * associatedMultiCityRegionId : 178293
                 * longName : New York (and vicinity), New York, United States of America
                 * shortName : New York
                 * country : United States of America
                 * province : New York
                 * city : New York
                 * tla : NYC
                 * nonLocalizedCity : New York
                 */

                private String regionID;
                private String associatedMultiCityRegionId;
                private String longName;
                private String shortName;
                private String country;
                private String province;
                private String city;
                private String tla;
                private String nonLocalizedCity;

                public String getRegionID() {
                    return regionID;
                }

                public void setRegionID(String regionID) {
                    this.regionID = regionID;
                }

                public String getAssociatedMultiCityRegionId() {
                    return associatedMultiCityRegionId;
                }

                public void setAssociatedMultiCityRegionId(String associatedMultiCityRegionId) {
                    this.associatedMultiCityRegionId = associatedMultiCityRegionId;
                }

                public String getLongName() {
                    return longName;
                }

                public void setLongName(String longName) {
                    this.longName = longName;
                }

                public String getShortName() {
                    return shortName;
                }

                public void setShortName(String shortName) {
                    this.shortName = shortName;
                }

                public String getCountry() {
                    return country;
                }

                public void setCountry(String country) {
                    this.country = country;
                }

                public String getProvince() {
                    return province;
                }

                public void setProvince(String province) {
                    this.province = province;
                }

                public String getCity() {
                    return city;
                }

                public void setCity(String city) {
                    this.city = city;
                }

                public String getTla() {
                    return tla;
                }

                public void setTla(String tla) {
                    this.tla = tla;
                }

                public String getNonLocalizedCity() {
                    return nonLocalizedCity;
                }

                public void setNonLocalizedCity(String nonLocalizedCity) {
                    this.nonLocalizedCity = nonLocalizedCity;
                }
            }

            public static class HotelInfo extends Webinizer {
                /**
                 * hotelId : 4818574
                 * hotelName : the OUT NYC
                 * localizedHotelName : the OUT NYC
                 * hotelDestination : New York
                 * hotelDestinationRegionID : 2621
                 * hotelLongDestination : New York,NY,USA
                 * hotelStreetAddress : 510 W 42nd St
                 * hotelCity : New York
                 * hotelProvince : NY
                 * hotelCountryCode : USA
                 * hotelLatitude : 40.760007
                 * hotelLongitude : -73.996383
                 * hotelStarRating : 4.0
                 * hotelGuestReviewRating : 3.94
                 * hotelReviewTotal : 983
                 * hotelImageUrl : https://images.trvl-media.com/hotels/5000000/4820000/4818600/4818574/0138f487_t.jpg
                 * isOfficialRating : false
                 */

                private String hotelId;
                private String hotelName;
                private String localizedHotelName;
                private String hotelDestination;
                private String hotelDestinationRegionID;
                private String hotelLongDestination;
                private String hotelStreetAddress;
                private String hotelCity;
                private String hotelProvince;
                private String hotelCountryCode;
                private double hotelLatitude;
                private double hotelLongitude;
                private String hotelStarRating;
                private double hotelGuestReviewRating;
                private int hotelReviewTotal;
                private String hotelImageUrl;
                private boolean isOfficialRating;

                public String getHotelId() {
                    return hotelId;
                }

                public void setHotelId(String hotelId) {
                    this.hotelId = hotelId;
                }

                public String getHotelName() {
                    return hotelName;
                }

                public void setHotelName(String hotelName) {
                    this.hotelName = hotelName;
                }

                public String getLocalizedHotelName() {
                    return localizedHotelName;
                }

                public void setLocalizedHotelName(String localizedHotelName) {
                    this.localizedHotelName = localizedHotelName;
                }

                public String getHotelDestination() {
                    return hotelDestination;
                }

                public void setHotelDestination(String hotelDestination) {
                    this.hotelDestination = hotelDestination;
                }

                public String getHotelDestinationRegionID() {
                    return hotelDestinationRegionID;
                }

                public void setHotelDestinationRegionID(String hotelDestinationRegionID) {
                    this.hotelDestinationRegionID = hotelDestinationRegionID;
                }

                public String getHotelLongDestination() {
                    return hotelLongDestination;
                }

                public void setHotelLongDestination(String hotelLongDestination) {
                    this.hotelLongDestination = hotelLongDestination;
                }

                public String getHotelStreetAddress() {
                    return hotelStreetAddress;
                }

                public void setHotelStreetAddress(String hotelStreetAddress) {
                    this.hotelStreetAddress = hotelStreetAddress;
                }

                public String getHotelCity() {
                    return hotelCity;
                }

                public void setHotelCity(String hotelCity) {
                    this.hotelCity = hotelCity;
                }

                public String getHotelProvince() {
                    return hotelProvince;
                }

                public void setHotelProvince(String hotelProvince) {
                    this.hotelProvince = hotelProvince;
                }

                public String getHotelCountryCode() {
                    return hotelCountryCode;
                }

                public void setHotelCountryCode(String hotelCountryCode) {
                    this.hotelCountryCode = hotelCountryCode;
                }

                public double getHotelLatitude() {
                    return hotelLatitude;
                }

                public void setHotelLatitude(double hotelLatitude) {
                    this.hotelLatitude = hotelLatitude;
                }

                public double getHotelLongitude() {
                    return hotelLongitude;
                }

                public void setHotelLongitude(double hotelLongitude) {
                    this.hotelLongitude = hotelLongitude;
                }

                public String getHotelStarRating() {
                    return hotelStarRating;
                }

                public void setHotelStarRating(String hotelStarRating) {
                    this.hotelStarRating = hotelStarRating;
                }

                public double getHotelGuestReviewRating() {
                    return hotelGuestReviewRating;
                }

                public void setHotelGuestReviewRating(double hotelGuestReviewRating) {
                    this.hotelGuestReviewRating = hotelGuestReviewRating;
                }

                public int getHotelReviewTotal() {
                    return hotelReviewTotal;
                }

                public void setHotelReviewTotal(int hotelReviewTotal) {
                    this.hotelReviewTotal = hotelReviewTotal;
                }

                public String getHotelImageUrl() {
                    return hotelImageUrl;
                }

                public void setHotelImageUrl(String hotelImageUrl) {
                    this.hotelImageUrl = hotelImageUrl;
                }

                public boolean isIsOfficialRating() {
                    return isOfficialRating;
                }

                public void setIsOfficialRating(boolean isOfficialRating) {
                    this.isOfficialRating = isOfficialRating;
                }
            }

            public static class HotelUrgencyInfo extends Webinizer {
                /**
                 * airAttachRemainingTime : 0
                 * numberOfPeopleViewing : 32
                 * numberOfPeopleBooked : 0
                 * numberOfRoomsLeft : 49
                 * lastBookedTime : 1508873763309
                 * almostSoldStatus : AVAILABLE
                 * link : /hotel-Search#selected=4818574
                 * airAttachEnabled : false
                 */

                private int airAttachRemainingTime;
                private int numberOfPeopleViewing;
                private int numberOfPeopleBooked;
                private int numberOfRoomsLeft;
                private long lastBookedTime;
                private String almostSoldStatus;
                private String link;
                private boolean airAttachEnabled;

                public int getAirAttachRemainingTime() {
                    return airAttachRemainingTime;
                }

                public void setAirAttachRemainingTime(int airAttachRemainingTime) {
                    this.airAttachRemainingTime = airAttachRemainingTime;
                }

                public int getNumberOfPeopleViewing() {
                    return numberOfPeopleViewing;
                }

                public void setNumberOfPeopleViewing(int numberOfPeopleViewing) {
                    this.numberOfPeopleViewing = numberOfPeopleViewing;
                }

                public int getNumberOfPeopleBooked() {
                    return numberOfPeopleBooked;
                }

                public void setNumberOfPeopleBooked(int numberOfPeopleBooked) {
                    this.numberOfPeopleBooked = numberOfPeopleBooked;
                }

                public int getNumberOfRoomsLeft() {
                    return numberOfRoomsLeft;
                }

                public void setNumberOfRoomsLeft(int numberOfRoomsLeft) {
                    this.numberOfRoomsLeft = numberOfRoomsLeft;
                }

                public long getLastBookedTime() {
                    return lastBookedTime;
                }

                public void setLastBookedTime(long lastBookedTime) {
                    this.lastBookedTime = lastBookedTime;
                }

                public String getAlmostSoldStatus() {
                    return almostSoldStatus;
                }

                public void setAlmostSoldStatus(String almostSoldStatus) {
                    this.almostSoldStatus = almostSoldStatus;
                }

                public String getLink() {
                    return link;
                }

                public void setLink(String link) {
                    this.link = link;
                }

                public boolean isAirAttachEnabled() {
                    return airAttachEnabled;
                }

                public void setAirAttachEnabled(boolean airAttachEnabled) {
                    this.airAttachEnabled = airAttachEnabled;
                }
            }

            public static class HotelPricingInfo extends Webinizer {
                /**
                 * averagePriceValue : 267.87
                 * totalPriceValue : 2946.57
                 * crossOutPriceValue : 796.04
                 * originalPricePerNight : 796.04
                 * percentSavings : 66.35
                 * drr : false
                 */

                private double averagePriceValue;
                private double totalPriceValue;
                private double crossOutPriceValue;
                private double originalPricePerNight;
                private double percentSavings;
                private boolean drr;

                public double getAveragePriceValue() {
                    return averagePriceValue;
                }

                public void setAveragePriceValue(double averagePriceValue) {
                    this.averagePriceValue = averagePriceValue;
                }

                public double getTotalPriceValue() {
                    return totalPriceValue;
                }

                public void setTotalPriceValue(double totalPriceValue) {
                    this.totalPriceValue = totalPriceValue;
                }

                public double getCrossOutPriceValue() {
                    return crossOutPriceValue;
                }

                public void setCrossOutPriceValue(double crossOutPriceValue) {
                    this.crossOutPriceValue = crossOutPriceValue;
                }

                public double getOriginalPricePerNight() {
                    return originalPricePerNight;
                }

                public void setOriginalPricePerNight(double originalPricePerNight) {
                    this.originalPricePerNight = originalPricePerNight;
                }

                public double getPercentSavings() {
                    return percentSavings;
                }

                public void setPercentSavings(double percentSavings) {
                    this.percentSavings = percentSavings;
                }

                public boolean isDrr() {
                    return drr;
                }

                public void setDrr(boolean drr) {
                    this.drr = drr;
                }
            }

            public static class HotelUrls extends Webinizer {
                /**
                 * hotelInfositeUrl : https%3A%2F%2Fwww.expedia.com%2Fgo%2Fhotel%2Finfo%2F4818574%2F2017-12-07%2F2017-12-18
                 * hotelSearchResultUrl : https%3A%2F%2Fwww.expedia.com%2Fgo%2Fhotel%2Fsearch%2FDestination%2F2017-12-07%2F2017-12-18%3FSearchType%3DDestination%26CityName%3DNew+York%26RegionId%3D178293%26Selected%3D4818574
                 */

                private String hotelInfositeUrl;
                private String hotelSearchResultUrl;

                public String getHotelInfositeUrl() {
                    try {
                        return  java.net.URLDecoder.decode(hotelInfositeUrl, "UTF-8");
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                        return "";
                    }
                }

                public void setHotelInfositeUrl(String hotelInfositeUrl) {
                    this.hotelInfositeUrl = hotelInfositeUrl;
                }

                public String getHotelSearchResultUrl() {
                    try {
                        return java.net.URLDecoder.decode(hotelSearchResultUrl, "UTF-8");
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                        return "";
                    }
                }

                public void setHotelSearchResultUrl(String hotelSearchResultUrl) {
                    this.hotelSearchResultUrl = hotelSearchResultUrl;
                }
            }
        }
    }
}
