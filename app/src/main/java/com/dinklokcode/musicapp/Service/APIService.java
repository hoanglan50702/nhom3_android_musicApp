package com.dinklokcode.musicapp.Service;

public class APIService {
    private static String base_url = "https://huy0212.000webhostapp.com/server";
    public static DataService getService() {
        return AIPRetrofitClient.getClient(base_url).create(DataService.class);
    }
}
