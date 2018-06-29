package com.example.android.tourguideapp;


class Location {

    /**
     * Title of the location
     */
    private String mTitle;

    /**
     * Address of the location
     */
    private String mAddress;

    /**
     * Business hours of the location
     */
    private String mBusinessHours;

    /**
     * Entrance price of the location
     */
    private String mEntrancePrice;

    /**
     * Description of the location
     */

    private String mDescription;

    /**
     * Photo of the location
     */
    private int mImageResourceId;

    /**
     * Constant value that represents no image was provided for this word
     */
    private static final int NO_IMAGE_PROVIDED = -1;

    /**
     * Create a new Location object.
     *
     * @param title           is the name of the location
     * @param address         is the address of the location
     * @param businessHours   is the working hours of the location
     * @param entrancePrice   is the list price for entering location
     * @param description     is the short description of the location
     * @param imageResourceId is the image of the location
     */
    public Location(String title, String address, String businessHours, String entrancePrice,
                    String description, int imageResourceId) {
        mTitle = title;
        mAddress = address;
        mBusinessHours = businessHours;
        mEntrancePrice = entrancePrice;
        mDescription = description;
        mImageResourceId = imageResourceId;
    }

    /**
     * Get the title of the location
     */
    public String getTitle() {
        return mTitle;
    }

    /**
     * Get the address of the location
     */
    public String getAddress() {
        return mAddress;
    }

    /**
     * Get the business hours of the location
     */
    public String getBusinessHours() {
        return mBusinessHours;
    }

    /**
     * Get the entrance price of the location
     */
    public String getPrice() {
        return mEntrancePrice;
    }

    /**
     * Get the description of the location
     */
    public String getDescription() {
        return mDescription;
    }

    /**
     * Get the image of the location
     */
    public int getImageResourceId() {
        return mImageResourceId;
    }

    /**
     * if perhaps there is no image
     */
    public boolean hasPhoto() {
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }
}


