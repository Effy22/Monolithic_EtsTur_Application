package com.elif.constants;

public class RestApiUrl {
    private static final String VERSION = "/v1";
    private static final String API = "/api";
    private static final String TEST = "/test";
    private static final String DEV = "/dev";
    private static final String PROD = "/prod";

    private static final String ROOT = DEV + VERSION;
    public static final String AUTH = ROOT + "/auth";
    public static final String USER = ROOT + "/user";
    public static final String OTEL = ROOT + "/otel";
    public static final String RESERVATION = ROOT + "/reservation";


    public static final String CREATE_CATEGORY = "/create-category";
    public static final String CREATE_PROPERTIES = "/create-properties";
    public static final String CREATE_CATEGORY_PROPERTIES = "/create-category-properties";
    public static final String CREATE_ADDRESS = "/create-address";
    public static final String CREATE_ROOM = "/create-room";
    public static final String CREATE_IMAGE = "/create-image";
    public static final String CREATE_OTEL = "/create-otel";
    public static final String CREATE_TAG = "/create-tag";
    public static final String FIND_SEARCH = "/find-search";
    public static final String FIND_OTEL_BY_ID = "/find-otel-by-id";
    public static final String FIND_OTEL_BY_NAME = "/find-otel-by-name";
    public static final String FIND_OTEL_BY_ADDRESSNAME = "/find-otel-by-address-name";
    public static final String FILTER_LIST = "/filter-list";
    public static final String FIND_ALL = "/find-all";
    public static final String ACTIVATE_STATUS = "/activate-status";

    //FOR USER AND AUTH
    public static final String ADD_FAVOURITE = "/add-favourite";
    public static final String FIND_BY_TOKEN = "/find-by-token";
    public static final String GET_FAV_OTELS = "/get-fav-otels";
    public static final String UPDATE = "/update";
    public static final String REGISTER = "/register";
    public static final String LOGIN = "/login";

}
